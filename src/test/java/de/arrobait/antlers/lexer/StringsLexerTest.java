package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class StringsLexerTest extends LexerTest {
    public StringsLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void lex_empty_file() {
        givenInput("");
        thenTokensAre();
    }

    @Test
    public void lex_single_and_double_quoted_string() {
        givenInput("{{ \"I will eat you, donut\" }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_STRING_START, "\"",
                T_STRING_CONTENT, "I will eat you, donut",
                T_STRING_END, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 'I will eat you, donut' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "I will eat you, donut",
                T_STRING_END, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
