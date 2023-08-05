IMAGE_INSTALL:append = " rauc "
IMAGE_INSTALL:append = " rauc-grow-data-part "

IMAGE_INSTALL:append = " networkmanager "

IMAGE_INSTALL:append = " python3 "

IMAGE_INSTALL:append = " rsync "
IMAGE_INSTALL:append = " htop atop vnstat "
IMAGE_INSTALL:append = " iperf3 "
IMAGE_INSTALL:append = " util-linux-lsblk "
IMAGE_INSTALL:append = " i2c-tools "

IMAGE_FEATURES:append = " ssh-server-openssh "

IMAGE_FEATURES:remove = " splash "
IMAGE_FEATURES:remove = " psplash "

IMAGE_FEATURES:append = "read-only-rootfs"

EXTRA_IMAGE_FEATURES:append = " debug-tweaks "

IMAGE_INSTALL:append = " watchdog "
RPI_EXTRA_CONFIG = ' \n \
    # Raspberry Pi Watchdog \n \
    dtparam=watchdog=on \n \
    '

WKS_FILE = "sdimage-dual-homesensorhub.wks.in"

IMAGE_FSTYPES:append = " boot root "

rauc_fix_system_conf() {
    cat ${IMAGE_ROOTFS}/etc/rauc/system.conf
    sed -i -e 's/compatible=.*/compatible=${RAUC_BUNDLE_COMPATIBLE}/' ${IMAGE_ROOTFS}/etc/rauc/system.conf
    cat ${IMAGE_ROOTFS}/etc/rauc/system.conf
}

IMAGE_PREPROCESS_COMMAND:append = " rauc_fix_system_conf "
