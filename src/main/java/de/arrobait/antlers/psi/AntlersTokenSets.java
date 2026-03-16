package de.arrobait.antlers.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

import static de.arrobait.antlers.psi.AntlersTypes.*;

public class AntlersTokenSets {
    public static final TokenSet ADVANCED_OPERATORS = TokenSet.create(
            T_GROUP_BY,
            T_MERGE,
            T_ORDER_BY,
            T_PLUCK,
            T_SKIP,
            T_TAKE,
            T_WHERE
    );

    public static final TokenSet BOOLEANS = TokenSet.create(
            T_TRUE,
            T_FALSE
    );

    public static final TokenSet BRACES = TokenSet.create(
            T_LD,
            T_RD,
            T_LEFT_BRACE,
            T_RIGHT_BRACE
    );

    public static final TokenSet BRACKETS = TokenSet.create(
            T_LEFT_BRACKET,
            T_RIGHT_BRACKET
    );

    public static final TokenSet COMMA = TokenSet.create(
            T_COMMA
    );

    public static final TokenSet COMMENTS = TokenSet.create(
            T_COMMENT_OPEN,
            T_COMMENT_CLOSE,
            T_COMMENT_TEXT
    );

    public static final TokenSet NODES = TokenSet.create(
            AntlersTypes.TINE,
            TAG_SINGLE
    );

    public static final TokenSet CONDITIONAL_BLOCKS = TokenSet.create(
            IF_OPEN_NODE,
            UNLESS_OPEN_NODE
    );

    public static final TokenSet IDENTIFIER = TokenSet.create(T_IDENTIFIER);

    public static final TokenSet KEYWORDS = TokenSet.create(
            T_IF,
            T_END_IF,
            T_ELSE_IF,
            T_ELSE,
            T_UNLESS,
            T_END_UNLESS,
            T_SWITCH
    );

    public static final TokenSet MODIFIERS = TokenSet.create(T_MODIFIER);

    public static final TokenSet NUMBERS = TokenSet.create(
            T_INTEGER,
            T_FLOAT
    );

    public static final TokenSet OPERATORS = TokenSet.create(
            TENARY_BRANCH_OP,
            T_DOT,
            T_OP_ASSIGN,
            T_OP_EXCLAMATION_MARK,
            T_OP_QUESTIONMARK,
            T_OP_PLUS,
            T_OP_MINUS,
            T_OP_MUL,
            DIV_OP,
            T_PERCENT,
            T_OP_POW,
            T_OP_SELF_ASSIGN_ADD,
            T_OP_SELF_ASSIGN_SUB,
            T_OP_SELF_ASSIGN_MUL,
            T_OP_SELF_ASSIGN_DIV,
            T_OP_SELF_ASSIGN_MOD,
            T_OP_EQ,
            T_OP_NEQ,
            T_OP_IDENT,
            T_OP_NOT_IDENT,
            T_OP_LT,
            T_OP_LTE,
            T_OP_GT,
            T_OP_GTE,
            T_OP_SPACESHIP,
            T_OP_NULL_COALESCENCE,
            T_OP_GATEKEEPER,
            T_OP_AND,
            T_OP_OR,
            T_OP_XOR,
            T_OP_ARROW
    );

    public static final TokenSet PARENTHESES = TokenSet.create(
            T_LP,
            T_RP
    );

    public static final TokenSet SEMICOLON = TokenSet.create(T_SEMICOLON);

    public static final TokenSet STRINGS = TokenSet.create(
            T_STRING_CONTENT,
            T_SINGLE_QUOTE,
            T_DOUBLE_QUOTE
    );

    public static final TokenSet TAGS = TokenSet.create(
            T_NOPARSE,
            T_TAG
    );

    public static final TokenSet TAG_CONDITIONS = TokenSet.create(T_TAG_CONDITION);

    public static final TokenSet TAG_METHOD_NAMES = TokenSet.create(T_TAG_METHOD_NAME);

    public static final TokenSet TAG_DISAMBIGUATION = TokenSet.create(T_PERCENT);

    public static final TokenSet WHITESPACES = TokenSet.create(TokenType.WHITE_SPACE);

    @NotNull
    public static final TokenSet OPENING_DELIMITERS = TokenSet.create(AntlersTypes.NODE_OPENER, AntlersTypes.T_COMMENT_OPEN, AntlersTypes.T_PHP_RAW_OPEN, AntlersTypes.T_PHP_ECHO_OPEN);

    public static final TokenSet CLOSING_DELIMITERS = TokenSet.create(AntlersTypes.NODE_CLOSER, AntlersTypes.T_COMMENT_CLOSE, AntlersTypes.T_PHP_RAW_CLOSE, AntlersTypes.T_PHP_ECHO_CLOSE);

    private AntlersTokenSets() {
    }
}
