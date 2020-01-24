cmake_minimum_required(VERSION 3.5)

project(hello-catch2-cmake LANGUAGES CXX VERSION 0.0.1)
set(CMAKE_CXX_FLAGS "-std=c++17 -Wall -Wextra")
include_directories("${PROJECT_SOURCE_DIR}/source")
file(GLOB_RECURSE lib_SOURCES "source/*.cpp" "source/*/*.cpp")
file(GLOB_RECURSE test_SOURCES "Test/*.cpp")

find_package(Catch2 REQUIRED)

add_executable(kredki-test ${test_SOURCES})
target_link_libraries(kredki-test bazaKredek Catch2::Catch2)

include(CTest)
include(Catch)
catch_discover_tests(kredki-test)
