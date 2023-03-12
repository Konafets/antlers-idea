package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class PropertyAccessLexerTest extends LexerTest {
    public PropertyAccessLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lex_colon_property_access_on_array() {
        givenInput("{{ skaters:0 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "skaters",
                T_COLON, ":",
                T_INTEGER_NUMBER, "0",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ skaters:0:name }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "skaters",
                T_COLON, ":",
                T_INTEGER_NUMBER, "0",
                T_COLON, ":",
                T_IDENTIFIER, "name",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ skaters:name }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "skaters",
                T_COLON, ":",
                T_IDENTIFIER, "name",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lex_dot_property_access_on_array() {
        givenInput("{{ sports.0 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "sports",
                T_DOT, ".",
                T_INTEGER_NUMBER, "0",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ skaters.1.name }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "skaters",
                T_DOT, ".",
                T_INTEGER_NUMBER, "1",
                T_DOT, ".",
                T_IDENTIFIER, "name",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lex_bracket_property_access_on_array() {
        givenInput("{{ sports[2] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "sports",
                T_LEFT_BRACKET, "[",
                T_INTEGER_NUMBER, "2",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ skaters[2]['name'] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "skaters",
                T_LEFT_BRACKET, "[",
                T_INTEGER_NUMBER, "2",
                T_RIGHT_BRACKET, "]",
                T_LEFT_BRACKET, "[",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "name",
                T_SINGLE_QUOTE, "'",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ skaters['name']['name'] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "skaters",
                T_LEFT_BRACKET, "[",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "name",
                T_SINGLE_QUOTE, "'",
                T_RIGHT_BRACKET, "]",
                T_LEFT_BRACKET, "[",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "name",
                T_SINGLE_QUOTE, "'",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ complex_data[3][field]['title'] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "complex_data",
                T_LEFT_BRACKET, "[",
                T_INTEGER_NUMBER, "3",
                T_RIGHT_BRACKET, "]",
                T_LEFT_BRACKET, "[",
                T_IDENTIFIER, "field",
                T_RIGHT_BRACKET, "]",
                T_LEFT_BRACKET, "[",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "title",
                T_SINGLE_QUOTE, "'",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lex_property_access_inside_property_access() {
        givenInput("{{ sizes[size.label] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "sizes",
                T_LEFT_BRACKET, "[",
                T_IDENTIFIER, "size",
                T_DOT, ".",
                T_IDENTIFIER, "label",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ sizes[size_two.label] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "sizes",
                T_LEFT_BRACKET, "[",
                T_IDENTIFIER, "size_two",
                T_DOT, ".",
                T_IDENTIFIER, "label",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ view:sizes[size:label] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "view",
                T_COLON, ":",
                T_IDENTIFIER, "sizes",
                T_LEFT_BRACKET, "[",
                T_IDENTIFIER, "size",
                T_COLON, ":",
                T_IDENTIFIER, "label",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    };
}
