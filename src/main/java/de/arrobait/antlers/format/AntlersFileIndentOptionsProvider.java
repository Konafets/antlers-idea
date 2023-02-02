package de.arrobait.antlers.format;

import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings.IndentOptions;
import com.intellij.psi.codeStyle.FileIndentOptionsProvider;
import de.arrobait.antlers.codeStyle.AntlersCodeStyleSettings;
import de.arrobait.antlers.psi.AntlersFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersFileIndentOptionsProvider extends FileIndentOptionsProvider {
    @Override
    public CommonCodeStyleSettings.@Nullable IndentOptions getIndentOptions(@NotNull CodeStyleSettings settings, @NotNull PsiFile file) {
        if (file instanceof AntlersFile) {
            AntlersCodeStyleSettings antlersSettings = settings.getCustomSettings(AntlersCodeStyleSettings.class);
            IndentOptions options = settings.getLanguageIndentOptions(file.getLanguage());
            if (options != null) {
                options = (IndentOptions) options.clone();
                options.setOverrideLanguageOptions(true);
                return options;
            }
        }

        return null;
    }
}
