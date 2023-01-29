SUMMARY = "CircuitPython APIs for non-CircuitPython versions of Python such as CPython on Linux and MicroPython."
HOMEPAGE = "https://github.com/adafruit/Adafruit_Blinka"
LICENSE = "MIT"
SECTION = "devel/python"
DEPENDS = ""
LIC_FILES_CHKSUM = "file://LICENSE;md5=fccd531dce4b989c05173925f0bbb76c"

SRC_URI[sha256sum] = "958e90b92c3cb381c88a111943d85ca3442116b82581998ffce3d4077a9cd19e"

PYPI_PACKAGE = "Adafruit-Blinka"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

inherit pypi python_setuptools_build_meta

do_install:append() {
# it ships ./bcm283x/pulseio/libgpiod_pulsein which is a prebuilt
# 32bit binary therefore we should make this specific to 32bit rpi machines (based on bcm283x) only
    if [ ${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '1', '0', d)} = "0" ]; then
        rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/adafruit_blinka/microcontroller/bcm283x
    fi
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/adafruit_blinka/microcontroller/amlogic
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/adafruit_blinka/microcontroller/bcm283x/pulseio/*64
}

RDEPENDS:${PN} += " \
    libgpiod \
    python3-adafruit-circuitpython-typing \
    python3-adafruit-platformdetect \
    python3-adafruit-pureio \
    python3-core \
"

RDEPENDS:${PN}:append:rpi = " rpi-gpio"

COMPATIBLE_HOST:libc-musl:class-target = "null"

