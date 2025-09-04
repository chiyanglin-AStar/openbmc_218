# rust-example_0.1.0.bb

# 設定原始碼的位置。假設你的 rust-example 資料夾位於 Yocto build 目錄的平行路徑，
# 或你從遠端倉庫抓取。這裡我們假設它是本地路徑。
# 如果從遠端 Git 倉庫：
SRC_URI = "https://github.com/chiyanglin-AStar/rust-example.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
SRC_URI[sha256sum] = "9b3c4a5d4e69a61adbd1bd20a6e5d043ce7d9ac2238f5f97a95429683545694b"
# 為了這個範例的方便，假設原始碼在本地的 files/ 目錄下
# 你需要將上面的 rust-example 資料夾壓縮成一個 tarball，例如 rust-example-0.1.0.tar.gz
# 然後放在 Yocto 構築目錄的 `sources` 資料夾 (或者你的 BBFILES 搜尋路徑所及之處，通常是 recipe 旁邊的 `files` 子目錄)
# 或者直接將 `rust-example` 資料夾放在和 `.bb` 檔案同級的 `files` 資料夾中。
# 這裡我們用 `file://` 表示本地原始碼。

# 假設你將 rust-example 資料夾壓縮為 rust-example-0.1.0.tar.gz 並放在 files/ 目錄
# SRC_URI = "file://rust-example-0.1.0.tar.gz"

# 如果你直接將 rust-example 資料夾放在 recipe 的 files/ 子目錄中, 並希望 Yocto rsync 它：
#SRC_URI = "file://rust-example/"
#S = "${WORKDIR}/rust-example"

# 繼承 rust class
# 這會自動處理 Cargo 的構建過程
inherit rust

# 專案名稱 (crates.io 的 package name)。需與 Cargo.toml 中的 [package].name 相符
RUST_PN = "rust-example"

# Rust 專案的類型。對於可執行檔，使用 "bin"。
# 對於庫，使用 "lib"。
RUST_PN_TYPE = "bin"

# 描述和授權
DESCRIPTION = "A simple multi-file Rust example for Yocto"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${S}/Cargo.toml;endline=6;md5=81f19bd3e3c8872332562d0e485c232d"
# 上面的 LIC_FILES_CHKSUM 需要根據你的 Cargo.toml 實際內容和大小做調整。
# 通常，如果你的 Cargo.toml 中沒有 LICENSE 字段，而是放在根目錄的 LICENSE 檔案中，
# 你會這樣指定: LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=..."

# 設定安裝路徑。
# Rust 構建產生的二進位檔會放在 ${WORKDIR}/build/release/ 下。
# D 是安裝目的地目錄。
do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/release/${RUST_PN} ${D}${bindir}/
}

# 設定提供這個 recipe 的虛擬供應者。
# PROVIDES += "virtual/rust-example"