# Bash recipe for Yocto Project
# This recipe builds the Bash shell

SUMMARY = "An sh-compatible command language interpreter"
DESCRIPTION = "The GNU Bourne Again shell (Bash) is a shell and command \
language interpreter that is compatible with the Bourne shell (sh). Bash \
is the default shell for the GNU system."

HOMEPAGE = "http://cnswww.cns.cwru.edu/~chet/bash/bashtop.html"
BUGTRACKER = "http://tiswww.case.edu/php/chet/bash/reportbug.html"

SECTION = "base/shell"
LICENSE = "MIT"
#LICENSE = "GPLv3+"
#LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS = "ncurses bison-native"
SRC_URI = "${GNU_MIRROR}/bash/${BP}.tar.gz \
           "