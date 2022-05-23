package de.arrobait.antlers.file;

import com.intellij.lang.Language;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.FileViewProviderFactory;
import com.intellij.psi.PsiManager;
import org.jetbrains.annotations.NotNull;

public class AntlersFileViewProviderFactory implements FileViewProviderFactory {
    public AntlersFileViewProviderFactory() {}

    @NotNull
    @Override
    public FileViewProvider createFileViewProvider(@NotNull VirtualFile file, Language language, @NotNull PsiManager manager, boolean eventSystemEnabled) {
        return new AntlersFileViewProvider(manager, file, eventSystemEnabled);
    }
}
