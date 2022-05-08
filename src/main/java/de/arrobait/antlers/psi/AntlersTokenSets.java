package de.arrobait.antlers.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;

public class AntlersTokenSets {
    public static final TokenSet BOOLEANS;
    public static final TokenSet BRACES;
    public static final TokenSet BRACKETS;
    public static final TokenSet COMMA;
    public static final TokenSet COMMENTS;
    public static final TokenSet IDENTIFIER;
    public static final TokenSet KEYWORDS;
    public static final TokenSet NUMBERS;
    public static final TokenSet OPERATORS;
    public static final TokenSet PARENTHESES;
    public static final TokenSet STRINGS;
    public static final TokenSet WHITE_SPACE;

    private AntlersTokenSets() {}

    static {
        BOOLEANS = TokenSet.create(
                AntlersTypes.T_TRUE,
                AntlersTypes.T_FALSE
        );
        BRACES = TokenSet.create(
                AntlersTypes.T_LD,
                AntlersTypes.T_RD,
                AntlersTypes.T_LEFT_BRACE,
                AntlersTypes.T_RIGHT_BRACE
        );
        BRACKETS = TokenSet.create(
                AntlersTypes.T_LEFT_BRACKET,
                AntlersTypes.T_RIGHT_BRACKET
        );
        COMMA = TokenSet.create(
                AntlersTypes.T_COMMA
        );
        COMMENTS = TokenSet.create(
                AntlersTypes.T_COMMENT_OPEN,
                AntlersTypes.T_COMMENT_CLOSE,
                AntlersTypes.T_COMMENT_TEXT
        );
        IDENTIFIER = TokenSet.create(
                AntlersTypes.T_IDENTIFIER
        );
        KEYWORDS = TokenSet.create(
                AntlersTypes.T_IF,
                AntlersTypes.T_END_IF,
                AntlersTypes.T_ELSE_IF,
                AntlersTypes.T_ELSE,
                AntlersTypes.T_UNLESS,
                AntlersTypes.T_END_UNLESS,
                AntlersTypes.T_SWITCH
        );
        NUMBERS = TokenSet.create(
                AntlersTypes.T_INTEGER_NUMBER,
                AntlersTypes.T_FLOAT_NUMBER
        );
        OPERATORS = TokenSet.create(
                AntlersTypes.T_COLON,
                AntlersTypes.T_DOT,
                AntlersTypes.T_OP_ASSIGN,
                AntlersTypes.T_OP_EXCLAMATION_MARK,
                AntlersTypes.T_OP_QUESTIONMARK,
                AntlersTypes.T_OP_PLUS,
                AntlersTypes.T_OP_MINUS,
                AntlersTypes.T_OP_MUL,
                AntlersTypes.T_SLASH,
                AntlersTypes.T_OP_MOD,
                AntlersTypes.T_OP_POW,
                AntlersTypes.T_OP_SELF_ASSIGN_ADD,
                AntlersTypes.T_OP_SELF_ASSIGN_SUB,
                AntlersTypes.T_OP_SELF_ASSIGN_MUL,
                AntlersTypes.T_OP_SELF_ASSIGN_DIV,
                AntlersTypes.T_OP_SELF_ASSIGN_MOD,
                AntlersTypes.T_OP_EQ,
                AntlersTypes.T_OP_NEQ,
                AntlersTypes.T_OP_IDENT,
                AntlersTypes.T_OP_NOT_IDENT,
                AntlersTypes.T_OP_LT,
                AntlersTypes.T_OP_LTE,
                AntlersTypes.T_OP_GT,
                AntlersTypes.T_OP_GTE,
                AntlersTypes.T_OP_SPACESHIP,
                AntlersTypes.T_OP_NULL_COALESCENCE,
                AntlersTypes.T_OP_GATEKEEPER,
                AntlersTypes.T_OP_AND,
                AntlersTypes.T_OP_OR,
                AntlersTypes.T_OP_XOR,
                AntlersTypes.T_OP_ARROW
                );
        PARENTHESES = TokenSet.create(
                AntlersTypes.T_LP,
                AntlersTypes.T_RP
        );
        STRINGS = TokenSet.create(
                AntlersTypes.T_STRING_CONTENT,
                AntlersTypes.T_STRING_START,
                AntlersTypes.T_STRING_END
        );
        WHITE_SPACE = TokenSet.create(
                TokenType.WHITE_SPACE
        );
    }
}
