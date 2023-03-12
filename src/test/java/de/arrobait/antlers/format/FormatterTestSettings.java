package de.arrobait.antlers.format;

import com.intellij.ide.highlighter.HtmlFileType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.formatter.xml.HtmlCodeStyleSettings;
import de.arrobait.antlers.AntlersLanguage;

/**
 * Provides a setup and tear down for tests to use to set up the app test fixture with
 * a standard of formatter settings.
 */
public class FormatterTestSettings {
    private final CodeStyleSettings mySettings;
    private boolean myPrevFormatSetting;
    private int myPrevIndentSize;
    private String myPrevDoNotIndentSetting;
    private int myPrevKeepBlankLines;
    private boolean myPrevKeepLineBreaks;

    public FormatterTestSettings(CodeStyleSettings codeStyleSettings) {
        mySettings = codeStyleSettings;
    }

    public void setUp() {
        // TODO: Implement the Config here. See FormatterSettings from HB
        myPrevFormatSetting = true;

        myPrevIndentSize = mySettings.getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE;
        mySettings.getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE = 4;

        myPrevKeepLineBreaks = getAntlersStyleSettings().KEEP_LINE_BREAKS;
        getAntlersStyleSettings().KEEP_BLANK_LINES_IN_CODE = 1;

        myPrevKeepBlankLines = getAntlersStyleSettings().KEEP_BLANK_LINES_IN_CODE;
        getAntlersStyleSettings().KEEP_BLANK_LINES_IN_CODE = 1;

        myPrevDoNotIndentSetting = getHtmlCodeStyleSettings().HTML_DO_NOT_INDENT_CHILDREN_OF;
        getHtmlCodeStyleSettings().HTML_DO_NOT_INDENT_CHILDREN_OF = "";
    }

    public void tearDown() {
        mySettings.getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE = myPrevIndentSize;
        getAntlersStyleSettings().KEEP_BLANK_LINES_IN_CODE = myPrevKeepBlankLines;
        getAntlersStyleSettings().KEEP_LINE_BREAKS = myPrevKeepLineBreaks;
        getHtmlCodeStyleSettings().HTML_DO_NOT_INDENT_CHILDREN_OF = myPrevDoNotIndentSetting;
    }

    private HtmlCodeStyleSettings getHtmlCodeStyleSettings() {
        return mySettings.getCustomSettings(HtmlCodeStyleSettings.class);
    }

    private CommonCodeStyleSettings getAntlersStyleSettings() {
        return mySettings.getCommonSettings(AntlersLanguage.INSTANCE);
    }
}
