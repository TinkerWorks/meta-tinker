INHIBIT_SYSROOT_STRIP = "1"
INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INSANE_SKIP:${PN} += " arch file-rdeps "

do_install:append() {
  find ${D}${PYTHON_SITEPACKAGES_DIR}/adafruit_blinka/microcontroller -iname "libgpiod_pulsein*" | xargs rm
}