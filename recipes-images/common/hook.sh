#!/bin/sh

set -x
set -e

PARTITION_OFFSET=3

case "$1" in
        slot-post-install)
                if [ "$RAUC_SLOT_CLASS" == "bootfs" ] ; then
                        ROOTFS=/dev/mmcblk0p$(($RAUC_SLOT_BOOTNAME+$PARTITION_OFFSET))
                        sed -i "s|root=/dev/mmcblk0p[0-9]|root=$ROOTFS rauc.slot=$RAUC_SLOT_BOOTNAME|" "$RAUC_SLOT_MOUNT_POINT/cmdline.txt"
                elif [ "$RAUC_SLOT_CLASS" == "rootfs" ] ; then
                        BOOT_PARTITION=$RAUC_SLOT_BOOTNAME
                        sed -i "s|/dev/mmcblk0p.*/boot[[:space:]]|/dev/mmcblk0p${BOOT_PARTITION} /boot |" "$RAUC_SLOT_MOUNT_POINT/etc/fstab"
                fi
                ;;
        *)
                exit 1
                ;;
esac

exit 0