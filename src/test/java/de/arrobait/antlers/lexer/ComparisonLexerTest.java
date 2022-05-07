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

    @Test
    public void lex_equals_expression() {
        givenInput("{{ the_answer == 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "the_answer",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $the_answer == 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$the_answer",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 20 == 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "20",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 20 == '10' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "20",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "10",
                T_STRING_END, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 20 == \"10\" }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "20",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_STRING_START, "\"",
                T_STRING_CONTENT, "10",
                T_STRING_END, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_not_equals_expression() {
        givenInput("{{ the_answer != 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "the_answer",
                WHITE_SPACE, " ",
                T_OP_NEQ, "!=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $the_answer != 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$the_answer",
                WHITE_SPACE, " ",
                T_OP_NEQ, "!=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 20 != 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "20",
                WHITE_SPACE, " ",
                T_OP_NEQ, "!=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_identical_expression() {
        givenInput("{{ the_answer === 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "the_answer",
                WHITE_SPACE, " ",
                T_OP_IDENT, "===",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $the_answer === 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$the_answer",
                WHITE_SPACE, " ",
                T_OP_IDENT, "===",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 20 === 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "20",
                WHITE_SPACE, " ",
                T_OP_IDENT, "===",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_not_identical_expression() {
        givenInput("{{ the_answer !== 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "the_answer",
                WHITE_SPACE, " ",
                T_OP_NOT_IDENT, "!==",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $the_answer !== 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$the_answer",
                WHITE_SPACE, " ",
                T_OP_NOT_IDENT, "!==",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 20 !== 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "20",
                WHITE_SPACE, " ",
                T_OP_NOT_IDENT, "!==",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_greater_than_expression() {
        givenInput("{{ the_answer > 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "the_answer",
                WHITE_SPACE, " ",
                T_OP_GT, ">",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $the_answer > 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$the_answer",
                WHITE_SPACE, " ",
                T_OP_GT, ">",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 20 > 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "20",
                WHITE_SPACE, " ",
                T_OP_GT, ">",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_greater_than_equals_expression() {
        givenInput("{{ the_answer >= 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "the_answer",
                WHITE_SPACE, " ",
                T_OP_GTE, ">=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $the_answer >= 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$the_answer",
                WHITE_SPACE, " ",
                T_OP_GTE, ">=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 20 >= 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "20",
                WHITE_SPACE, " ",
                T_OP_GTE, ">=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_lower_than_expression() {
        givenInput("{{ the_answer < 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "the_answer",
                WHITE_SPACE, " ",
                T_OP_LT, "<",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $the_answer < 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$the_answer",
                WHITE_SPACE, " ",
                T_OP_LT, "<",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 20 < 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "20",
                WHITE_SPACE, " ",
                T_OP_LT, "<",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_lower_than_equals_expression() {
        givenInput("{{ the_answer <= 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "the_answer",
                WHITE_SPACE, " ",
                T_OP_LTE, "<=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $the_answer <= 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$the_answer",
                WHITE_SPACE, " ",
                T_OP_LTE, "<=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 20 <= 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "20",
                WHITE_SPACE, " ",
                T_OP_LTE, "<=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_spaceship_expression() {
        givenInput("{{ foo <=> bar }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "foo",
                WHITE_SPACE, " ",
                T_OP_SPACESHIP, "<=>",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "bar",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );


        givenInput("{{ $foo <=> bar }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_SPACESHIP, "<=>",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "bar",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 20 <=> 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "20",
                WHITE_SPACE, " ",
                T_OP_SPACESHIP, "<=>",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo <=> 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_SPACESHIP, "<=>",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ foo <=> 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "foo",
                WHITE_SPACE, " ",
                T_OP_SPACESHIP, "<=>",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lex_null_coalascene_expression() {
        givenInput("{{ meta_title ?? title ?? \"Someone Forgot the Title\" }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "meta_title",
                WHITE_SPACE, " ",
                T_OP_NULL_COALESCENCE, "??",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "title",
                WHITE_SPACE, " ",
                T_OP_NULL_COALESCENCE, "??",
                WHITE_SPACE, " ",
                T_STRING_START, "\"",
                T_STRING_CONTENT, "Someone Forgot the Title",
                T_STRING_END, "\"",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lex_gatekeeper_expression() {
        givenInput("{{ show_bio ?= author:bio }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "show_bio",
                WHITE_SPACE, " ",
                T_OP_GATEKEEPER, "?=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "author",
                T_COLON, ":",
                T_IDENTIFIER, "bio",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
