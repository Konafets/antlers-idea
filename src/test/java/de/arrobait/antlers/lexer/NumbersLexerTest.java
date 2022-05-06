package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class NumbersLexerTest extends LexerTest {
    public NumbersLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lex_integers() {
        givenInput("{{ 42 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "42",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 420 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "420",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 420000 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "420000",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
    @Test
    public void it_lex_floats() {
        givenInput("{{ .42 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_FLOAT_NUMBER, ".42",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 0.42 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_FLOAT_NUMBER, "0.42",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lex_negative_numbers() {
        givenInput("{{ -42 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "42",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ -420 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "420",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ -420000 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "420000",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ -.42 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_FLOAT_NUMBER, ".42",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ -0.42 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_FLOAT_NUMBER, "0.42",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
