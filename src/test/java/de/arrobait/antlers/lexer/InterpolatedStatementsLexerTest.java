package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class InterpolatedStatementsLexerTest extends LexerTest {
    public InterpolatedStatementsLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_interpolated_statements() {
        givenInput("{{ foo = {10} }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LEFT_BRACE, "{",
                T_INTEGER_NUMBER, "10",
                T_RIGHT_BRACE, "}",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
