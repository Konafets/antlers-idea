package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class MergeLexerTest extends LexerTest {
    public MergeLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_simple_merge() {
        givenInput("{{ articles = favourite_articles merge not_favourite_articles }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "articles",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "favourite_articles",
                WHITE_SPACE, " ",
                T_MERGE, "merge",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "not_favourite_articles",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_merge_with_interpolation() {
        givenInput("{{ items = {collection:headlines} merge {collection:news limit=\"5\"} }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "items",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LEFT_BRACE, "{",
                T_TAG, "collection",
                T_SHORTHAND_SEPARATOR, ":",
                T_TAG_METHOD_NAME, "headlines",
                T_RIGHT_BRACE, "}",
                WHITE_SPACE, " ",
                T_MERGE, "merge",
                WHITE_SPACE, " ",
                T_LEFT_BRACE, "{",
                T_TAG, "collection",
                T_SHORTHAND_SEPARATOR, ":",
                T_TAG_METHOD_NAME, "news",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "limit",
                T_OP_ASSIGN, "=",
                T_STRING_START, "\"",
                T_STRING_CONTENT, "5",
                T_STRING_END, "\"",
                T_RIGHT_BRACE, "}",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
