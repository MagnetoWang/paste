//
// Created by magnetowang on 2018/10/22.
//

#ifndef CPP_PASTE_INLINE_H
#define CPP_PASTE_INLINE_H
#include <iostream>

using namespace std;

inline int InlineMax(int x, int y)
{
    return (x > y)? x : y;
}

// 程序的主函数
namespace inline_wang{
    int show(){
        cout << "Max (20,10): " << InlineMax(20,10) << endl;
        cout << "Max (0,200): " << InlineMax(0,200) << endl;
        cout << "Max (100,1010): " << InlineMax(100,1010) << endl;
        return 0;
    }

}


#endif //CPP_PASTE_INLINE_H
