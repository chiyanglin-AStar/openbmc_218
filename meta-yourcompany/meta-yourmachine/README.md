## Create BSP and Machine Layer

```shell
bitbake-layers create-layer ../meta-yourcompany

bitbake-layers create-layer ../meta-yourcompany/meta-yourmachine

bitbake-layers add-layer ../meta-yourcompany

bitbake-layers add-layer ../meta-yourcompany/meta-yourmachine

mkdir -p ./meta-yourcompany/meta-yourmachine/conf/templates

mkdir -p ./meta-yourcompany/meta-yourmachine/conf/machine

cp -r ../meta-evb/meta-evb-aspeed/meta-evb-ast2600/conf/templates/* ../meta-yourcompany/meta-yourmachine/conf/templates/

cp -r ../meta-evb/meta-evb-aspeed/meta-evb-ast2600/conf/machine/* ../meta-yourcompany/meta-yourmachine/conf/machine/

cp  ../meta-evb/meta-evb-aspeed/meta-evb-ast2600/conf/machine/evb-ast2600.conf ../meta-yourcompany/meta-yourmachine/conf/machine/yourmachine.conf

```

### modified meta-yourcompany/meta-yourmachine/conf/templates/default/bblayers.conf.sample
```shell
##OEROOT##/meta-phosphor \
##OEROOT##/meta-aspeed \
##OEROOT##/meta-yourcompany/meta-yourmachine \ 


. setup yourmachine build

````




This README file contains information on the contents of the meta-yourmachine layer.

Please see the corresponding sections below for details.

Dependencies
============

  URI: <first dependency>
  branch: <branch name>

  URI: <second dependency>
  branch: <branch name>

  .
  .
  .

Patches
=======

Please submit any patches against the meta-yourmachine layer to the xxxx mailing list (xxxx@zzzz.org)
and cc: the maintainer:

Maintainer: XXX YYYYYY <xxx.yyyyyy@zzzzz.com>

Table of Contents
=================

  I. Adding the meta-yourmachine layer to your build
 II. Misc


I. Adding the meta-yourmachine layer to your build
=================================================

Run 'bitbake-layers add-layer meta-yourmachine'

II. Misc
========

--- replace with specific information about the meta-yourmachine layer ---
