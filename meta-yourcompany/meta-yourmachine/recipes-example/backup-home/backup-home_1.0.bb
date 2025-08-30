LICENSE = "MIT"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
# No source directory needed as we're using local files
#S = "${WORKDIR}"
S = "${UNPACKDIR}"


# Inherit systemd if systemd is in DISTRO_FEATURES
inherit ${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)}

# SystemD service files
SYSTEMD_SERVICE_${PN} = "backup-home.service backup-home.timer"
SYSTEMD_AUTO_ENABLE_${PN} = "disable"

# Installation directories
SCRIPT_DIR = "${bindir}"
CONFIG_DIR = "${sysconfdir}/backup-home"
DOC_DIR = "${docdir}/${PN}"
SYSTEMD_DIR = "${systemd_unitdir}/system"

SRC_URI = "file://backup-home.sh"

do_install() {
    bbdebug 2 "****------  begin message from do_install"
    # Create installation directories
    install -d ${D}${SCRIPT_DIR}
    install -d ${D}${CONFIG_DIR}
    install -d ${D}${DOC_DIR}
    
    # Install the main backup script
    install -m 0755 ${UNPACKDIR}/backup-home.sh ${D}${SCRIPT_DIR}/backup-home
    
    # Install configuration file
    #install -m 0644 ${WORKDIR}/backup-home.conf ${D}${CONFIG_DIR}/backup-home.conf
    
    # Create default backup directory
    install -d ${D}/backup
    
    # Create log directory
    install -d ${D}${localstatedir}/log
    
    # Install systemd service files if systemd is enabled
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${SYSTEMD_DIR}
        #install -m 0644 ${WORKDIR}/backup-home.service ${D}${SYSTEMD_DIR}/
        #install -m 0644 ${WORKDIR}/backup-home.timer ${D}${SYSTEMD_DIR}/
    fi
    bbdebug 2 "****------  before cat -- message from do_install"
    # Create documentation
    cat > ${D}${DOC_DIR}/README << 'EOF'
Home Directory Backup Tool
==========================

This tool provides automated backup functionality for user home directories.

Usage:
------
backup-home [OPTIONS] [USERNAME]

Options:
  -d, --destination DIR    Backup destination directory (default: /backup)
  -c, --compression LEVEL  Compression level 1-9 (default: 6)
  -k, --keep DAYS         Keep backups for N days (default: 30)
  -e, --exclude FILE      Exclude patterns file
  -l, --log FILE          Log file location (default: /var/log/home_backup.log)
  -q, --quiet             Quiet mode (minimal output)
  -h, --help              Show help message

Examples:
---------
# Backup current user's home directory
backup-home --current

# Backup specific user (requires root)
sudo backup-home john

# Backup to custom location
backup-home -d /external/backup jane

# Backup with custom settings
backup-home -c 9 -k 60 -d /nas/backup john

Configuration:
--------------
Default settings can be modified in:
/etc/backup-home/backup-home.conf

SystemD Integration:
-------------------
If systemd is available, you can enable automatic backups:

# Enable daily backup timer
sudo systemctl enable backup-home.timer
sudo systemctl start backup-home.timer

# Run backup manually via systemd
sudo systemctl start backup-home.service

Logs:
-----
Backup logs are written to /var/log/home_backup.log

Files and Directories:
---------------------
- Script: /usr/bin/backup-home
- Config: /etc/backup-home/backup-home.conf  
- Default backup location: /backup/
- Log file: /var/log/home_backup.log
EOF

    # Create example configuration file content
    cat > ${D}${CONFIG_DIR}/backup-home.conf << 'EOF'
# Home Directory Backup Tool Configuration
# This file contains default settings for the backup tool

# Default backup destination directory
BACKUP_DIR="/backup"

# Default compression level (1-9, where 9 is highest compression)
COMPRESSION_LEVEL=6

# Number of days to keep old backups
KEEP_DAYS=30

# Default log file location
LOG_FILE="/var/log/home_backup.log"

# Default exclude patterns file (created automatically if not exists)
EXCLUDE_FILE="/tmp/backup_exclude.txt"
EOF
}

# File packaging
FILES_${PN} = "${SCRIPT_DIR}/backup-home \
               ${CONFIG_DIR}/backup-home.conf \
               ${DOC_DIR}/README \
               /backup \
               ${localstatedir}/log \
              "

# SystemD files
FILES_${PN} += "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', '${SYSTEMD_DIR}/backup-home.service ${SYSTEMD_DIR}/backup-home.timer', '', d)}"

# Post-install script to set up directories and permissions
pkg_postinst_${PN}() {
    #!/bin/sh
    
    # Create backup directory if it doesn't exist
    if [ ! -d $D/backup ]; then
        mkdir -p $D/backup
        chmod 755 $D/backup
    fi
    
    # Ensure log directory exists
    if [ ! -d $D${localstatedir}/log ]; then
        mkdir -p $D${localstatedir}/log
    fi
    
    # Set proper permissions
    chmod 755 $D${SCRIPT_DIR}/backup-home
    chmod 644 $D${CONFIG_DIR}/backup-home.conf
    
    echo "Home Directory Backup Tool installed successfully!"
    echo "Run 'backup-home --help' for usage information."
}

# Pre-removal script
pkg_prerm_${PN}() {
    #!/bin/sh
    
    # Stop and disable systemd services if they exist
    if command -v systemctl >/dev/null 2>&1; then
        systemctl stop backup-home.timer 2>/dev/null || true
        systemctl disable backup-home.timer 2>/dev/null || true
        systemctl stop backup-home.service 2>/dev/null || true
        systemctl disable backup-home.service 2>/dev/null || true
    fi   
}

COMPATIBLE_MACHINE = "(.*)"