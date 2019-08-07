/* build symbol table */
%{

enum yytokentype {
    CREATE = 300,
    EOL = 264
};

%}

%%


discrete { printf("DISCRETE"); }
create { return CREATE; }

%%

int main(int argc, char **argv) {
    int token;
    while (token = yylex()) {
        printf("%d", token);
    }
    return 0;
}