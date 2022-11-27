package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class ConcatLexerTest extends LexerTest {
    public ConcatLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_concat_string_with_string() {
        givenInput("{{ 'hello' + ',world' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "hello",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, ",world",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_concat_number_with_string() {
        givenInput("{{ 10 + 'Foo' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "Foo",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ -10 + 'Foo' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "Foo",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 'Foo' + 10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "Foo",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 'Foo' + -10 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "Foo",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_OP_MINUS, "-",
                T_INTEGER_NUMBER, "10",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_concat_string_with_variable() {
        givenInput("{{ 'Foo' + foo }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "Foo",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "foo",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 'Foo' + $foo }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "Foo",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ foo + 'Foo' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "foo",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "Foo",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo + 'Foo' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_PLUS, "+",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "Foo",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_concat_through_self_assignment() {
        givenInput("{{ string += ' World' }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "string",
                WHITE_SPACE, " ",
                T_OP_SELF_ASSIGN_ADD, "+=",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, " World",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
