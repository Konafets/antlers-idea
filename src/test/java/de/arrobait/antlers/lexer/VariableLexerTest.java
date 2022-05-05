package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class VariableLexerTest extends LexerTest {
    public VariableLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lex_identifier() {
        givenInput("{{ foo }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "foo",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lex_variable_assignments() {
        givenInput("{{ $foo = true }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_TRUE, "true",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo = 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo = 0.10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_FLOAT_NUMBER, "0.10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo = 'hello_world' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "hello_world",
                T_STRING_END, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo = (10) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_INTEGER_NUMBER, "10",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
