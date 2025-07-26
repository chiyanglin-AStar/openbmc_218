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

[next doc](https://github.com/chiyanglin-AStar/openbmc_218/meta-yourcompany/meta-yourmachine/README)
