package de.arrobait.antlers.file;

import de.arrobait.antlers.AntlersLanguage;
import com.intellij.ide.highlighter.HtmlFileType;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileTypeRegistry;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.LanguageSubstitutor;
import com.intellij.testFramework.LightVirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersLanguageSubstitutor extends LanguageSubstitutor {
    @Nullable
    @Override
    public Language getLanguage(@NotNull VirtualFile file, @NotNull Project project) {
        if (file instanceof LightVirtualFile) {
            return null;
        }

        return FileTypeRegistry.getInstance().isFileOfType(file, HtmlFileType.INSTANCE) ? AntlersLanguage.INSTANCE : null;
    }
}
