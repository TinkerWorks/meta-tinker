
#hostname:pn-base-files = "my-host-name"

do_install:append() {
    install -d ${D}/data
    mv ${D}${sysconfdir}/hostname ${D}/data/hostname
    ln -sf /data/hostname ${D}${sysconfdir}/hostname
}
