package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class TagsLexerTest extends LexerTest {
    public TagsLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_simple_collection_tag() {
        givenInput("{{ collection }}{{ /collection }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "collection",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_TAG, "collection",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_simple_collection_tag_with_disambiguation() {
        givenInput("{{ %collection }}{{ /collection }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_DISAMBIGUATION, "%",
                T_TAG, "collection",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_TAG, "collection",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_collection_tag_with_shorthand_from() {
        givenInput("{{ collection:blog }}{{ /collection:blog }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "collection",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "blog",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_TAG, "collection",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "blog",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_collection_tag_with_from_attribute() {
        givenInput("{{ collection from=\"blog\" }}{{ /collection }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "collection",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "from",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "blog",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_TAG, "collection",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ collection from=\"blog|pages\" }}{{ /collection }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "collection",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "from",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "blog|pages",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_TAG, "collection",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_svg_tag() {
        givenInput("{{ svg src=\"icons/hamburger\" class=\"w-8 h-8\" }}{{ /svg }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "svg",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "src",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "icons/hamburger",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "class",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "w-8 h-8",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_TAG, "svg",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_interpolation_in_tags() {
        givenInput("{{ collection:blog limit=\"{entry_limit ?? 10}\" }}{{ /collection:blog }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "collection",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "blog",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "limit",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "{entry_limit ?? 10}",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_TAG, "collection",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "blog",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ nav from=\"{segment_1}/{segment_2}\" }}{{ /nav }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "nav",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "from",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "{segment_1}/{segment_2}",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_TAG, "nav",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_dynamic_binding() {
        givenInput("{{ nav :from=\"segment_1\" }}{{ /nav }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "nav",
                WHITE_SPACE, " ",
                T_DYNAMIC_BINDING, ":",
                T_IDENTIFIER, "from",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "segment_1",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_TAG, "nav",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_stop_lexing_after_shorthand_separator() {
        givenInput("{{ user:can do=\"edit faq entries\" }}{{ /user:can }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "user",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "can",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "do",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "edit faq entries",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_TAG, "user",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "can",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_nav_multi_depth_collection() {
        givenInput("{{ nav:collection:pages }}{{ /nav:collection:pages }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_TAG, "nav",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "collection",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "pages",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_TAG, "nav",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "collection",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "pages",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
