
RAUC_BUNDLE_SLOTS = "bootfs rootfs "

RAUC_SLOT_rootfs[type] ?= "image"
RAUC_SLOT_rootfs[fstype] ?= "root.ext4"
RAUC_SLOT_rootfs[file] ?= "${RAUC_SLOT_rootfs}-${MACHINE}.root.ext4"
RAUC_SLOT_rootfs[hooks] = "post-install"
RAUC_SLOT_rootfs[adaptive] = "block-hash-index"

RAUC_SLOT_bootfs[type] ?= "image"
RAUC_SLOT_bootfs[fstype] ?= "boot.vfat"
RAUC_SLOT_bootfs[file] ?= "${RAUC_SLOT_rootfs}-${MACHINE}.boot.vfat"
RAUC_SLOT_bootfs[hooks] = "post-install"
RAUC_SLOT_bootfs[adaptive] = "block-hash-index"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
FILESEXTRAPATHS:prepend := "${THISDIR}/../common/:"
SRC_URI += " file://hook.sh"
RAUC_BUNDLE_HOOKS[file] = "hook.sh"

RAUC_BUNDLE_FORMAT = 'verity'
