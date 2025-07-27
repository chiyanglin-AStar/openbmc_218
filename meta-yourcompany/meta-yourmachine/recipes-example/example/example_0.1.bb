SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"
inherit debug_info 
python do_display_banner() {
    bb.plain("***********************************************");
    bb.plain("*    in Machine                               *");
    bb.plain("*  Example recipe created by bitbake-layers   *");
    bb.plain("*                                             *");
    bb.plain("***********************************************");
}

python do_unpack:append() {
    #print("Hello, this is a debug message from machine example bb - do_unpack")	
    bb.warn("Hello, this is a debug message from machine example bb - do_unpack")
}

do_install:append(){
    bbwarn "Hello, this is a debug message from machine example bb - do_install"
}

do_configure:append(){
    bbwarn "Hello, this is a debug message from machine example bb - do_configure"
}

do_compile:append(){
	bbwarn "Hello, this is a debug message from machine example bb - do_compile"
}

do_build:append(){
	bbwarn "Hello, this is a debug message from machine example bb - do_build"
}

addtask display_banner before do_build
#addtask do_debug_info before do_build
addtask display_banner before do_debug_info
