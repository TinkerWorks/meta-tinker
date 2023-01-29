inherit core-image

RAUC_BUNDLE_COMPATIBLE = "HomeSensorHub ${MACHINE}"

require homesensorhub.inc

rauc_fix_system_conf() {
    cat ${IMAGE_ROOTFS}/etc/rauc/system.conf
    sed -i -e 's/compatible=.*/compatible=${RAUC_BUNDLE_COMPATIBLE}/' ${IMAGE_ROOTFS}/etc/rauc/system.conf
    cat ${IMAGE_ROOTFS}/etc/rauc/system.conf
}

IMAGE_PREPROCESS_COMMAND:append = " rauc_fix_system_conf "
