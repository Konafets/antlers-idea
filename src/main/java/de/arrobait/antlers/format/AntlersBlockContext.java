package de.arrobait.antlers.format;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import de.arrobait.antlers.AntlersLanguage;

public class AntlersBlockContext {
    private final CodeStyleSettings mySettings;
    private final CommonCodeStyleSettings antlersCodeStyleSettings;

    public AntlersBlockContext(CodeStyleSettings settings) {
        this.mySettings = settings;
        this.antlersCodeStyleSettings = settings.getCommonSettings(AntlersLanguage.INSTANCE);
    }

    public CodeStyleSettings getMySettings() {
        return mySettings;
    }

    public CommonCodeStyleSettings getAntlersCodeStyleSettings() {
        return antlersCodeStyleSettings;
    }
}
