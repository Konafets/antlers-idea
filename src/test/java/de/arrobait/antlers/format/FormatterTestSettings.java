package de.arrobait.antlers.format;

import com.intellij.ide.highlighter.HtmlFileType;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.xml.HtmlCodeStyleSettings;

public class FormatterTestSettings {
    private final CodeStyleSettings mySettings;

    private boolean myPrevFormatSettings;

    private int myPrevIntendSize;

    private String myPrevDoNotIndentSetting;

    public FormatterTestSettings(CodeStyleSettings codeStyleSettings) {
        mySettings = codeStyleSettings;
    }

    public void setUp() {
//        myPrevFormatSettings = AntlersConfig.isFormattingEnabled();
//        AntlersConfig.enableFormatting();

        myPrevIntendSize = mySettings.getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE;
        mySettings.getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE = 4;

        myPrevDoNotIndentSetting = mySettings.getCustomSettings(HtmlCodeStyleSettings.class).HTML_DO_NOT_INDENT_CHILDREN_OF;
        mySettings.getCustomSettings(HtmlCodeStyleSettings.class).HTML_DO_NOT_INDENT_CHILDREN_OF = "";
    }

    public void tearDown() {
//        AntlersConfig.setFormattingEnabled(myPrevFormatSettings);
        mySettings.getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE = myPrevIntendSize;
        mySettings.getCustomSettings(HtmlCodeStyleSettings.class).HTML_DO_NOT_INDENT_CHILDREN_OF = myPrevDoNotIndentSetting;
    }
}
