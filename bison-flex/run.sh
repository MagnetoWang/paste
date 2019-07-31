#!/usr/bin/env bash
# mac和linux下命令有所不同，本脚本支持mac系统下

ROOT_DIR=`pwd`

FILE=$1
PARAMETER=$2

flex $1
cc lex.yy.c -ll
./a.out PARAMETER

