package de.arrobait.antlers.parser;

import com.intellij.testFramework.ParsingTestCase;

public class AntlersTagParsingTest extends ParsingTestCase {
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

    public AntlersTagParsingTest() {
        super("parsing/tags", "antlers.html", new AntlersParserDefinition());
    }

    public void testParseTagCollectionConditions() {
        doTest(true);
    }

    public void testParseTagTaxonomyConditions() {
        doTest(true);
    }

    public void testParseTagUsersConditions() {
        doTest(true);
    }

    public void testParseTag404() {
        doTest(true);
    }

    public void testParseTagAsset() {
        doTest(true);
    }

    public void testParseTagAssets() {
        doTest(true);
    }

    public void testParseTagCache() {
        doTest(true);
    }

    public void testParseTagCollection() {
        doTest(true);
    }

    public void testParseTagDump() {
        doTest(true);
    }

    public void testParseTagForeach() {
        doTest(true);
    }

    public void testParseTagForm() {
        doTest(true);
    }

    public void testParseTagGetContent() {
        doTest(true);
    }

    public void testParseTagGetError() {
        doTest(true);
    }

    public void testParseTagGetErrors() {
        doTest(true);
    }

    public void testParseTagGetFiles() {
        doTest(true);
    }

    public void testParseTagGlide() {
        doTest(true);
    }

    public void testParseTagIncrement() {
        doTest(true);
    }

    public void testParseTagInstalled() {
        doTest(true);
    }

    public void testParseTagLink() {
        doTest(true);
    }

    public void testParseTagLocales() {
        doTest(true);
    }

    public void testParseTagLoop() {
        doTest(true);
    }

    public void testParseTagMarkdown() {
        doTest(true);
    }

    public void testParseTagMix() {
        doTest(true);
    }

    public void testParseTagMountUrl() {
        doTest(true);
    }

    public void testParseTagNav() {
        doTest(true);
    }

    public void testParseTagOauth() {
        doTest(true);
    }

    public void testParseTagObfuscate() {
        doTest(true);
    }

    public void testParseTagParent() {
        doTest(true);
    }

    public void testParseTagPartial() {
        doTest(true);
    }

    public void testParseTagProtect() {
        doTest(true);
    }

    public void testParseTagRedirect() {
        doTest(true);
    }

    public void testParseTagRoute() {
        doTest(true);
    }

    public void testParseTagSearch() {
        doTest(true);
    }

    public void testParseTagSection() {
        doTest(true);
    }

    public void testParseTagSession() {
        doTest(true);
    }

    public void testParseTagSvg() {
        doTest(true);
    }

    public void testParseTagSwitch() {
        doTest(true);
    }

    public void testParseTagTaxonomy() {
        doTest(true);
    }

    public void testParseTagTrans() {
        doTest(true);
    }

    public void testParseTagUser() {
        doTest(true);
    }

    public void testParseTagUsers() {
        doTest(true);
    }

    public void testParseTagYield() {
        doTest(true);
    }
}
