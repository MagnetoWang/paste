%option noyywrap nodefault yylineno
%{
enum yytokentype {
    NUMBER = 258,
    ADD = 259,
    SUB = 260,
    MUL = 261,
    DIV = 262,
    ABS = 263,
    EOL = 264
};

int yylval;
%}



/* 不需要加多余的空格，这不是c++和Java */
%%

"+" { return ADD; }
"-" { return SUB; }
"*" { return MUL; }
"/" { return DIV; }
"|" { return ABS; }
[0-9]+ { yylval = atoi(yytext); return NUMBER; }
\n { return EOL; }
[ \t] { /* ignore whitespace */ }
. { printf("Mystery character %c\n", *yytext); }

%%


main(int argc, char **argv) {
    int tok;

    while(tok = yylex()) {
        printf("%d", tok);
        if(tok == NUMBER)
        printf(" = %d\n", yylval);
        else
        printf("\n");
    }

}
