package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class SubexpressionLexerTest extends LexerTest {
    public SubexpressionLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_subexpression() {
        givenInput("{{ ($foo) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_IDENTIFIER, "$foo",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ (10) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_INTEGER_NUMBER, "10",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ (.04) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_FLOAT_NUMBER, ".04",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ ('string') }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_STRING_START, "'",
                T_STRING_CONTENT, "string",
                T_STRING_END, "'",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
