package de.arrobait.antlers.lexer;

import com.intellij.openapi.util.Pair;
import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class VariableLexerTest extends LexerTest {
    public VariableLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lex_identifier() {
        givenInput("{{ foo }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "foo",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lex_variable_assignments() {
        givenInput("{{ $foo = true }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_TRUE, "true",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo = 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo = 0.10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_FLOAT_NUMBER, "0.10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo = 'hello_world' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "hello_world",
                T_STRING_END, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo = (10) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_INTEGER_NUMBER, "10",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo = {10} }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LEFT_BRACE, "{",
                T_INTEGER_NUMBER, "10",
                T_RIGHT_BRACE, "}",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lex_assign_array_to_variable() {
        givenInput("{{ $foo = [10] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LEFT_BRACKET, "[",
                T_INTEGER_NUMBER, "10",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ total = ['Foo'] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "total",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LEFT_BRACKET, "[",
                T_STRING_START, "'",
                T_STRING_CONTENT, "Foo",
                T_STRING_END, "'",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ total = ['Foo',] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "total",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LEFT_BRACKET, "[",
                T_STRING_START, "'",
                T_STRING_CONTENT, "Foo",
                T_STRING_END, "'",
                T_COMMA, ",",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ total = ['Foo', 'Bar'] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "total",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LEFT_BRACKET, "[",
                T_STRING_START, "'",
                T_STRING_CONTENT, "Foo",
                T_STRING_END, "'",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "Bar",
                T_STRING_END, "'",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ total = [10, 4.2] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "total",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LEFT_BRACKET, "[",
                T_INTEGER_NUMBER, "10",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_FLOAT_NUMBER, "4.2",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ total = [10, 4.2, ['another', 'array']] }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "total",
                WHITE_SPACE, " ",
                T_OP_ASSIGN, "=",
                WHITE_SPACE, " ",
                T_LEFT_BRACKET, "[",
                T_INTEGER_NUMBER, "10",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_FLOAT_NUMBER, "4.2",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_LEFT_BRACKET, "[",
                T_STRING_START, "'",
                T_STRING_CONTENT, "another",
                T_STRING_END, "'",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "array",
                T_STRING_END, "'",
                T_RIGHT_BRACKET, "]",
                T_RIGHT_BRACKET, "]",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
