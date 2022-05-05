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
}
