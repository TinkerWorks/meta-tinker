BOOT_PART_SIZE_MB ?= "128"
ROOTFS_PART_SIZE_MB ?= "1536"

rootfsdir = "${WORKDIR}/root"
bootdir = "${IMAGE_ROOTFS}/boot"

def check_size_limits(d):
    import os, subprocess

    for p in ['rootfs', 'boot']:
        max_size = int(d.getVar(p.upper() + '_PART_SIZE_MB'))
        dir = os.path.join(d.getVar('IMAGE_ROOTFS'), d.getVar(p + 'dir'))
        actual_size = int(subprocess.check_output(['du', '-ms', dir]).split()[0])

        if actual_size > max_size:
            bb.fatal("The %s image size (%d MB) exceeds %s_PART_SIZE_MB of (%d MB)" % \
                (p, actual_size, p.upper(), max_size))


fakeroot python do_populate_mountpoints() {
    import logging
    import os
    import shutil
    import sys

    from oe.path import copytree

    basedir = d.getVar('IMAGE_ROOTFS')
    rootfsdir = d.getVar('rootfsdir')

    if os.path.lexists(rootfsdir):
        shutil.rmtree(rootfsdir)

    copytree(basedir, rootfsdir)
    for m in ['boot']:
        full_path = os.path.join(rootfsdir, m)
        for entry in os.listdir(full_path):
            full_entry = os.path.join(full_path, entry)
            if os.path.isdir(full_entry) and not os.path.islink(full_entry):
                shutil.rmtree(full_entry)
            else:
                os.remove(full_entry)

    check_size_limits(d)
}

IMAGE_CMD:root() {
	dd if=/dev/zero of="${WORKDIR}/root.ext4" count=0 bs=1M seek=${ROOTFS_PART_SIZE_MB}
	mkfs.ext4 -F -i 4096 "${WORKDIR}/root.ext4" -d "${WORKDIR}/root" -L root
	install -m 0644 "${WORKDIR}/root.ext4" "${IMGDEPLOYDIR}/${IMAGE_NAME}.root.ext4"
	ln -sfn "${IMAGE_NAME}.root.ext4" "${IMGDEPLOYDIR}/${IMAGE_BASENAME}-${MACHINE}.root.ext4"
}

IMAGE_CMD:boot() {
    dd if=/dev/zero of="${WORKDIR}/boot.vfat" count=0 bs=1M seek=${BOOT_PART_SIZE_MB}
    mkfs.vfat "${WORKDIR}/boot.vfat" -n boot

    echo "IMAGE_BOOT_FILES = ${IMAGE_BOOT_FILES}"

    for f in $(echo "${IMAGE_BOOT_FILES}" | sed 's|;|:|g'); do
        echo "f = ${f}"
        origin=$(echo $f | cut -d ":" -f 1)
        destination=$(echo $f | cut -d ":" -s -f 2)
        destination_dir=$(dirname "${destination}")
        mmd -i "${WORKDIR}/boot.vfat" ::/${destination_dir} || true
        mcopy -i "${WORKDIR}/boot.vfat" -s ${DEPLOY_DIR_IMAGE}/${origin} ::/${destination}
    done

    mcopy -i "${WORKDIR}/boot.vfat" -s ${IMAGE_ROOTFS}/boot/* ::/
    install -m 0644 "${WORKDIR}/boot.vfat" "${IMGDEPLOYDIR}/${IMAGE_NAME}.boot.vfat"
	ln -sfn "${IMAGE_NAME}.boot.vfat" "${IMGDEPLOYDIR}/${IMAGE_BASENAME}-${MACHINE}.boot.vfat"
}

addtask do_populate_mountpoints after do_rootfs before do_image_root do_image_boot

do_image_root[depends] += "e2fsprogs-native:do_populate_sysroot"
do_image_boot[depends] += "e2fsprogs-native:do_populate_sysroot"

do_image_root[deptask] = "do_populate_mountpoints do_image"
do_image_boot[deptask] = "do_populate_mountpoints do_image"

do_populate_mountpoints[depends] += "virtual/fakeroot-native:do_populate_sysroot"
do_populate_mountpoints[deptask] = "do_rootfs"

do_image_root[respect_exclude_path] = "0"
do_image_boot[respect_exclude_path] = "0"
