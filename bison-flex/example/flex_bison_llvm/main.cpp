//
// Created by magnetowang on 2019/8/7.
//

#include <iostream>
#include "node.h"
extern NBlock* programBlock;
extern int yyparse();

int main(int argc, char **argv)
{
    yyparse();
    std::cout << programBlock << std::endl;
    return 0;
}


//#include < iostream>
//#include "codegen.h"
//#include "node.h"
//
//using namespace std;
//
//extern int yyparse();
//extern NBlock* programBlock;
//
//int main(int argc, char **argv)
//{
//    yyparse();
//    std::cout << programBlock << std::endl;
//
//    CodeGenContext context;
//    context.generateCode(*programBlock);
//    context.runCode();
//
//    return 0;
//}