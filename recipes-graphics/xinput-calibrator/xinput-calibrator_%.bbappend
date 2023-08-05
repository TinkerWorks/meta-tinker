do_install:prepend() {
    sed -i 's|/etc/pointercal.xinput|/data/pointercal.xinput|' ${S}/scripts/xinput_calibrator_pointercal.sh
}
