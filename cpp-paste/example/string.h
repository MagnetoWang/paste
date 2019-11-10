//
// Created by magnetowang on 2019/11/06.
//

#ifndef CPP_PASTE_STRING_H
#define CPP_PASTE_STRING_H
#include <string.h>

// utf8 编解码
#include <locale>
#include <codecvt>
class StringUtil {
public:
    StringUtil(const std::string& data) 
        : string_data_(data) { data_ = string_data_.c_str(); }
    
    StringUtil() {}

    void PrintString() {
        std::cout << data_ << std::endl;
        std::cout << string_data_ << std::endl;
    }

    void PrintConfig() {
        std::cout << data_ << std::endl;
        std::cout << string_data_.size() << std::endl;
    }

    std::wstring string2ws(const std::string& str){
        using convert_typeX = std::codecvt_utf8<wchar_t>;
        std::wstring_convert<convert_typeX, wchar_t> converterX;
    
        return converterX.from_bytes(str);
    }
 
    std::string wstring2s(const std::wstring& wstr){
        using convert_typeX = std::codecvt_utf8<wchar_t>;
        std::wstring_convert<convert_typeX, wchar_t> converterX;
        return converterX.to_bytes(wstr);
    }

    void SplitString(const std::string& s, std::vector<std::string>& v, const std::string& c) {
        std::string::size_type pos1, pos2;
        pos2 = s.find(c);
        pos1 = 0;
        while(std::string::npos != pos2) {
            v.push_back(s.substr(pos1, pos2-pos1));
            pos1 = pos2 + c.size();
            pos2 = s.find(c, pos1);
        }
        if(pos1 != s.length()) {
            v.push_back(s.substr(pos1));
        }
    }

private:
    const char* data_;
    std::string string_data_;
};


#endif //CPP_PASTE_STRING_H