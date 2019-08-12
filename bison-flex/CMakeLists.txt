cmake_minimum_required (VERSION 3.0)
project(bison-flex)

add_definitions('-g')
add_definitions('-Wall')
add_definitions('-std=c++14')
include_directories(src)

add_subdirectory(src)


