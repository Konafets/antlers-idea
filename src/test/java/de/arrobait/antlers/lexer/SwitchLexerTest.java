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
        doTest("{{ switch(\n" +
                "        (size == 'sm') => '(min-width: 768px) 35vw, 90vw',\n" +
                "        (size == 'md') => '(min-width: 768px) 55vw, 90vw',\n" +
                "        (size == 'lg') => '(min-width: 768px) 75vw, 90vw',\n" +
                "        (size == 'xl') => '90vw',\n" +
                "        () => '100vw'\n" +
                "    )\n" +
                "}}", new Pair[] {
                ld(),
                ws(),
                Pair.create(T_SWITCH, "switch"),
                Pair.create(T_LP, "("),
                Pair.create(WHITE_SPACE, "\n        "),
                // Cases start

                // 1st case
                Pair.create(T_LP, "("),
                Pair.create(T_IDENTIFIER, "size"),
                ws(),
                Pair.create(T_OP_EQ, "=="),
                ws(),
                Pair.create(T_STRING_START, "'"),
                Pair.create(T_STRING_CONTENT, "sm"),
                Pair.create(T_STRING_END, "'"),
                Pair.create(T_RP, ")"),
                ws(),
                Pair.create(T_OP_ARROW, "=>"),
                ws(),
                Pair.create(T_STRING_START, "'"),
                Pair.create(T_STRING_CONTENT, "(min-width: 768px) 35vw, 90vw"),
                Pair.create(T_STRING_END, "'"),
                Pair.create(T_COMMA, ","),
                Pair.create(WHITE_SPACE, "\n        "),

                // 2nd case
                Pair.create(T_LP, "("),
                Pair.create(T_IDENTIFIER, "size"),
                ws(),
                Pair.create(T_OP_EQ, "=="),
                ws(),
                Pair.create(T_STRING_START, "'"),
                Pair.create(T_STRING_CONTENT, "md"),
                Pair.create(T_STRING_END, "'"),
                Pair.create(T_RP, ")"),
                ws(),
                Pair.create(T_OP_ARROW, "=>"),
                ws(),
                Pair.create(T_STRING_START, "'"),
                Pair.create(T_STRING_CONTENT, "(min-width: 768px) 55vw, 90vw"),
                Pair.create(T_STRING_END, "'"),
                Pair.create(T_COMMA, ","),
                Pair.create(WHITE_SPACE, "\n        "),

                // 3nd case
                Pair.create(T_LP, "("),
                Pair.create(T_IDENTIFIER, "size"),
                ws(),
                Pair.create(T_OP_EQ, "=="),
                ws(),
                Pair.create(T_STRING_START, "'"),
                Pair.create(T_STRING_CONTENT, "lg"),
                Pair.create(T_STRING_END, "'"),
                Pair.create(T_RP, ")"),
                ws(),
                Pair.create(T_OP_ARROW, "=>"),
                ws(),
                Pair.create(T_STRING_START, "'"),
                Pair.create(T_STRING_CONTENT, "(min-width: 768px) 75vw, 90vw"),
                Pair.create(T_STRING_END, "'"),
                Pair.create(T_COMMA, ","),
                Pair.create(WHITE_SPACE, "\n        "),

                // 4th case
                Pair.create(T_LP, "("),
                Pair.create(T_IDENTIFIER, "size"),
                ws(),
                Pair.create(T_OP_EQ, "=="),
                ws(),
                Pair.create(T_STRING_START, "'"),
                Pair.create(T_STRING_CONTENT, "xl"),
                Pair.create(T_STRING_END, "'"),
                Pair.create(T_RP, ")"),
                ws(),
                Pair.create(T_OP_ARROW, "=>"),
                ws(),
                Pair.create(T_STRING_START, "'"),
                Pair.create(T_STRING_CONTENT, "90vw"),
                Pair.create(T_STRING_END, "'"),
                Pair.create(T_COMMA, ","),
                Pair.create(WHITE_SPACE, "\n        "),

                // Default case
                Pair.create(T_LP, "("),
                Pair.create(T_RP, ")"),
                ws(),
                Pair.create(T_OP_ARROW, "=>"),
                ws(),
                Pair.create(T_STRING_START, "'"),
                Pair.create(T_STRING_CONTENT, "100vw"),
                Pair.create(T_STRING_END, "'"),
                Pair.create(WHITE_SPACE, "\n    "),
                // Cases end

                Pair.create(T_RP, ")"),
                Pair.create(WHITE_SPACE, "\n"),
                rd(),
        });
    }
}
