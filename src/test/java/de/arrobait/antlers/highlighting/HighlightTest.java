package de.arrobait.antlers.highlighting;

import de.arrobait.antlers.highlighting.HighlightTestCase;

public class HighlightTest extends HighlightTestCase {
    public HighlightTest() {
        super("highlighting", "antlers.html");
    }

    public void testHighlightComments() {
        doTest();
    }

    @Override
    protected String getTestDataPath() {
        return "src/test/testData";
    }
}
