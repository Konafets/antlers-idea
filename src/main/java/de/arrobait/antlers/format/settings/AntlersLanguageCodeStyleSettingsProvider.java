package de.arrobait.antlers.format.settings;

import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.IndentOptionsEditor;
import com.intellij.application.options.SmartIndentOptionsEditor;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettingsCustomizable;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.LanguageCodeStyleSettingsProvider;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.file.AntlersFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.intellij.psi.codeStyle.CodeStyleSettingsCustomizableOptions.getInstance;

public class AntlersLanguageCodeStyleSettingsProvider extends LanguageCodeStyleSettingsProvider {
    @Override
    @NotNull
    public Language getLanguage() {
        return AntlersLanguage.INSTANCE;
    }

    @Override
    @Nullable
    public IndentOptionsEditor getIndentOptionsEditor() {
        return new SmartIndentOptionsEditor();
    }

    @Override
    protected void customizeDefaults(@NotNull CommonCodeStyleSettings commonSettings,
                                     @NotNull CommonCodeStyleSettings.IndentOptions indentOptions) {
        indentOptions.TAB_SIZE = 4;
        indentOptions.INDENT_SIZE = 4;
        indentOptions.CONTINUATION_INDENT_SIZE = 4;
        commonSettings.KEEP_BLANK_LINES_IN_CODE = 0;
    }

    @Override
    public void customizeSettings(@NotNull CodeStyleSettingsCustomizable consumer, @NotNull SettingsType settingsType) {
        if (settingsType == SettingsType.SPACING_SETTINGS) {
            consumer.showCustomOption(
                    AntlersCodeStyleSettings.class,
                    "SPACE_AFTER_AND_BEFORE_ANTLERS_DELIMITERS",
                    "Space after opening and before closing Antlers delimiters",
                    getInstance().SPACES_OTHER
            );
            consumer.showCustomOption(
                    AntlersCodeStyleSettings.class,
                    "SPACE_AROUND_MODIFIER_PIPE",
                    "Space around modifier separator",
                    getInstance().SPACES_AROUND_OPERATORS
            );
            consumer.showCustomOption(
                    AntlersCodeStyleSettings.class,
                    "SPACE_AROUND_OPERATORS",
                    "Space around operators",
                    getInstance().SPACES_AROUND_OPERATORS
            );
            consumer.showStandardOptions("SPACE_AROUND_ASSIGNMENT_OPERATORS", "SPACE_AFTER_COMMA");
        } else if (settingsType == SettingsType.BLANK_LINES_SETTINGS) {
            consumer.showStandardOptions("KEEP_BLANK_LINES_IN_CODE");
        }
    }

    @Override
    public @Nullable String getCodeSample(@NotNull SettingsType settingsType) {
        if (settingsType == SettingsType.SPACING_SETTINGS
                || settingsType == SettingsType.BLANK_LINES_SETTINGS
                || settingsType == SettingsType.INDENT_SETTINGS
        ) {
            return loadSample(settingsType);
        }

        return "";
    }

    private static String loadSample(@NotNull SettingsType settingsType) {
        String name = settingsType.name() + AntlersFileType.Companion.getDOT_DEFAULT_EXTENSION();

        return CodeStyleAbstractPanel.readFromFile(AntlersLanguageCodeStyleSettingsProvider.class, name);
    }
}
