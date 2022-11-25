package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static de.arrobait.antlers.psi.AntlersTypes.*;

public class AntlersCommentsLexerTest extends LexerTest {
    public AntlersCommentsLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void is_parses_simple_comments() {
        givenInput("{{# This is a comment #}}");

        thenTokensAre(
                T_COMMENT_OPEN, "{{#",
                T_COMMENT_TEXT, " This is a comment ",
                T_COMMENT_CLOSE, "#}}"
        );

        givenInput("{{# {{ collection:count from=\"articles\" }} #}}");

        thenTokensAre(
                T_COMMENT_OPEN, "{{#",
                T_COMMENT_TEXT, " {{ collection:count from=\"articles\" }} ",
                T_COMMENT_CLOSE, "#}}"
        );
    }

    @Test
    public void test_antlers_in_comment() {
        givenInput("{{# {{ validate | contains:required ?= \"required\" }} #}}");

        thenTokensAre(
                T_COMMENT_OPEN, "{{#",
                T_COMMENT_TEXT, " {{ validate | contains:required ?= \"required\" }} ",
                T_COMMENT_CLOSE, "#}}"
        );

        givenInput("{{# test comment {{ var }} #}}<p>I am a literal.</p>");

        thenTokensAre(
                T_COMMENT_OPEN, "{{#",
                T_COMMENT_TEXT, " test comment {{ var }} ",
                T_COMMENT_CLOSE, "#}}",
                OUTER_CONTENT, "<p>I am a literal.</p>"
        );
    }

    @Test
    public void testMultilineComments() {
        givenInput("{{#\n" +
                "    A multiline comment\n" +
                "#}}");

        thenTokensAre(
                T_COMMENT_OPEN, "{{#",
                T_COMMENT_TEXT, "\n    A multiline comment\n",
                T_COMMENT_CLOSE, "#}}"
        );
    }

    @Test
    public void testUnclosedComment() {
        givenInput("{{# An unclosed comment");

        thenTokensAre(
                T_COMMENT_OPEN, "{{#",
                T_UNCLOSED_COMMENT, " An unclosed comment"
        );
    }
}
