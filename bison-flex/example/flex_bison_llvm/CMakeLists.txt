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

#只包含node头文件
#add_library(base src/parser.cpp src/tokens.cpp src/node.h)
#add_executable(main_test src/main.cpp)
#target_link_libraries(main_test base)

#加入codegen头文件
add_library(base src/parser.cpp src/tokens.cpp src/node.h src/codegen.cpp)
add_executable(main_test src/main.cpp)
target_link_libraries(main_test base)


set(LLVM_LINK_COMPONENTS
        Core
        ExecutionEngine
        Interpreter
        Support
        nativecodegen
        )

add_executable(jitExample src/JITExample.cpp)
target_link_libraries(jitExample llvm)


add_executable(toy toy/toy.cpp)
target_link_libraries(toy llvm)

add_executable(toy2 toy/toy2.cpp)
target_link_libraries(toy2 llvm)

add_executable(toy3 toy/toy3.cpp)
target_link_libraries(toy3 llvm)

add_executable(toy4 toy/toy4.cpp)
target_link_libraries(toy4 llvm)

add_executable(discrete discrete/grammer.cpp discrete/lexer.cpp)
target_link_libraries(discrete llvm)

