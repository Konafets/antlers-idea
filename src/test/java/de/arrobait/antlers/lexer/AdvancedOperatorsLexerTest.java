package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class AdvancedOperatorsLexerTest extends LexerTest {
    public AdvancedOperatorsLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_simple_groupby() {
        givenInput("{{ items = players groupby (team) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "items",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "players",
                WHITE_SPACE, " ",
                T_GROUP_BY, "groupby",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_IDENTIFIER, "team",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_simple_groupby_with_as() {
        givenInput("{{ items = players groupby (team) as 'foo' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "items",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "players",
                WHITE_SPACE, " ",
                T_GROUP_BY, "groupby",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_IDENTIFIER, "team",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_AS, "as",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "foo",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_groupby_with_multiple_fields() {
        givenInput("{{ items = players groupby (field1, field2) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "items",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "players",
                WHITE_SPACE, " ",
                T_GROUP_BY, "groupby",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_IDENTIFIER, "field1",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "field2",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ items = players groupby (field1 'alias1', field2 'alias2') }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "items",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "players",
                WHITE_SPACE, " ",
                T_GROUP_BY, "groupby",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_IDENTIFIER, "field1",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "alias1",
                T_SINGLE_QUOTE, "'",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "field2",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "alias2",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ items = players groupby (field1 'alias1', field2 'alias2') as 'foo' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "items",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "players",
                WHITE_SPACE, " ",
                T_GROUP_BY, "groupby",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_IDENTIFIER, "field1",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "alias1",
                T_SINGLE_QUOTE, "'",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "field2",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "alias2",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_AS, "as",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "foo",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_complex_groupby() {
        givenInput("{{ blog = {collection:blog} groupby (date|format('Y') 'year') as 'entries' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "blog",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LEFT_BRACE, "{",
                T_TAG, "collection",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "blog",
                T_RIGHT_BRACE, "}",
                WHITE_SPACE, " ",
                T_GROUP_BY, "groupby",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_IDENTIFIER, "date",
                T_PIPE, "|",
                T_MODIFIER, "format",
                T_LP, "(",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "Y",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "year",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_AS, "as",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "entries",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_groupby_with_arrow_function() {
        givenInput("{{ grouped = products groupby ((x => x:category)) as 'my_group' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "grouped",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "products",
                WHITE_SPACE, " ",
                T_GROUP_BY, "groupby",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_LP, "(",
                T_IDENTIFIER, "x",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "x",
                T_COLON, ":",
                T_IDENTIFIER, "category",
                T_RP, ")",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_AS, "as",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "my_group",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_groupby_with_arrow_function_and_dot_notation() {
        givenInput("{{ grouped = products groupby ((x => x.title == 'something')) as 'my_group' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "grouped",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "products",
                WHITE_SPACE, " ",
                T_GROUP_BY, "groupby",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_LP, "(",
                T_IDENTIFIER, "x",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "x",
                T_DOT, ".",
                T_IDENTIFIER, "title",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "something",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_AS, "as",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "my_group",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
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
                T_COLON, ":",
                T_TAG_METHOD_NAME, "headlines",
                T_RIGHT_BRACE, "}",
                WHITE_SPACE, " ",
                T_MERGE, "merge",
                WHITE_SPACE, " ",
                T_LEFT_BRACE, "{",
                T_TAG, "collection",
                T_COLON, ":",
                T_TAG_METHOD_NAME, "news",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "limit",
                T_OP_ASSIGN, "=",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "5",
                T_DOUBLE_QUOTE, "\"",
                T_RIGHT_BRACE, "}",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_simple_orderby() {
        givenInput("{{ people = people orderby (age 'desc', last_name 'asc', first_name 'asc') }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "people",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "people",
                WHITE_SPACE, " ",
                T_ORDER_BY, "orderby",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_IDENTIFIER, "age",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "desc",
                T_SINGLE_QUOTE, "'",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "last_name",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "asc",
                T_SINGLE_QUOTE, "'",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "first_name",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "asc",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_simple_pluck() {
        givenInput("{{ articles = articles pluck ('name') }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "articles",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "articles",
                WHITE_SPACE, " ",
                T_PLUCK, "pluck",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "name",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_simple_skip() {
        givenInput("{{ articles = articles skip (2) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "articles",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "articles",
                WHITE_SPACE, " ",
                T_SKIP, "skip",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_INTEGER, "2",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_simple_take() {
        givenInput("{{ articles = articles take (2) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "articles",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "articles",
                WHITE_SPACE, " ",
                T_TAKE, "take",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_INTEGER, "2",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_simple_where() {
        givenInput("{{ bulls = players where (team == \"Chicago Bulls\") }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "bulls",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "players",
                WHITE_SPACE, " ",
                T_WHERE, "where",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_IDENTIFIER, "team",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "Chicago Bulls",
                T_DOUBLE_QUOTE, "\"",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ electronic = products where\n" +
                "  (name == \"Talkboy\" || name == \"Super Nintendo\")\n" +
                "}}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "electronic",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "products",
                WHITE_SPACE, " ",
                T_WHERE, "where",
                WHITE_SPACE, "\n  ",
                T_LP, "(",
                T_IDENTIFIER, "name",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "Talkboy",
                T_DOUBLE_QUOTE, "\"",
                WHITE_SPACE, " ",
                T_OP_OR, "||",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "name",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, "Super Nintendo",
                T_DOUBLE_QUOTE, "\"",
                T_RP, ")",
                WHITE_SPACE, "\n",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_where_with_arrow_function() {
        givenInput("{{ afford = products where (x => x.price < budget) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "afford",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "products",
                WHITE_SPACE, " ",
                T_WHERE, "where",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_IDENTIFIER, "x",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "x",
                T_DOT, ".",
                T_IDENTIFIER, "price",
                WHITE_SPACE, " ",
                T_OP_LT, "<",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "budget",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_chained_advanced_operators() {
        givenInput("{{ people = people take(20) pluck(name) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "people",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "people",
                WHITE_SPACE, " ",
                T_TAKE, "take",
                T_LP, "(",
                T_INTEGER, "20",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_PLUCK, "pluck",
                T_LP, "(",
                T_IDENTIFIER, "name",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_the_terminator() {
        givenInput("{{ $michael = 9986000; $minutes_in_a_year = 60 * 24 * 365; (($michael / $minutes_in_a_year) | format_number(0)) + \" years\"; }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$michael",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_INTEGER, "9986000",
                T_SEMICOLON, ";",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$minutes_in_a_year",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_INTEGER, "60",
                WHITE_SPACE, " ",
                T_OP_MUL, "*",
                WHITE_SPACE, " ",
                T_INTEGER, "24",
                WHITE_SPACE, " ",
                T_OP_MUL, "*",
                WHITE_SPACE, " ",
                T_INTEGER, "365",
                T_SEMICOLON, ";",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_LP, "(",
                T_IDENTIFIER, "$michael",
                WHITE_SPACE, " ",
                T_SLASH, "/",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$minutes_in_a_year",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_PIPE, "|",
                WHITE_SPACE, " ",
                T_MODIFIER, "format_number",
                T_LP, "(",
                T_INTEGER, "0",
                T_RP, ")",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_DOUBLE_QUOTE, "\"",
                T_STRING_CONTENT, " years",
                T_DOUBLE_QUOTE, "\"",
                T_SEMICOLON, ";",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
