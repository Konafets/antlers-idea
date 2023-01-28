package de.arrobait.antlers.format;

import com.intellij.lang.javascript.JavaScriptFileType;

public class AntlersFormatterSampleFileTest extends AntlersFormatterTestCase {
    public void testSimpleHtmlFile() throws Exception {
        doFileBasedTest(getTestName(false));
    }

    public void testAntlersEmbeddedInHtmlFile() throws Exception {
        doFileBasedTest(getTestName(false));
    }

    /**
     * Test out formatting with a non-HTML template data language
     */
    public void testSampleFileWithCustomTemplateDataLang() throws Exception {
      doFileBasedTest("JSSampleFile", JavaScriptFileType.INSTANCE);
    }

    public void _testStillatExampleHtml() throws Exception {
        doFileBasedTest(getTestName(false));
    }
}
