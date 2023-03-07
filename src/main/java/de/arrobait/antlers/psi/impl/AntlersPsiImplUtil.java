package de.arrobait.antlers.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.PlatformIcons;
import de.arrobait.antlers.psi.AntlersTine;
import de.arrobait.antlers.psi.AntlersTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class AntlersPsiImplUtil {
    public static String getName(PsiElement element) {
        return "FooBar";
    }

    public static PsiElement getNameIdentifier(PsiElement element) {
        ASTNode keyNode = element.getNode().findChildByType(AntlersTypes.TINE);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersTine tine) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return tine.getText();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = tine.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            @Nullable
            public Icon getIcon(boolean unused) {
                return PlatformIcons.VARIABLE_ICON;
            }
        };
    }
}
