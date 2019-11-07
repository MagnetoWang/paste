//
// Created by magnetowang on 2019/11/04.
//

#ifndef CPP_PASTE_FILE_H
#define CPP_PASTE_FILE_H
// 文件流方式读写文件
#include <fstream>
#include <iostream>
// 关闭文件夹
#include <unistd.h>

class FileUtil {
public:
    FileUtil(std::string& path, int fd)
        : path_(path), fd_(fd) {}

    FileUtil(std::string& path)
        : path_(path), fd_(-1) {}
        
    ~FileUtil() { 
        if (fd_ != -1) {
             close(fd_);
        }
    }

    void ReadyRead() {
        infile_.open(path_);
    }

    // 无法保证行的长度！！！
    // bool IsLastLine() {
    //     std::cout << getline << std::endl;
    //     return true;
    // }

    std::string ReadString() {
        infile_ >> buffer_;
        return buffer_;
    }

    float ReadFloat() {
        float f;
        infile_ >> f;
        return f;
    }

    double ReadDouble() {
        double d;
        infile_ >> d;
        return d;
    }

    std::string ReadLine() {
        if (getline(infile_, buffer_)) {
            return buffer_;
        }
        return nullptr;
    }

private:
    std::string path_;
    int fd_;
    int postion_;
    std::ifstream infile_;
    std::string buffer_;
};


#endif //CPP_PASTE_FILE_H