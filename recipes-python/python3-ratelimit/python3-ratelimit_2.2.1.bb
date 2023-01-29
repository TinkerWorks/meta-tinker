DESCRIPTION = "This packages introduces a function decorator preventing a function from being called more often than that allowed by the API provider. This should prevent API providers from banning your applications by conforming to their rate limits."
HOMEPAGE = "https://github.com/tomasbasham/ratelimit"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=79a571aea266911f7ab2e20dd50bd096"

SRC_URI[sha256sum] = "af8a9b64b821529aca09ebaf6d8d279100d766f19e90b5059ac6a718ca6dee42"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
