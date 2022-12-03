package de.arrobait.antlers.lexer;

import com.intellij.openapi.util.Pair;
import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class SwitchLexerTest extends LexerTest {
    public SwitchLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lex_switch_node() {
        givenInput("{{ switch(\n" +
                        "        (size == 'sm') => '(min-width: 768px) 35vw, 90vw',\n" +
                        "        (size == 'md') => '(min-width: 768px) 55vw, 90vw',\n" +
                        "        (size == 'lg') => '(min-width: 768px) 75vw, 90vw',\n" +
                        "        (size == 'xl') => '90vw',\n" +
                        "        () => '100vw'\n" +
                        "    )\n" +
                        "}}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SWITCH, "switch",
                T_LP, "(",
                WHITE_SPACE, "\n        ",
                // Cases start

                // 1st case
                T_LP, "(",
                T_IDENTIFIER, "size",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "sm",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "(min-width: 768px) 35vw, 90vw",
                T_SINGLE_QUOTE, "'",
                T_COMMA, ",",
                WHITE_SPACE, "\n        ",

                // 2nd case
                T_LP, "(",
                T_IDENTIFIER, "size",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "md",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "(min-width: 768px) 55vw, 90vw",
                T_SINGLE_QUOTE, "'",
                T_COMMA, ",",
                WHITE_SPACE, "\n        ",

                // 3nd case
                T_LP, "(",
                T_IDENTIFIER, "size",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "lg",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "(min-width: 768px) 75vw, 90vw",
                T_SINGLE_QUOTE, "'",
                T_COMMA, ",",
                WHITE_SPACE, "\n        ",

                // 4th case
                T_LP, "(",
                T_IDENTIFIER, "size",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "xl",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "90vw",
                T_SINGLE_QUOTE, "'",
                T_COMMA, ",",
                WHITE_SPACE, "\n        ",

                // Default case
                T_LP, "(",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "100vw",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, "\n    ",
                // Cases end

                T_RP, ")",
                WHITE_SPACE, "\n",
                T_RD, "}}"
        );
    }
    @Test
    public void it_lex_switch_node_with_multiple_whitespace_between_switch_and_brace() {
        givenInput("{{ switch (\n" +
                        "        (size == 'sm') => '(min-width: 768px) 35vw, 90vw',\n" +
                        "        () => '100vw'\n" +
                        "    )\n" +
                        "}}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SWITCH, "switch",
                WHITE_SPACE, " ",
                T_LP, "(",
                WHITE_SPACE, "\n        ",
                // Cases start

                // 1st case
                T_LP, "(",
                T_IDENTIFIER, "size",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "sm",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "(min-width: 768px) 35vw, 90vw",
                T_SINGLE_QUOTE, "'",
                T_COMMA, ",",
                WHITE_SPACE, "\n        ",

                // Default case
                T_LP, "(",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "100vw",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, "\n    ",
                // Cases end

                T_RP, ")",
                WHITE_SPACE, "\n",
                T_RD, "}}"
        );

        givenInput("{{ switch  (\n" +
                        "        (size == 'sm') => '(min-width: 768px) 35vw, 90vw',\n" +
                        "        () => '100vw'\n" +
                        "    )\n" +
                        "}}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SWITCH, "switch",
                WHITE_SPACE, "  ",
                T_LP, "(",
                WHITE_SPACE, "\n        ",
                // Cases start

                // 1st case
                T_LP, "(",
                T_IDENTIFIER, "size",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "sm",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "(min-width: 768px) 35vw, 90vw",
                T_SINGLE_QUOTE, "'",
                T_COMMA, ",",
                WHITE_SPACE, "\n        ",

                // Default case
                T_LP, "(",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "100vw",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, "\n    ",
                // Cases end

                T_RP, ")",
                WHITE_SPACE, "\n",
                T_RD, "}}"
        );

        givenInput("{{ switch       (\n" +
                        "        (size == 'sm') => '(min-width: 768px) 35vw, 90vw',\n" +
                        "        () => '100vw'\n" +
                        "    )\n" +
                        "}}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_SWITCH, "switch",
                WHITE_SPACE, "       ",
                T_LP, "(",
                WHITE_SPACE, "\n        ",
                // Cases start

                // 1st case
                T_LP, "(",
                T_IDENTIFIER, "size",
                WHITE_SPACE, " ",
                T_OP_EQ, "==",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "sm",
                T_SINGLE_QUOTE, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "(min-width: 768px) 35vw, 90vw",
                T_SINGLE_QUOTE, "'",
                T_COMMA, ",",
                WHITE_SPACE, "\n        ",

                // Default case
                T_LP, "(",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_OP_ARROW, "=>",
                WHITE_SPACE, " ",
                T_SINGLE_QUOTE, "'",
                T_STRING_CONTENT, "100vw",
                T_SINGLE_QUOTE, "'",
                WHITE_SPACE, "\n    ",
                // Cases end

                T_RP, ")",
                WHITE_SPACE, "\n",
                T_RD, "}}"
        );
    }
}
