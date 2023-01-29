# Copyright (C) 2023 Alexandru-Sever Horin <alex.sever.h@tinker.works>
# Released under the MIT License (see COPYING.MIT for the terms)
DESCRIPTION = "I2C and SPI driver for the Bosch BME280 Temperature, Humidity, and Barometric Pressure sensor"
HOMEPAGE = "https://github.com/adafruit/Adafruit_CircuitPython_BME280"
LICENSE = "MIT"
SECTION = "devel/python"
LIC_FILES_CHKSUM = "file://LICENSE;md5=59d38d9aef0f1ce6e125ff8c2831a249"

SRC_URI = "git://github.com/adafruit/Adafruit_CircuitPython_BME280.git;branch=main;protocol=https"
SRCREV = "d390b3ae9298abbe3655816dc048426d007bd7dc"
S = "${WORKDIR}/git"

DEPENDS += "python3-setuptools-scm-native"

inherit python_setuptools_build_meta

RDEPENDS:${PN} += "python3-core python3-adafruit-blinka python3-adafruit-circuitpython-busdevice"
