package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class ComparisonLexerTest extends LexerTest {
    public ComparisonLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lex_tenary_expression() {
        givenInput("{{ is_sold ? \"sold\" : \"for sale\" }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "is_sold",
                WHITE_SPACE, " ",
                T_OP_QUESTIONMARK, "?",
                WHITE_SPACE, " ",
                T_STRING_START, "\"",
                T_STRING_CONTENT, "sold",
                T_STRING_END, "\"",
                WHITE_SPACE, " ",
                T_COLON, ":",
                WHITE_SPACE, " ",
                T_STRING_START, "\"",
                T_STRING_CONTENT, "for sale",
                T_STRING_END, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
