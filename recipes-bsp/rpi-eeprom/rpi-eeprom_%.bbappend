
do_install:prepend() {
    sed -i 's|BOOTFS=/boot|BOOTFS=/autoboot|' ${S}/rpi-eeprom-update-default
}