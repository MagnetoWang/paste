%option noyywrap nodefault yylineno
%{
#include <stdio.h>
#include "calc.tab.h"

%}


/* 不需要加多余的空格，这不是c++和Java */
%%

"+" { return ADD; }
"-" { return SUB; }
"*" { return MUL; }
"/" { return DIV; }
"|" { return ABS; }
[0-9]+ { yylval = atoi(yytext); return NUMBER;
         printf("%d", yylval); }
\n { return EOL; }
[ \t] { /* ignore whitespace */ }
. { printf("Mystery character %c\n", *yytext); }

%%

