FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append := " \
    file://system.conf \
    file://rpi_autoboot \
    file://rauc-grow-data-partition.service \
"

RDEPENDS:${PN}:append = " bash "

do_install:append() {
    install -d ${D}/etc/rauc/
    install -m 0755 ${WORKDIR}/rpi_autoboot ${D}/etc/rauc/
}
