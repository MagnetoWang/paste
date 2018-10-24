//
// Created by magnetowang on 2018/10/22.
//

#ifndef CPP_PASTE_MUTEX_H
#define CPP_PASTE_MUTEX_H
#include <iostream>       // std::cout
#include <thread>         // std::thread
#include <mutex>          // std::mutex

volatile  int counter(0);
std::mutex mtx;

void attempt_10k_increase(){
    for(int i=0;i<1000;++i){
        if(mtx.try_lock()){
            ++counter;
            mtx.unlock();
        }else{
            i--;
        }
    }
}
namespace mutex_wang{
    int show(){
        std::thread threads[10];
        for(int i=0;i<10;++i){
            threads[i] = std::thread(attempt_10k_increase);


        }
        for(auto& th:threads){
            th.join();
        }
        std::cout<<counter<<" successful increases of the counter.\n";
        return 0;
    }
}




#endif //CPP_PASTE_MUTEX_H
