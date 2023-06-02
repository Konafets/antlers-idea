package de.arrobait.antlers.format.settings;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.psi.codeStyle.CodeStyleConfigurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import de.arrobait.antlers.AntlersLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersCodeStyleSettingsProvider extends CodeStyleSettingsProvider {
    @Override
    @NotNull
    public CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings, @NotNull CodeStyleSettings originalSettings) {
        return new CodeStyleAbstractConfigurable(settings, originalSettings, this.getConfigurableDisplayName()) {
            @Override
            protected CodeStyleAbstractPanel createPanel(CodeStyleSettings settings) {
                return new AntlersCodeStyleMainPanel(getCurrentSettings(), settings);
            }
        };
    }

    @Override
    @Nullable
    public String getConfigurableDisplayName() {
        return AntlersLanguage.INSTANCE.getDisplayName();
    }

    @Override
    @Nullable
    public CustomCodeStyleSettings createCustomSettings(CodeStyleSettings settings) {
        return new AntlersCodeStyleSettings(settings);
    }

    @Override
    public @Nullable Language getLanguage() {
        return AntlersLanguage.INSTANCE;
    }

    private static class AntlersCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {
        public AntlersCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
            super(AntlersLanguage.INSTANCE, currentSettings, settings);
        }

        @Override
        protected void initTabs(CodeStyleSettings settings) {
            addIndentOptionsTab(settings);
            addSpacesTab(settings);
            addBlankLinesTab(settings);
            addWrappingAndBracesTab(settings);
        }

        @Override
        protected EditorHighlighter createHighlighter(EditorColorsScheme scheme) {
            return super.createHighlighter(scheme);
        }
    }
}
