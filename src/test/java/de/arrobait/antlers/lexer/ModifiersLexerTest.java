package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class ModifiersLexerTest extends LexerTest {
    public ModifiersLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void lexer_distinguish_between_variable_and_modifier() {
        givenInput("{{ title | title }}");

        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "title",
                WHITE_SPACE, " ",
                T_PIPE, "|",
                WHITE_SPACE, " ",
                T_MODIFIER, "title",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lexes_single_modifier() {
        givenInput("{{ hello_world | upper }}");

        thenTokensAre(
            T_LD, "{{",
            WHITE_SPACE, " ",
            T_IDENTIFIER, "hello_world",
            WHITE_SPACE, " ",
            T_PIPE, "|",
            WHITE_SPACE, " ",
            T_MODIFIER, "upper",
            WHITE_SPACE, " ",
            T_RD, "}}"
        );
    }

    @Test
    public void lexes_multiple_modifier() {
        givenInput("{{ hello_world | upper | add | lower }}");

        thenTokensAre(
            T_LD, "{{",
            WHITE_SPACE, " ",
            T_IDENTIFIER, "hello_world",
            WHITE_SPACE, " ",
            T_PIPE, "|",
            WHITE_SPACE, " ",
            T_MODIFIER, "upper",
            WHITE_SPACE, " ",
            T_PIPE, "|",
            WHITE_SPACE, " ",
            T_MODIFIER, "add",
            WHITE_SPACE, " ",
            T_PIPE, "|",
            WHITE_SPACE, " ",
            T_MODIFIER, "lower",
            WHITE_SPACE, " ",
            T_RD, "}}"
        );
    }

    @Test
    public void lexes_modifier_with_parameters() {
        givenInput("{{ summary | replace('It was', 'It was also') | replace('times', $noun) }}");

        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "summary",
                WHITE_SPACE, " ",
                T_PIPE, "|",
                WHITE_SPACE, " ",
                T_MODIFIER, "replace",
                T_LP, "(",
                T_STRING_START, "'",
                T_STRING_CONTENT, "It was",
                T_STRING_END, "'",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_STRING_START, "'",
                T_STRING_CONTENT, "It was also",
                T_STRING_END, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_PIPE, "|",
                WHITE_SPACE, " ",
                T_MODIFIER, "replace",
                T_LP, "(",
                T_STRING_START, "'",
                T_STRING_CONTENT, "times",
                T_STRING_END, "'",
                T_COMMA, ",",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$noun",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
