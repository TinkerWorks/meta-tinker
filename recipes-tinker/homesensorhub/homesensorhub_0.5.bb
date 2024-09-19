SUMMARY = "HomeSensorHub"
DESCRIPTION = "HomeSensorHub recipe "
HOMEPAGE = "https://github.com/TinkerWorks/HomeSensorHub"
SECTION = "devel/python"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = " git://github.com/TinkerWorks/HomeSensorHub.git;branch=master;protocol=https \
            file://homesensorhub.service "
SRCREV = "${AUTOREV}"
PV = "0.5+git${SRCPV}"

S = "${WORKDIR}/git"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_PACKAGES += "${PN}"
SYSTEMD_SERVICE:${PN} = "homesensorhub.service"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

inherit python_setuptools_build_meta systemd

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
    	install -d ${D}${systemd_system_unitdir}/
        install -m 0644 ${UNPACKDIR}/homesensorhub.service ${D}${systemd_system_unitdir}/
    fi
}

FILES:${PN} += "${systemd_system_unitdir}/homesensorhub.service"

RDEPENDS:${PN} = " python3-core \
                   python3-paho-mqtt \
                   python3-smbus \
                   python3-filelock \
                   python3-adafruit-circuitpython-bme280 \
                   python3-adafruit-circuitpython-bme680 \
                   python3-adafruit-circuitpython-typing \
                   python3-coloredlogs \
                   python3-verboselogs"
