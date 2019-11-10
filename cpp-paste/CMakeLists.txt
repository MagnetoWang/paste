cmake_minimum_required(VERSION 3.10)
project(cpp_paste)

set(CMAKE_CXX_STANDARD 11)

include_directories(${CMAKE_CURRENT_SOURCE_DIR}/third-party/include)

link_directories(${CMAKE_CURRENT_SOURCE_DIR}/third-party/lib)

add_executable(cpp_paste main.cpp example/inline.h run.cpp example/mutex.h example/assert.h)

add_executable(rand_test example/rand.cpp)

add_executable(format_test example/format2format.cpp)

add_executable(tensorflow_demo src/tensorflow/demo.cpp)

add_executable(label_image src/tensorflow/label_image.cpp)