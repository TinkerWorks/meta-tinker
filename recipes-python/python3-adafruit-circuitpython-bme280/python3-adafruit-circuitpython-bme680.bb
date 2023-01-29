# Copyright (C) 2023 Alexandru-Sever Horin <alex.sever.h@tinker.works>
# Released under the MIT License (see COPYING.MIT for the terms)
DESCRIPTION = "I2C and SPI driver for the Bosch BME680 Temperature, Humidity, and Barometric Pressure sensor"
HOMEPAGE = "https://github.com/adafruit/Adafruit_CircuitPython_BME680"
LICENSE = "MIT"
SECTION = "devel/python"
LIC_FILES_CHKSUM = "file://LICENSE;md5=59d38d9aef0f1ce6e125ff8c2831a249"

SRC_URI = "git://github.com/adafruit/Adafruit_CircuitPython_BME680.git;branch=main;protocol=https"
SRCREV = "84f91666ffa4330bdcc26eca906b79fa94a3d824"
S = "${WORKDIR}/git"

DEPENDS += "python3-setuptools-scm-native"

inherit python_setuptools_build_meta

RDEPENDS:${PN} += "python3-core python3-adafruit-blinka python3-adafruit-circuitpython-busdevice"
