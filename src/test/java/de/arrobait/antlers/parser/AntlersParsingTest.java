package de.arrobait.antlers.parser;

import com.intellij.testFramework.ParsingTestCase;

public class AntlersParsingTest extends ParsingTestCase {
    public AntlersParsingTest() {
        super("parsing", "antlers.html", new AntlersParserDefinition());
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

    public void testParseComments() {
        doTest(true);
    }

    public void testParsePhp() {
        doTest(true);
    }

    public void testParseBoolean() {
        doTest(true);
    }

    public void testParseStrings() {
        doTest(true);
    }

    public void testParseNumbers() {
        doTest(true);
    }

    public void testParseSubexpressions() {
        doTest(true);
    }

    public void testParseVariables() {
        doTest(true);
    }

    public void testParseInterpolatedStatements() {
        doTest(true);
    }

    public void testParseAssignments() {
        doTest(true);
    }

    public void testParseFactorialExpressions() {
        doTest(true);
    }

    public void testParseMathExpressions() {
        doTest(true);
    }

    public void testParseComparisonExpressions() {
        doTest(true);
    }

    public void testParseLogicalExpressions() {
        doTest(true);
    }

    public void testParseControlStructures() {
        doTest(true);
    }

    public void testParseSwitch() {
        doTest(true);
    }

    public void testParseModifierNode() {
        doTest(true);
    }

    public void testParseNoParse() {
        doTest(true);
    }

    public void testParseGroupBy() {
        doTest(true);
    }

    public void testParseMerge() {
        doTest(true);
    }

    public void testParseOrderBy() {
        doTest(true);
    }

    public void testParsePluck() {
        doTest(true);
    }

    public void testParseSkip() {
        doTest(true);
    }

    public void testParseTake() {
        doTest(true);
    }

    public void testParseWhere() {
        doTest(true);
    }
}
