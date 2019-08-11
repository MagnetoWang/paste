/* build symbol table */

/* 注意这里的是百分号和大括号，结尾是大括号和百分号，容易出错
    这里是c++语言定义的地方
 */
%{

enum yytokentype {
    CREATE = 300,
    EOL = 264
};

%}


/* 这里是正则表达式定义模块 */
%%


discrete { printf("DISCRETE"); }
create { return CREATE; }

%%


/*  */
int main(int argc, char **argv) {
    int token;
    while (token = yylex()) {
        printf("%d", token);
    }
    return 0;
}