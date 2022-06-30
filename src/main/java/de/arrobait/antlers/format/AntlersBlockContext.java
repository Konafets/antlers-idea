package de.arrobait.antlers.format;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import de.arrobait.antlers.AntlersLanguage;

public class AntlersBlockContext {
    private final CodeStyleSettings mySettings;
    private final CommonCodeStyleSettings myAntlersSettings;

    public AntlersBlockContext(CodeStyleSettings settings) {
        mySettings = settings;
        this.myAntlersSettings = settings.getCommonSettings(AntlersLanguage.INSTANCE);
    }

    public CodeStyleSettings getSettings() {
        return mySettings;
    }

    public CommonCodeStyleSettings getAntlersSettings() {
        return myAntlersSettings;
    }
}
