This README file contains information on the contents of the
filesystems layer.

Please see the corresponding sections below for details.


Dependencies
============

This layer depends on:

  URI: git://git.openembedded.org/openembedded-core
  layers: meta
  branch: walnascar

  URI: git://git.openembedded.org/meta-openembedded
  layers: meta-oe
  branch: walnascar

Patches
=======

Please submit any patches against the filesystems layer to the
OpenEmbedded development mailing list (openembedded-devel@lists.openembedded.org)
with '[meta-filesystems][walnascar]' in the subject.

Layer maintainer: Armin Kuster <akuster808@gmail.com>

When sending single patches, please use something like:

   git send-email -1 -M \
        --to openembedded-devel@lists.openembedded.org \
        --subject-prefix='meta-filesystems][walnascar][PATCH'


Table of Contents
=================

  I. Adding the filesystems layer to your build
 II. Misc


I. Adding the filesystems layer to your build
=================================================

In order to use this layer, you need to make the build system aware of
it.

Assuming the filesystems layer exists at the top-level of your
yocto build tree, you can add it to the build system by adding the
location of the filesystems layer to bblayers.conf, along with any
other layers needed. e.g.:

  BBLAYERS ?= " \
    /path/to/yocto/meta \
    /path/to/yocto/meta-oe \
    /path/to/yocto/meta-filesystems \
    "


II. Misc
========

  --- physfs ---
  A library to provide abstract access to various archives

  --- fuse ---
  Filesystem in Userspace (FUSE) is a simple interface for userspace programs
  to export a virtual filesystem to the Linux kernel.

  --- ifuse ---
  A fuse filesystem to access the contents of an iPhone or iPod Touch

  --- sshfs-fuse ---
  A filesystem client based on the SSH File Transfer Protocol

  --- owfs ---
  An easy way to use the 1-Wire file system

  --- ntfs-3g-ntfsprogs ---
  The ntfs-3g is a freely available read/write NTFS driver for Linux and
  ntfsprogs includes utilities for doing all required tasks to NTFS partitions.

  --- cramfs ---
  Builds cramfs filesystems for embedded systems

  --- smbnetfs ---
  SMBNetFS is a Linux/FreeBSD filesystem that allow you to use samba/microsoft
  network in the same manner as the network neighborhood in Microsoft Windows.

  --- fuse-exfat ---
  A read and write exFAT driver for FUSE

  --- exfat-utils ---
  Utilities to create, check, label and dump exFAT filesystem

  --- f2fs-tools ---
  Tools needed for creating and managing f2fs partitions

  --- xfsprogs ---
  It provides XFS filesystem utilities.
