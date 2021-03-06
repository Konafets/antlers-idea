package de.arrobait.antlers.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;

public class AntlersTokenSets {
    public static final TokenSet ADVANCED_OPERATORS;
    public static final TokenSet BOOLEANS;
    public static final TokenSet BRACES;
    public static final TokenSet BRACKETS;
    public static final TokenSet COMMA;
    public static final TokenSet COMMENTS;
    public static final TokenSet IDENTIFIER;
    public static final TokenSet KEYWORDS;
    public static final TokenSet MODIFIERS;
    public static final TokenSet NUMBERS;
    public static final TokenSet OPERATORS;
    public static final TokenSet PARENTHESES;
    public static final TokenSet SEMICOLON;
    public static final TokenSet STRINGS;
    public static final TokenSet TAGS;
    public static final TokenSet TAG_CONDITIONS;
    public static final TokenSet TAG_METHOD_NAMES;
    public static final TokenSet TAG_DISAMBIGUATION;
    public static final TokenSet TAG_SHORTHAND_SEPARATOR;
    public static final TokenSet WHITE_SPACE;

    private AntlersTokenSets() {}

    static {
        ADVANCED_OPERATORS = TokenSet.create(
                AntlersTypes.T_GROUP_BY,
                AntlersTypes.T_MERGE,
                AntlersTypes.T_ORDER_BY,
                AntlersTypes.T_PLUCK,
                AntlersTypes.T_SKIP,
                AntlersTypes.T_TAKE,
                AntlersTypes.T_WHERE
        );
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
        MODIFIERS = TokenSet.create(
                AntlersTypes.T_MODIFIER
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
        SEMICOLON = TokenSet.create(
                AntlersTypes.T_SEMICOLON
        );
        STRINGS = TokenSet.create(
                AntlersTypes.T_STRING_CONTENT,
                AntlersTypes.T_STRING_START,
                AntlersTypes.T_STRING_END
        );
        TAGS = TokenSet.create(
                AntlersTypes.T_NOPARSE,
                AntlersTypes.T_TAG
        );
        TAG_CONDITIONS = TokenSet.create(
                AntlersTypes.T_TAG_CONDITION
        );
        TAG_METHOD_NAMES = TokenSet.create(
                AntlersTypes.T_TAG_METHOD_NAME
        );
        TAG_DISAMBIGUATION = TokenSet.create(
                AntlersTypes.T_DISAMBIGUATION
        );
        TAG_SHORTHAND_SEPARATOR = TokenSet.create(
                AntlersTypes.T_SHORTHAND_SEPARATOR
        );
        WHITE_SPACE = TokenSet.create(
                TokenType.WHITE_SPACE
        );
    }
}
