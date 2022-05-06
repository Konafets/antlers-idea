package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class MathLexerTest extends LexerTest {
    public MathLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_add_expression() {
        givenInput("{{ $a + $b }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$b",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $a += 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                WHITE_SPACE, " ",
                T_OP_SELF_ASSIGN_ADD, "+=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 3 + 4 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "3",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "4",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 'Foo' + 4 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "Foo",
                T_STRING_END, "'",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "4",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 'Foo' + bar }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "Foo",
                T_STRING_END, "'",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "bar",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 'Foo' + $bar }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "Foo",
                T_STRING_END, "'",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$bar",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 'Foo' + 'Bar' }}");
        thenTokensAre(
    T_LD, "{{",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "Foo",
                T_STRING_END, "'",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "Bar",
                T_STRING_END, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_substraction_expression() {
        givenInput("{{ $a - $b }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$b",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $a -= $b }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                WHITE_SPACE, " ",
                T_OP_SELF_ASSIGN_SUB, "-=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$b",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 1 - -1 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ -1 - -1 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ -1--1 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "1",
                T_OP_MINUS, "-",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ -1-1 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "1",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ (-1)-1 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "1",
                T_RP, ")",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ {-1}-1 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LEFT_BRACE, "{",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "1",
                T_RIGHT_BRACE, "}",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_multiply_expression() {
        givenInput("{{ $a * $b }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                WHITE_SPACE, " ",
                T_OP_MUL, "*",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$b",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $a *= $b }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                WHITE_SPACE, " ",
                T_OP_SELF_ASSIGN_MUL, "*=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$b",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_divide_expression() {
        givenInput("{{ $a / $b }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$b",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $a /= $b }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                WHITE_SPACE, " ",
                T_OP_SELF_ASSIGN_DIV, "/=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$b",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_pow_expression() {
        givenInput("{{ $a ** $b }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                WHITE_SPACE, " ",
                T_OP_POW, "**",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$b",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_modulo_expression() {
        givenInput("{{ $a % $b }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                WHITE_SPACE, " ",
                T_OP_MOD, "%",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$b",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $a %= $b }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                WHITE_SPACE, " ",
                T_OP_SELF_ASSIGN_MOD, "%=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$b",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_factorial_expression() {
        givenInput("{{ $a! }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ (5)! }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_INTEGER_NUMBER, "5",
                T_RP, ")",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ (2 + 3)! }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_INTEGER_NUMBER, "2",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "3",
                T_RP, ")",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ (2 + 3)! + 2 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_INTEGER_NUMBER, "2",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "3",
                T_RP, ")",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "2",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ (2 + 3)! + 5! }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_INTEGER_NUMBER, "2",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "3",
                T_RP, ")",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "5",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_factorial_expressions() {
        givenInput("{{ $a! }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 5! }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "5",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ (5)! }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_INTEGER_NUMBER, "5",
                T_RP, ")",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
