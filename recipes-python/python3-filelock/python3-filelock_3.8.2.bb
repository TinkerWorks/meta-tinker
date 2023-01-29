# Copyright (C) 2023 Alexandru-Sever Horin <alex.sever.h@tinker.works>
# Released under the MIT License (see COPYING.MIT for the terms)
DESCRIPTION = "This package contains a single module, which implements a platform independent file lock in Python, which provides a simple way of inter-process communication"
HOMEPAGE = "https://github.com/tox-dev/py-filelock"
LICENSE = "Unlicense"
SECTION = "devel/python"
LIC_FILES_CHKSUM = "file://LICENSE;md5=911690f51af322440237a253d695d19f"

SRC_URI[sha256sum] = "7565f628ea56bfcd8e54e42bdc55da899c85c1abfe1b5bcfd147e9188cebb3b2"

inherit pypi setuptools3
