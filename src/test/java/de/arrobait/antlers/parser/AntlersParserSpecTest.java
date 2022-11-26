package de.arrobait.antlers.parser;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AntlersParserSpecTest extends AntlersParsingTestCase {
    public AntlersParserSpecTest() {
        super("parsing");
    }

    @Test
    public void testParseAssignments() {
        doTest(true);
    }

    @Test
    public void testParseBoolean() {
        doTest(true);
    }

    @Test
    public void testParseEmptyFile() {
        doTest(true);
    }

    @Test
    public void testParseComments() {
        doTest(true);
    }

    @Test
    public void testParseComparisonExpressions() {
        doTest(true);
    }

    @Test
    public void testParseControlStructures() {
        doTest(true);
    }

    @Test
    public void testParseFactorialExpressions() {
        doTest(true);
    }

    @Test
    public void testParseGroupBy() {
        doTest(true);
    }

    @Test
    public void testParseInterpolatedStatements() {
        doTest(true);
    }

    @Test
    public void testParseLogicalExpressions() {
        doTest(true);
    }

    @Test
    public void testParseMathExpressions() {
        doTest(true);
    }

    @Test
    public void testParseMerge() {
        doTest(true);
    }

    @Test
    public void testParseModifierNode() {
        doTest(true);
    }

    @Test
    public void testParseNoParse() {
        doTest(true);
    }

    @Test
    public void testParseNumbers() {
        doTest(true);
    }

    @Test
    public void testParseOrderBy() {
        doTest(true);
    }

    @Test
    public void testParsePhp() {
        doTest(true);
    }

    @Test
    public void testParsePluck() {
        doTest(true);
    }

    @Test
    public void testParsePropertyAccess() {
        doTest(true);
    }

    @Test
    public void testParseSkip() {
        doTest(true);
    }

    @Test
    public void testParseStrings() {
        doTest(true);
    }

    @Test
    public void testParseSubexpressions() {
        doTest(true);
    }

    @Test
    public void testParseSwitch() {
        doTest(true);
    }

    @Test
    public void testParseTake() {
        doTest(true);
    }

    @Test
    public void testParseVariables() {
        doTest(true);
    }

    @Test
    public void testParseWhere() {
        doTest(true);
    }
}
