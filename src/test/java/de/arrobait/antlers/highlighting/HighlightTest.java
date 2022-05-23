package de.arrobait.antlers.highlighting;

import de.arrobait.antlers.highlighting.HighlightTestCase;
import org.junit.Ignore;

@Ignore
public class HighlightTest extends HighlightTestCase {
    public HighlightTest() {
        super("highlighting", "antlers.html");
    }

    public void testHighlightComments() {
        doTest();
    }

    public void testHighlightBooleans() {
        doTest();
    }

    public void testHighlightStrings() {
        doTest();
    }

    public void testHighlightNumbers() {
        doTest();
    }

    public void testHighlightVariables() {
        doTest();
    }

    public void testHighlightOperators() {
        doTest();
    }

    public void testHighlightCommas() {
        doTest();
    }

    public void testHighlightParentheses() {
        doTest();
    }

    public void testHighlightTags() {
        doTest();
    }

    public void testHighlightTagConditions() {
        doTest();
    }

    @Override
    protected String getTestDataPath() {
        return "src/test/testData";
    }
}
