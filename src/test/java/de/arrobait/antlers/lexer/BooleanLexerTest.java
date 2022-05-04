package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class BooleanLexerTest extends LexerTest {
    public BooleanLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lex_true() {
        givenInput("{{ true }}");

        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TRUE, "true",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lex_false() {
        givenInput("{{ false }}");

        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_FALSE, "false",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
