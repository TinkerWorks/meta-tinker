inherit core-image

require name.inc

require ../common/image.inc

IMAGE_INSTALL:append = " homesensorhub "

IMAGE_INSTALL:append = " alsa-utils "
IMAGE_INSTALL:append = " git "
IMAGE_INSTALL:append = " alsa-utils "
IMAGE_INSTALL:append = " python3-pip "
IMAGE_INSTALL:append = " ffmpeg "

IMAGE_INSTALL:append = " pulseaudio pulseaudio-server pulseaudio-misc pulseaudio-module-alsa-card pulseaudio-module-alsa-source pulseaudio-module-alsa-sink pulseaudio-module-cli "
