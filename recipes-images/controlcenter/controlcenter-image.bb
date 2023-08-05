inherit core-image extrausers features_check

require name.inc

require ../common/image.inc

EXTRA_USERS_PARAMS:append = "useradd -m panel;"

IMAGE_INSTALL:append = " chromium-x11 "

IMAGE_FEATURES:append = " x11-base hwcodecs"
REQUIRED_DISTRO_FEATURES = "x11"

IMAGE_INSTALL:append = " panel "

QB_MEM = '${@bb.utils.contains("DISTRO_FEATURES", "opengl", "-m 512", "-m 256", d)}'
