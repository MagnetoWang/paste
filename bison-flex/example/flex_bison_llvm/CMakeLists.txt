#mkdir -p build && cd build && cmake .. && make && cd ..
cmake_minimum_required (VERSION 2.8)

project(flex_bison_)

add_definitions('-g')
add_definitions('-Wall')
add_definitions('-std=c++14')

set(LLVM_LIB thirdparty/lib)
set(LLVM_INCLUDE thirdparty/include)
set(CMAKE_CURRENT_SOURCE_DIR /Users/magnetowang/Documents/GitHub/paste/bison-flex/example/flex_bison_llvm)

#link_directories(LLVM_LIB)
#include_directories(LLVM_INCLUDE)

include_directories(third-party/include)
#link_directories(third-party/lib)
#MESSAGE(CMAKE_CURRENT_SOURCE_DIR)

add_executable(main1 parser.cpp tokens.cpp main.cpp)
target_link_libraries(main1 llvm)


