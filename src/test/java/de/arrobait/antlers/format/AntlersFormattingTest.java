package de.arrobait.antlers.format;

import com.intellij.application.options.CodeStyle;
import com.intellij.psi.formatter.FormatterTestCase;
import de.arrobait.antlers.file.AntlersFileType;
import de.arrobait.antlers.util.AntlersTestUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AntlersFormattingTest extends FormatterTestCase implements AntlersFormattingModelBuilderTest {
    protected FormatterTestSettings formatterTestSettings;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        formatterTestSettings = new FormatterTestSettings(CodeStyle.getSettings(getProject()));
        formatterTestSettings.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        try {
            formatterTestSettings.tearDown();
        } catch (Throwable e) {
            addSuppressedException(e);
        } finally {
            super.tearDown();
        }
    }

    @Override
    protected String getBasePath() {
        return "formatter";
    }

    @Override
    protected String getFileExtension() {
        return AntlersFileType.DOT_DEFAULT_EXTENSION;
    }

    @Override
    protected String getTestDataPath() {
        return AntlersTestUtils.BASE_TEST_DATA_PATH;
    }

    @Override
    protected void doTest(String resultNumber) throws Exception {
        String testName = getTestName(false);
        doTest(testName + getFileExtension(), testName + "_expected" + getFileExtension(), resultNumber);
    }

    @Test
    public void testSimpleAntlers() throws Exception {
        doTest();
    }

    @Test
    public void testSpaceAroundOperators() throws Exception {
        doTest();
    }

    @Test
    public void testModifiers() throws Exception {
        doTest();
    }

    @Test
    @Ignore
    public void testConditionals() throws Exception {
        doTest();
    }

    @Test
    public void testHTML() throws Exception {
        doTest();
    }

    @Test
    public void testAntlersEmbeddedInHtmlFile() throws Exception {
        doTest();
    }

    @Test
    public void testStillatExampleHtml() throws Exception {
        doTest();
    }

    @Test
    public void testIssue74() throws Exception {
        doTest();
    }

    @Test
    public void testIssue116() throws Exception {
        doTest();
    }

    @Test
    @Ignore
    public void testSwitch() throws Exception {
        // TODO: The last braces is not indented correctly
        doTest();
    }
}
