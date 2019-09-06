#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define random(x) (rand()%x)

int main() {
    
    for(int x=0;x<10;x++) {
        printf("%d\n",random(2));
    }
    return 0;
}
