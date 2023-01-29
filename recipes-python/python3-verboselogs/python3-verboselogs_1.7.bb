DESCRIPTION = "The verboselogs package extends Python’s logging module to add the log levels NOTICE, SPAM, SUCCESS and VERBOSE:"
HOMEPAGE = "https://verboselogs.readthedocs.io"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d4b9bfd363e871d2be165d0372c0169f"

SRC_URI[sha256sum] = "e33ddedcdfdafcb3a174701150430b11b46ceb64c2a9a26198c76a156568e427"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
