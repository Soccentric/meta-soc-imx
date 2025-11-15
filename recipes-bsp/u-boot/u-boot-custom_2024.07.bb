SUMMARY = "Custom U-Boot for NXP i.MX"
DESCRIPTION = "Out-of-tree U-Boot hosted on GitHub"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=2ca5f2c35c8cc335f0a19756634782f1"

inherit uboot-config

DEPENDS += "bison-native flex-native"

# Placeholder GitHub repository - update with your actual repo
SRC_URI = "git://github.com/YOUR-ORG/u-boot-imx.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

# U-Boot configuration
UBOOT_CONFIG ?= "default"
UBOOT_CONFIG[default] = "imx_defconfig"

COMPATIBLE_MACHINE = "imx8mpevk"

do_compile:prepend() {
    export DEVICE_TREE="${UBOOT_DEVICETREE}"
}
