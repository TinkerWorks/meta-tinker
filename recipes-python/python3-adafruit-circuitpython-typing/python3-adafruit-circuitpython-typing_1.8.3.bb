SUMMARY = "Definitions not in the standard typing module that are needed for type annotation of CircuitPython code."
HOMEPAGE = "https://github.com/adafruit/Adafruit_CircuitPython_Typing"
LICENSE = "MIT"
SECTION = "devel/python"
DEPENDS = ""
LIC_FILES_CHKSUM = "file://LICENSE;md5=a089cc2176ad7f6066833cbef57695b0"

SRC_URI[sha256sum] = "6c1c2db749a7daa1528548cb899397bf4793895c80ffe2a7ce0922ad3aeabf01"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "python3-core python3-typing-extensions"
