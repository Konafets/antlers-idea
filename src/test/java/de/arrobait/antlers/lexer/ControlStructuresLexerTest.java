package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class ControlStructuresLexerTest extends LexerTest {
    public ControlStructuresLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void lex_if_condition_boolean() {
        givenInput("{{ if true }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_TRUE, "true",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ if false }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_FALSE, "false",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_unless_condition_boolean() {
        givenInput("{{ unless true }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_UNLESS, "unless",
                WHITE_SPACE, " ",
                T_TRUE, "true",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ unless false }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_UNLESS, "unless",
                WHITE_SPACE, " ",
                T_FALSE, "false",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_if_condition_variable() {
        givenInput("{{ if logged_out }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "logged_out",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_if_condition_comparison() {
        givenInput("{{ if songs == 1 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "songs",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ if songs != 1 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "songs",
                WHITE_SPACE, " ",
                T_OP_NEQ, "!=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ if songs === 1 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "songs",
                WHITE_SPACE, " ",
                T_OP_IDENT, "===",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ if songs !== 1 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "songs",
                WHITE_SPACE, " ",
                T_OP_NOT_IDENT, "!==",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ if songs > 100 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "songs",
                WHITE_SPACE, " ",
                T_OP_GT, ">",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "100",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ if songs >= 100 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "songs",
                WHITE_SPACE, " ",
                T_OP_GTE, ">=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "100",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ if songs < 100 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "songs",
                WHITE_SPACE, " ",
                T_OP_LT, "<",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "100",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ if songs <= 100 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "songs",
                WHITE_SPACE, " ",
                T_OP_LTE, "<=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "100",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_if_condition_with_interpolated_statement() {
        givenInput("{{ if {1} >= 100 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_LEFT_BRACE, "{",
                T_INTEGER_NUMBER, "1",
                T_RIGHT_BRACE, "}",
                WHITE_SPACE, " ",
                T_OP_GTE, ">=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "100",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_if_condition_with_slash_end() {
        givenInput("{{ if false }}{{# Foo #}}{{ /if }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_FALSE, "false",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_COMMENT_OPEN, "{{#",
                T_COMMENT_TEXT, " Foo ",
                T_COMMENT_CLOSE, "#}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_unless_condition_with_slash_end() {
        givenInput("{{ unless false }}{{# Foo #}}{{ /unless }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_UNLESS, "unless",
                WHITE_SPACE, " ",
                T_FALSE, "false",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_COMMENT_OPEN, "{{#",
                T_COMMENT_TEXT, " Foo ",
                T_COMMENT_CLOSE, "#}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_UNLESS, "unless",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_if_condition_with_endif() {
        givenInput("{{ if false }}{{# Foo #}}{{ endif }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_FALSE, "false",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_COMMENT_OPEN, "{{#",
                T_COMMENT_TEXT, " Foo ",
                T_COMMENT_CLOSE, "#}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_END_IF, "endif",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_if_condition_with_endunless() {
        givenInput("{{ unless false }}{{# Foo #}}{{ endunless }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_UNLESS, "unless",
                WHITE_SPACE, " ",
                T_FALSE, "false",
                WHITE_SPACE, " ",
                T_RD, "}}",
                T_COMMENT_OPEN, "{{#",
                T_COMMENT_TEXT, " Foo ",
                T_COMMENT_CLOSE, "#}}",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_END_UNLESS, "endunless",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_else_node() {
        givenInput("{{ else }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_ELSE, "else",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_elseif_node() {
        givenInput("{{ elseif }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_ELSE_IF, "elseif",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_if_else_block() {
        givenInput("{{ if songs === 1 }}\n" +
                "  <p>This is a song!</p>\n" +
                "{{ elseif songs > 100 }}\n" +
                "  <p>This is noisy!</p>\n" +
                "{{ elseif songs }}\n" +
                "  <p>There are some songs here.</p>\n" +
                "{{ else }}\n" +
                "  <p>It is quiet.</p>\n" +
                "{{ /if }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "songs",
                WHITE_SPACE, " ",
                T_OP_IDENT, "===",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "1",
                WHITE_SPACE, " ",
                T_RD, "}}",
                OUTER_CONTENT, "\n  <p>This is a song!</p>\n",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_ELSE_IF, "elseif",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "songs",
                WHITE_SPACE, " ",
                T_OP_GT, ">",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "100",
                WHITE_SPACE, " ",
                T_RD, "}}",
                OUTER_CONTENT, "\n  <p>This is noisy!</p>\n",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_ELSE_IF, "elseif",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "songs",
                WHITE_SPACE, " ",
                T_RD, "}}",
                OUTER_CONTENT, "\n  <p>There are some songs here.</p>\n",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_ELSE, "else",
                WHITE_SPACE, " ",
                T_RD, "}}",
                OUTER_CONTENT, "\n  <p>It is quiet.</p>\n",
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                T_IF, "if",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
