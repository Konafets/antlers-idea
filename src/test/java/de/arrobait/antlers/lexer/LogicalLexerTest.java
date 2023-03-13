package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class LogicalLexerTest extends LexerTest {
    public LogicalLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void lex_and_expression() {
        givenInput("{{ 10 && 20 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER, "10",
                WHITE_SPACE, " ",
                T_OP_AND, "&&",
                WHITE_SPACE, " ",
                T_INTEGER, "20",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo && 20 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_AND, "&&",
                WHITE_SPACE, " ",
                T_INTEGER, "20",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 10 and 20 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER, "10",
                WHITE_SPACE, " ",
                T_OP_AND, "and",
                WHITE_SPACE, " ",
                T_INTEGER, "20",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo and 20 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_AND, "and",
                WHITE_SPACE, " ",
                T_INTEGER, "20",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_or_expression() {
        givenInput("{{ 10 || 20 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER, "10",
                WHITE_SPACE, " ",
                T_OP_OR, "||",
                WHITE_SPACE, " ",
                T_INTEGER, "20",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo || 20 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_OR, "||",
                WHITE_SPACE, " ",
                T_INTEGER, "20",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 10 or 20 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER, "10",
                WHITE_SPACE, " ",
                T_OP_OR, "or",
                WHITE_SPACE, " ",
                T_INTEGER, "20",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo or 20 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_OR, "or",
                WHITE_SPACE, " ",
                T_INTEGER, "20",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_not_expression() {
        givenInput("{{ !foo }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_IDENTIFIER, "foo",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ !$foo }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ !54 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_INTEGER, "54",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ !!variable }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_OP_EXCLAMATION_MARK, "!",
                T_IDENTIFIER, "variable",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ !!(variable) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_OP_EXCLAMATION_MARK, "!",
                T_LP, "(",
                T_IDENTIFIER, "variable",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ !(!variable) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_LP, "(",
                T_OP_EXCLAMATION_MARK, "!",
                T_IDENTIFIER, "variable",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ (!variable) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_LP, "(",
                T_OP_EXCLAMATION_MARK, "!",
                T_IDENTIFIER, "variable",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ !(variable) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_LP, "(",
                T_IDENTIFIER, "variable",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ !!!variable }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_OP_EXCLAMATION_MARK, "!",
                T_OP_EXCLAMATION_MARK, "!",
                T_IDENTIFIER, "variable",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ !variable && !variable }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_IDENTIFIER, "variable",
                WHITE_SPACE, " ",
                T_OP_AND, "&&",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_IDENTIFIER, "variable",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ !variable && !!(!variable) }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_IDENTIFIER, "variable",
                WHITE_SPACE, " ",
                T_OP_AND, "&&",
                WHITE_SPACE, " ",
                T_OP_EXCLAMATION_MARK, "!",
                T_OP_EXCLAMATION_MARK, "!",
                T_LP, "(",
                T_OP_EXCLAMATION_MARK, "!",
                T_IDENTIFIER, "variable",
                T_RP, ")",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void lex_xor_expression() {
        givenInput("{{ 10 xor 20 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER, "10",
                WHITE_SPACE, " ",
                T_OP_XOR, "xor",
                WHITE_SPACE, " ",
                T_INTEGER, "20",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ 10 xor 20 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_INTEGER, "10",
                WHITE_SPACE, " ",
                T_OP_XOR, "xor",
                WHITE_SPACE, " ",
                T_INTEGER, "20",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );

        givenInput("{{ $foo xor 20 }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_IDENTIFIER, "$foo",
                WHITE_SPACE, " ",
                T_OP_XOR, "xor",
                WHITE_SPACE, " ",
                T_INTEGER, "20",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
