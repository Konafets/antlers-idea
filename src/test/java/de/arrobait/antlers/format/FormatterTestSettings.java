package de.arrobait.antlers.format;

import com.intellij.ide.highlighter.HtmlFileType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.xml.HtmlCodeStyleSettings;

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

    public FormatterTestSettings(CodeStyleSettings codeStyleSettings) {
        mySettings = codeStyleSettings;
    }

    public void setUp() {
        // TODO: Implement the Config here. See FormatterSettings from HB
        myPrevFormatSetting = true;

        myPrevIndentSize = mySettings.getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE;
        mySettings.getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE = 4;

        myPrevKeepBlankLines = getHtmlCodeStyleSettings().HTML_KEEP_BLANK_LINES;
        getHtmlCodeStyleSettings().HTML_KEEP_BLANK_LINES = 0;

        myPrevDoNotIndentSetting = getHtmlCodeStyleSettings().HTML_DO_NOT_INDENT_CHILDREN_OF;
        getHtmlCodeStyleSettings().HTML_DO_NOT_INDENT_CHILDREN_OF = "";
    }

    public void tearDown() {
        mySettings.getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE = myPrevIndentSize;
        getHtmlCodeStyleSettings().HTML_DO_NOT_INDENT_CHILDREN_OF = myPrevDoNotIndentSetting;
        getHtmlCodeStyleSettings().HTML_KEEP_BLANK_LINES = myPrevKeepBlankLines;
    }

    private HtmlCodeStyleSettings getHtmlCodeStyleSettings() {
        return mySettings.getCustomSettings(HtmlCodeStyleSettings.class);
    }
}
