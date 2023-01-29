FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI:append := " file://system.conf"


#do_install:prepend() {
#    sed -i -e 's\%%MACHINE%%\${RAUC_BUNDLE_COMPATIBLE}\' ${WORKDIR}/system.conf
#    echo ${RAUC_BUNDLE_COMPATIBLE}
#    asdasasdasd
#}
