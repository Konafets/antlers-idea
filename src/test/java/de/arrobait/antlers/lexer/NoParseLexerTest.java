package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class NoParseLexerTest extends LexerTest {
    public NoParseLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void lex_noparse_at() {
        givenInput("@{{ hello_world }}");
        thenTokensAre(
                T_AT, "@",
                OUTER_CONTENT, "{{ hello_world }}"
        );
    }

    @Test
    public void lex_noparse_region_open() {
        givenInput("{{ noparse }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_NOPARSE, "noparse",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_noparse_region_close() {
        givenInput("{{ /noparse }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_NOPARSE, "noparse",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_noparse_region() {
        givenInput("{{ noparse }} Foo Bar {{ hello_world }} {{ /noparse }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_NOPARSE, "noparse",
                WHITE_SPACE, " ",
                T_RD, "}}",
                OUTER_CONTENT, " Foo Bar ",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "hello_world",
                WHITE_SPACE, " ",
                T_RD, "}}",
                WHITE_SPACE, " ",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_NOPARSE, "noparse",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
