SUMMARY = "HeatMaster"
DESCRIPTION = "Heat Master recipe "
HOMEPAGE = "https://github.com/TinkerWorks/HeatMaster"
SECTION = "devel/python"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = " git://github.com/TinkerWorks/HeatMaster.git;branch=master;protocol=https \
            file://heatmaster.service "
SRCREV = "${AUTOREV}"
PV = "0.5+git${SRCPV}"

S = "${WORKDIR}/git"

SYSTEMD_SERVICE = " heatmaster.service "

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

inherit python_setuptools_build_meta

do_install:append() {
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -m 0755 -d ${D}${systemd_unitdir}/system ${D}${libdir}/tmpfiles.d
        install -m 0644 ${WORKDIR}/heatmaster.service ${D}${systemd_unitdir}/system/
    fi
}

FILES:${PN} += "${systemd_unitdir}/system/heatmaster.service ${libdir} "

RDEPENDS:${PN} = " python3-core \
                   python3-paho-mqtt \
                   python3-requests \
                   python3-coloredlogs \
                   python3-verboselogs \
                   python3-termcolor \
                   python3-ratelimit \
                   python3-setuptools"
