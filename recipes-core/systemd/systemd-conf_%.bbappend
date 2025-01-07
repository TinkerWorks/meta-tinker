
do_install:append() {
    echo "[Manager]"              >> ${D}${systemd_unitdir}/system.conf.d/watchdog.conf
    echo "RuntimeWatchdogSec=10"  >> ${D}${systemd_unitdir}/system.conf.d/watchdog.conf
    echo "RebootWatchdogSec=3min" >> ${D}${systemd_unitdir}/system.conf.d/watchdog.conf
}