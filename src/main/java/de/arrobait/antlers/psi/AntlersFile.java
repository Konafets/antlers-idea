package de.arrobait.antlers.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.file.AntlersFileType;
import org.jetbrains.annotations.NotNull;

public class AntlersFile extends PsiFileBase {
    public AntlersFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, AntlersLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return AntlersFileType.INSTANCE;
    }

    @Override
    public @NotNull String toString() {
        return "Antlers File";
    }
}
