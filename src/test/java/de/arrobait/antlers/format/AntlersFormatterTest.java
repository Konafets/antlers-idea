package de.arrobait.antlers.format;

import com.intellij.psi.formatter.FormatterTestCase;
import de.arrobait.antlers.file.AntlersFileType;
import de.arrobait.antlers.util.AntlersTestUtils;

public class AntlersFormatterTest extends FormatterTestCase {
    @Override
    protected String getBasePath() {
        return "formatting";
    }

    @Override
    protected String getFileExtension() {
        return AntlersFileType.DEFAULT_EXTENSION;
    }

    @Override
    protected String getTestDataPath() {
        return AntlersTestUtils.BASE_TEST_DATA_PATH;
    }

    @Override
    protected void doTest(String resultNumber) throws Exception {
        String testName = getTestName(false);
        doTest(testName + "." + getFileExtension(), testName + "_after." + getFileExtension(), resultNumber);
    }

    public void testSimpleAntlers() throws Exception {
        doTest();
    }

    public void testSpaceAroundOperators() throws Exception {
        doTest();
    }

    public void testModifiers() throws Exception {
        doTest();
    }

    public void testConditionals() throws Exception {
        doTest();
    }

    public void testSwitch() throws Exception {
        // TODO: The last braces is not indented correctly
        doTest();
    }
}
