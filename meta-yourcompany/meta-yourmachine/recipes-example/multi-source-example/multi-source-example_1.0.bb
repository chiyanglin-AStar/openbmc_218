SUMMARY = "Example recipe using Meson with multiple source files"
#LICENSE = "MIT"
#LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835c6f0c6f5c6c6f6c6f6c6f6c6f6c6"

SECTION = "examples" 
LICENSE = "CLOSED"

SRC_URI = "file://meson.build \
           file://src/main.c \
           file://src/foo.c \
           file://src/bar.c \
           file://include/foo.h \
           file://include/bar.h"

#S = "${WORKDIR}"
S = "${UNPACKDIR}"
inherit meson

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/my_app ${D}${bindir}/my_app
}
