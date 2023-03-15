package de.arrobait.antlers.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.tree.TokenSet;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.file.AntlersFileType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AntlersFile extends PsiFileBase implements AntlersFileInterface {
    public AntlersFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, AntlersLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return AntlersFileType.Companion.getINSTANCE();
    }

    @Override
    public @NotNull String toString() {
        return "Antlers File:" + getName();
    }

    @Override
    @NotNull
    public List<AntlersPsiElement> getTines() {
        final ArrayList<AntlersPsiElement> result = new ArrayList<>();
        for (ASTNode node : getNode().getChildren(TokenSet.create(AntlersTypes.TINES))) {
            result.add((AntlersTines) node.getPsi());
        }

        return result;
    }
}
