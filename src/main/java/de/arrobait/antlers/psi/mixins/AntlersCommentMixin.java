package de.arrobait.antlers.psi.mixins;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiComment;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

abstract public class AntlersCommentMixin extends ASTWrapperPsiElement implements PsiComment {
    public AntlersCommentMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    @NotNull
    public IElementType getTokenType() {
        return getNode().getElementType();
    }
}
