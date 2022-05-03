package de.arrobait.antlers.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNameIdentifierOwner;
import org.jetbrains.annotations.NotNull;

public interface AntlersNamedElement extends PsiNameIdentifierOwner {
    @NotNull
    String getName();

    @NotNull
    PsiElement getId();
}
