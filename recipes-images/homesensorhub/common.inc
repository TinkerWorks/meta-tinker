RPI_USE_U_BOOT = "1"

IMAGE_INSTALL:append = " networkmanager "

IMAGE_INSTALL:append = " python3 "

IMAGE_INSTALL:append = " rsync "
IMAGE_INSTALL:append = " htop atop "
IMAGE_INSTALL:append = " iperf3 "
IMAGE_INSTALL:append = " util-linux-lsblk "

IMAGE_INSTALL:append = " rauc-grow-data-part "

IMAGE_FEATURES:append = " ssh-server-openssh "

IMAGE_FEATURES:remove = " splash "
IMAGE_FEATURES:remove = " psplash "

IMAGE_FEATURES:append = "read-only-rootfs"

# Settings for meta-rauc-raspberry-pi
IMAGE_INSTALL:append = " rauc"
IMAGE_FSTYPES:append = " ext4"
WKS_FILE = "sdimage-dual-homesensorhub.wks.in"

EXTRA_IMAGE_FEATURES:append = " debug-tweaks "



IMAGE_INSTALL:append = " watchdog "
RPI_EXTRA_CONFIG = ' \n \
    # Raspberry Pi Watchdog \n \
    dtparam=watchdog=on \n \
    '
