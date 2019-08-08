#mkdir -p build && cd build && cmake .. && make && cd ..
#rm -rf parser.cpp parser.hpp tokens.cpp
cmake_minimum_required (VERSION 2.8)

project(flex_bison_)

add_definitions('-g')
add_definitions('-Wall')
add_definitions('-std=c++11')

#set(LLVM_LIB ${CMAKE_CURRENT_SOURCE_DIR}/thirdparty/lib)
#set(LLVM_INCLUDE ${CMAKE_CURRENT_SOURCE_DIR}/thirdparty/include)

#link_directories(LLVM_LIB)
#include_directories(LLVM_INCLUDE)

include_directories(${CMAKE_CURRENT_SOURCE_DIR}/thirdparty/include)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/src)
link_directories(${CMAKE_CURRENT_SOURCE_DIR}/thirdparty/lib)

add_library(base src/parser.cpp src/tokens.cpp src/node.h)
add_executable(main_test src/main.cpp)
target_link_libraries(main_test base)


