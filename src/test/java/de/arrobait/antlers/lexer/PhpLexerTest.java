package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class PhpLexerTest extends LexerTest {
    public PhpLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void is_lex_php_echo() {
        givenInput("{{$ phpinfo(); $}}");

        thenTokensAre(
                T_PHP_ECHO_OPEN, "{{$",
                WHITE_SPACE, " ",
                T_PHP_CONTENT, "phpinfo();",
                WHITE_SPACE, " ",
                T_PHP_ECHO_CLOSE, "$}}"
        );
    }

    @Test
    public void it_lex_php_raw() {
        givenInput("{{? phpinfo(); ?}}");

        thenTokensAre(
                T_PHP_RAW_OPEN, "{{?",
                WHITE_SPACE, " ",
                T_PHP_CONTENT, "phpinfo();",
                WHITE_SPACE, " ",
                T_PHP_RAW_CLOSE, "?}}"
        );
    }
}
