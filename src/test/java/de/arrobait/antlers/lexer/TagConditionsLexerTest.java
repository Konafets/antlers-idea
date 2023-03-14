package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class TagConditionsLexerTest extends LexerTest {
    public TagConditionsLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_tag_conditions() {
        givenInput("{{ collection:blog title:contains=\"awesome\" title:contains=\"thing\" author:is=\"joe\" }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "collection",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "blog",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "title",
                T_TAG_CONDITION, ":contains",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "awesome",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "title",
                T_TAG_CONDITION, ":contains",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "thing",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "author",
                T_TAG_CONDITION, ":is",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "joe",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_tax_taxonomy_conditions() {
        givenInput("{{ collection:blog taxonomy:tags=\"harry-potter\" }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "collection",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "blog",
                WHITE_SPACE, " ",
                T_TAXONOMY, "taxonomy:",
                T_IDENTIFIER, "tags",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "harry-potter",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
