inherit bundle

RAUC_BUNDLE_COMPATIBLE = "HomeSensorHub ${MACHINE}"

RAUC_BUNDLE_SLOTS = "rootfs"
RAUC_SLOT_rootfs ?= "homesensorhub-image"

RAUC_KEY_FILE = "${THISDIR}/files/development-1.key.pem"
RAUC_CERT_FILE = "${THISDIR}/files/development-1.cert.pem"

RAUC_BUNDLE_FORMAT = 'plain'
