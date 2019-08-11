set(LEXER_GEN
        ${CMAKE_CURRENT_BINARY_DIR}/token.gen.cc)

add_custom_command(OUTPUT ${LEXER_GEN}
        COMMAND flex ${PROJECT_SOURCE_DIR}/src/flex/token.l
        )