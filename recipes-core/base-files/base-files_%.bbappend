
#hostname:pn-base-files = "my-host-name"

do_install:append() {
    mv ${D}${sysconfdir}/hostname ${D}/data/hostname
    ln -sf /data/hostname ${D}${sysconfdir}/hostname
}
