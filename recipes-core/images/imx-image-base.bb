SUMMARY = "Base image for NXP i.MX"
DESCRIPTION = "Custom image based on core-image-full-cmdline with platform-specific additions"

LICENSE = "MIT"

inherit core-image

# Start with full command-line base
IMAGE_FEATURES += "ssh-server-openssh"
IMAGE_FEATURES += "package-management"
IMAGE_FEATURES += "debug-tweaks"

# Core packages
IMAGE_INSTALL:append = " \
    kernel-modules \
    u-boot-fw-utils \
    dtc \
    i2c-tools \
    spitools \
    mtd-utils \
    can-utils \
    ethtool \
    iperf3 \
    tcpdump \
    strace \
    gdbserver \
    python3 \
    python3-pip \
    git \
    vim \
    htop \
"

# Platform-specific kernel and bootloader
IMAGE_INSTALL:append = " \
    linux-custom \
    u-boot-custom \
    device-tree-imx \
"

# RPU firmware support
IMAGE_INSTALL:append = " \
    rpu-firmware-imx \
"

# Additional development tools
IMAGE_INSTALL:append = " \
    cmake \
    make \
    gcc \
    g++ \
"

# Set root password for debugging (remove for production)
# Password: root
EXTRA_USERS_PARAMS = "usermod -P root root;"

COMPATIBLE_MACHINE = "(imx23evk|imx28evk|imx51evk|imx53qsb|imx6qdlsabreauto|imx6qdlsabresd|imx6slevk|imx6sllevk|imx6sxsabreauto|imx6sxsabresd|imx6ulevk|imx6ullevk|imx6ulz-14x14-evk|imx7dsabresd|imx7ulpevk|imx8dx-mek|imx8dxl-ddr3l-evk|imx8dxl-lpddr4-evk|imx8mm-ddr4-evk|imx8mm-lpddr4-evk|imx8mn-ddr4-evk|imx8mn-lpddr4-evk|imx8mnul-ddr3l-evk|imx8mp-ddr4-evk|imx8mp-lpddr4-evk|imx8mq-evk|imx8qm-mek|imx8qxp-mek|imx8ulp-lpddr4-evk|imx93-11x11-lpddr4x-evk|imx93-9x9-lpddr4-qsb|ls1012afrwy|ls1012ardb|ls1021atwr|ls1028ardb|ls1043ardb|ls1046afrwy|ls1046ardb|ls1088ardb|ls1088ardb-pb|ls2080ardb|ls2088ardb|lx2160ardb|lx2162aqds)"
