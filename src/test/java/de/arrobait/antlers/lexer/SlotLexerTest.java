package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class SlotLexerTest extends LexerTest {
    public SlotLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void lex_simple_slot() {
        givenInput("{{ slot }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLOT, "slot",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_named_slot() {
        givenInput("{{ slot:foo }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLOT, "slot",
                T_COLON, ":",
                T_IDENTIFIER, "foo",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
