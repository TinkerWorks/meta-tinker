FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append := " \
    file://system.conf \
    file://rpi_autoboot \
    file://rauc-grow-data-partition.service \
"

RDEPENDS:${PN}:append = " bash "
RDEPENDS:${PN}:remove = " u-boot-fw-utils u-boot-env "

do_install:append() {
    install -d ${D}/etc/rauc/
    install -m 0755 ${UNPACKDIR}/rpi_autoboot ${D}/etc/rauc/
}
