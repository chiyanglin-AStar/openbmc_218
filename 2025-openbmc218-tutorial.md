## openbmc_218
### get openbmc 2.18 recipe code
```shell
wget https://github.com/openbmc/openbmc/archive/refs/tags/2.18.0.zip

unzip 2.18.0.zip

cd ./openbmc-2.18.0/
```
***install the packages of openbmc that need :***
```shell
sudo apt install git gcc g++ make file wget gawk diffstat bzip2 cpio chrpath zstd lz4 bzip2
```

### setup machine environment variable
```shell
. setup romulus build
```
add sharefolder path into ./conf/local.conf
```shell
SSTATE_DIR ?= "/home/codingcoffee_01/share_folder/sstate-cache"
DL_DIR ?= "/home/codingcoffee_01/share_folder/downloads"

bitbake u-boot-aspeed-sdk
```
***if your environment need install latest python***
```shell
sudo apt install -y software-properties-common

sudo apt-get update -y

sudo add-apt-repository -y ppa:deadsnakes/ppa

sudo apt-get update && apt-cache search python3.1

sudo apt-get install python3.1x -y

sudo ln -s /usr/bin/python3.1x /usr/bin/python
sudo ln -s /usr/bin/python3.1x /usr/bin/python3

bitbake u-boot-aspeed-sdk
```

[next doc](https://github.com/chiyanglin-AStar/openbmc_218/blob/main/meta-yourcompany/meta-yourmachine/README.md)


### ***bitbake -f  u-boot-aspeed-sdk -c compile ==> Debug message:*** 
```shell
WARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_debug_info2: Debug info .................... 
WARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_debug_info2: SRC_URI look like: ['git://git@github.com/openbmc/u-boot.git;nobranch=1;protocol=https', 'file://rsa_oem_dss_key.pem;sha256sum=64a379979200d39949d3e5b0038e3fdd5548600b2f7077a17e35422336075ad4', 'file://rsa_pub_oem_dss_key.pem;sha256sum=40132a694a10af2d1b094b1cb5adab4d6b4db2a35e02d848b2b6a85e60738264', 'file://user/', 'file://u-boot_flash_64M.cfg']
WARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_debug_info2: PN look like: ['u-boot-aspeed-sdk']
WARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_unpack: Hello, this is a debug message from u-boot bbapend - do_unpack
WARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_configure: Hello, this is a debug message from u-boot bbapend - do_configure
WARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_compile: Hello, this is a debug message from u-boot bbapend - do_compileWARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_debug_info2: Debug info .................... 
WARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_debug_info2: SRC_URI look like: ['git://git@github.com/openbmc/u-boot.git;nobranch=1;protocol=https', 'file://rsa_oem_dss_key.pem;sha256sum=64a379979200d39949d3e5b0038e3fdd5548600b2f7077a17e35422336075ad4', 'file://rsa_pub_oem_dss_key.pem;sha256sum=40132a694a10af2d1b094b1cb5adab4d6b4db2a35e02d848b2b6a85e60738264', 'file://user/', 'file://u-boot_flash_64M.cfg']
WARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_debug_info2: PN look like: ['u-boot-aspeed-sdk']
WARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_unpack: Hello, this is a debug message from u-boot bbapend - do_unpack
WARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_configure: Hello, this is a debug message from u-boot bbapend - do_configure
WARNING: u-boot-aspeed-sdk-1_v2019.04+git-r0 do_compile: Hello, this is a debug message from u-boot bbapend - do_compile
```