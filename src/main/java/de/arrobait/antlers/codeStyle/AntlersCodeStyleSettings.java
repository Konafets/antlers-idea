package de.arrobait.antlers.codeStyle;

import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;

public class AntlersCodeStyleSettings extends CustomCodeStyleSettings {
    protected AntlersCodeStyleSettings(CodeStyleSettings container) {
        super("AntlersCodeStyleSettings", container);
    }

    public boolean SPACE_AFTER_AND_BEFORE_ANTLERS_DELIMITERS = true;
    public boolean SPACE_AROUND_MODIFIER_PIPE = true;
    public boolean SPACE_AROUND_OPERATORS = true;
}
