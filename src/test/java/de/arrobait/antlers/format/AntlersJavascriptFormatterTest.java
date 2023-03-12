package de.arrobait.antlers.format;

import com.intellij.lang.javascript.JavaScriptFileType;
import org.junit.Test;

public class AntlersJavascriptFormatterTest extends AntlersFormatterTestCase {
    /**
     * Test out formatting with a non-HTML template data language
     */
    @Test
    public void testSampleFileWithCustomTemplateDataLang() throws Exception {
      doFileBasedTest("JSSampleFile", JavaScriptFileType.INSTANCE);
    }
}
