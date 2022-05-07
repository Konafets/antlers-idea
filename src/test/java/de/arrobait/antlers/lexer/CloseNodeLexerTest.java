package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class CloseNodeLexerTest extends LexerTest {
    public CloseNodeLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_close_nodes() {
        givenInput("{{ /foo }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_IDENTIFIER, "foo",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
