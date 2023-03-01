package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class FrontmatterLexerTest extends LexerTest {
    public FrontmatterLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_open_frontmatter_delimiter() {
        givenInput(
                "---"
        );
        thenTokensAre(
                FRONT_MATTER_HEADER_DELIMITER, "---"
        );
    }

    @Test
    public void it_lexes_unclosed_frontmatter() {
        givenInput(
                "---" +
                "foo:bar"
        );
        thenTokensAre(
                FRONT_MATTER_HEADER_DELIMITER, "---",
                UNCLOSED_FRONT_MATTER, "foo:bar"
        );
    }

    @Test
    public void it_lexes_empty_frontmatter() {
        givenInput(
                "---" +
                "---"
        );
        thenTokensAre(
                FRONT_MATTER_HEADER_DELIMITER, "---",
                FRONT_MATTER_HEADER_DELIMITER, "---"
        );
    }

    @Test
    public void it_lexes_simple_frontmatter() {
        givenInput(
                "---" +
                "sports:" +
                "---"
        );
        thenTokensAre(
                FRONT_MATTER_HEADER_DELIMITER, "---",
                FRONT_MATTER_HEADER_CONTENT, "sports:",
                FRONT_MATTER_HEADER_DELIMITER, "---"
        );
    }

    @Test
    public void it_lexes_frontmatter_with_antlers() {
        givenInput("---" +
                "sports:" +
                "  - BMXing" +
                "  - rollerblading" +
                "  - skateboarding" +
                "  - scootering" +
                "---" +
                "<p>Let's go {{ sports:0 }}, {{ sports.1 }} or {{ sports[2] }}.</p>");

        thenTokensAre(
                FRONT_MATTER_HEADER_DELIMITER, "---",
                FRONT_MATTER_HEADER_CONTENT, "sports:  - BMXing  - rollerblading  - skateboarding  - scootering",
                FRONT_MATTER_HEADER_DELIMITER, "---",
                OUTER_CONTENT, "<p>Let's go ",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "sports",
                T_COLON, ":",
                T_INTEGER_NUMBER, "0",
                WHITE_SPACE, " ",
                T_RD, "}}",
                OUTER_CONTENT, ", ",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "sports",
                T_DOT, ".",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}",
                OUTER_CONTENT, " or ",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "sports",
                T_LEFT_BRACKET, "[",
                T_INTEGER_NUMBER, "2",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}",
                OUTER_CONTENT, ".</p>"
        );
    }
}
