cmake_minimum_required(VERSION 3.10)
project(cpp_paste)

set(CMAKE_CXX_STANDARD 11)

add_executable(cpp_paste main.cpp example/inline.h run.cpp example/mutex.h example/assert.h)

add_executable(rand_test example/rand.cpp)