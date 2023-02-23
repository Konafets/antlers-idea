package de.arrobait.antlers.format.settings;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import de.arrobait.antlers.AntlersLanguage;

public class AntlersCodeStyleSettings extends CustomCodeStyleSettings {
    public boolean SPACE_AFTER_AND_BEFORE_ANTLERS_DELIMITERS = true;
    public boolean SPACE_AROUND_MODIFIER_PIPE = true;
    public boolean SPACE_AROUND_OPERATORS = true;

    protected AntlersCodeStyleSettings(CodeStyleSettings container) {
        super(AntlersLanguage.INSTANCE.getID(), container);
    }
}
