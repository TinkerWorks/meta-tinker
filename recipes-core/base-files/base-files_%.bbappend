FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append := " \
    file://fstab \
    "

do_install:append() {
    install -d ${D}/data
    mv ${D}${sysconfdir}/hostname ${D}/data/hostname
    ln -sf /data/hostname ${D}${sysconfdir}/hostname

    install -d ${D}/autoboot
}
