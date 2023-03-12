package de.arrobait.antlers.lexer;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.util.Pair;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

@RunWith(JUnit4.class)
public abstract class LexerTest {
    private final Lexer lexer;

    public LexerTest(Lexer lexer) {
        this.lexer = lexer;
    }

    protected void givenInput(String string) {
        lexer.start(string);
    }

    protected void thenTokensAre(Object... expectedTokenInfo) {
        StringBuilder expected = new StringBuilder();
        for (Object tokenInfo : expectedTokenInfo) {
            if (tokenInfo instanceof IElementType) {
                appendTokenInfo(expected, (IElementType) tokenInfo);
            } else if (tokenInfo instanceof String) {
                appendTokenInfo(expected, (String) tokenInfo);
            } else {
                throw new IllegalArgumentException("Token info must be either IElementType or String.");
            }
        }

        StringBuilder actual = new StringBuilder();
        while (lexer.getCurrentPosition().getOffset() < lexer.getBufferEnd()) {
            appendTokenInfo(actual, lexer.getTokenType(), lexer.getTokenText());
            lexer.advance();
        }

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    private void appendTokenInfo(StringBuilder result, IElementType tokenType, String tokenText) {
        appendTokenInfo(result, tokenType);
        appendTokenInfo(result, tokenText);
    }

    private void appendTokenInfo(StringBuilder result, IElementType tokenType) {
        result.append(tokenType).append(": ");
    }

    private void appendTokenInfo(StringBuilder result, String tokenText) {
        result.append(tokenText).append('\n');
    }

    /**
   	 * Test that lexing a given piece of code will give particular tokens
   	 *
   	 * @param text Sample piece of neon code
   	 * @param expectedTokens List of tokens expected from lexer
   	 */
   	protected void doTest(@NonNls String text, @NonNls Pair<IElementType, String>[] expectedTokens) {
   		doTest(text, expectedTokens, lexer);
   	}

   	private void doTest(String text, Pair<IElementType, String>[] expectedTokens, Lexer lexer) {
   		lexer.start(text);
   		int idx = 0;
   		while (lexer.getTokenType() != null) {
   			if (idx >= expectedTokens.length) fail("Too many tokens from lexer; unexpected " + lexer.getTokenType());

   			Pair<IElementType, String> expected = expectedTokens[idx++];
            IElementType tokenType = lexer.getTokenType();
   			assertEquals("Wrong token", expected.first, tokenType);

   			String tokenText = lexer.getBufferSequence().subSequence(lexer.getTokenStart(), lexer.getTokenEnd()).toString();
   			assertEquals(expected.second, tokenText);
   			lexer.advance();
   		}

   		if (idx < expectedTokens.length) fail("Not enough tokens from lexer, expected " + expectedTokens.length + " but got only " + idx);
   	}
}
