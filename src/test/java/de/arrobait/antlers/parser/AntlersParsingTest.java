package de.arrobait.antlers.parser;

import com.intellij.testFramework.ParsingTestCase;

public class AntlersParsingTest extends ParsingTestCase {
    public AntlersParsingTest() {
        super("", "antlers.html", new AntlersParserDefinition());
    }

    public void testParseComments() {
        doTest(true);
    }

    @Override
    protected String getTestDataPath() {
        return "src/test/testData";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }
}