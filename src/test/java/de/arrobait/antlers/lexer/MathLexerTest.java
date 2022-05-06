package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class MathLexerTest extends LexerTest {
    public MathLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_factorial_expressions() {
        givenInput("{{ $a! }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$a",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 5! }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER_NUMBER, "5",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ (5)! }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_INTEGER_NUMBER, "5",
                T_RP, ")",
                T_OP_EXCLAMATION_MARK, "!",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
