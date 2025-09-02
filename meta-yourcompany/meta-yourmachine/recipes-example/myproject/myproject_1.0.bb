SUMMARY = "MyProject - A simple C++ project using CMake"
DESCRIPTION = "This is a simple multi-source C++ project using CMake build system"
#LICENSE = "MIT"
SECTION = "examples" 
LICENSE = "CLOSED" 
PR = "r0"

SRC_URI = "file://CMakeLists.txt \
           file://main.cpp \
           file://utils/helper.cpp \
           file://utils/helper.h \
           file://math/calculator.cpp \
           file://math/calculator.h"

# S = "${WORKDIR}"
S = "${UNPACKDIR}"

inherit cmake

# 如果需要安裝執行檔
do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/MyProject ${D}${bindir}/myproject.out
}