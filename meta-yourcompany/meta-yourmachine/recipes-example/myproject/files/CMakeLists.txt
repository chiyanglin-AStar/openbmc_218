cmake_minimum_required(VERSION 3.10)
project(MyProject)

# 設定 C++ 標準
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED True)

# 包含子目錄
include_directories(utils)
include_directories(math)

# 收集所有原始碼檔案
set(SOURCES
    main.cpp
    utils/helper.cpp
    math/calculator.cpp
)

# 建立可執行檔案
add_executable(MyProject ${SOURCES})
