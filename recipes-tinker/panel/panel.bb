# Copyright (C) 2023 Alexandru-Sever Horin <alex.sever.h@tinker.works>
# Released under the MIT License (see COPYING.MIT for the terms)
SUMMARY = "Kiosk"

LICENSE = "CLOSED"

RDEPENDS:${PN} = " mini-x-session matchbox-keyboard "

SRC_URI:append = " file://session"
FILES_${PN} += " ${sysconfdir}/mini_x/session"

do_install() {
    install -d ${D}${sysconfdir}/mini_x
    install -m 755 ${WORKDIR}/session ${D}${sysconfdir}/mini_x/session
}
