package de.arrobait.antlers.editor.structure;

import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.PsiElement;
import com.intellij.util.ReflectionUtil;
import de.arrobait.antlers.file.AntlersIcons;
import de.arrobait.antlers.psi.AntlersBlockWrapper;
import de.arrobait.antlers.psi.AntlersPsiElement;
import de.arrobait.antlers.psi.AntlersTines;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.*;

public class AntlersTreeElement extends PsiTreeElementBase<NavigatablePsiElement> {
    private final NavigatablePsiElement myElement;

    protected AntlersTreeElement(NavigatablePsiElement psiElement) {
        super(psiElement);
        myElement = psiElement;
    }

    public static List<StructureViewTreeElement> getStructuredViewTreeElements(NavigatablePsiElement psiElement) {
        if (psiElement == null) {
            return Collections.emptyList();
        }

        List<StructureViewTreeElement> children = new ArrayList<>();

        for (PsiElement childElement : psiElement.getChildren()) {
            if (!(childElement instanceof AntlersPsiElement)) {
                continue;
            }

            if (childElement instanceof AntlersTines) {
                children.addAll(new AntlersTreeElement((AntlersPsiElement) childElement).getChildrenBase());
            }

            if (childElement instanceof AntlersBlockWrapper) {
                children.addAll(new AntlersTreeElement((AntlersPsiElement) childElement).getChildrenBase());
            }

            for (Class suitableClass : AntlersStructureViewModel.Companion.getOurSuitableClasses()) {
                if (childElement instanceof AntlersBlockWrapper) {
                    continue;
                }
                if (ReflectionUtil.isAssignable(suitableClass, childElement.getClass())) {
                    children.add(new AntlersTreeElement((AntlersPsiElement) childElement));
                    break;
                }
            }
        }
        return children;
    }

    @Override
    public @NotNull Collection<StructureViewTreeElement> getChildrenBase() {
        return getStructuredViewTreeElements(myElement);
    }

    @Override
    public @Nullable String getPresentableText() {
        return Objects.requireNonNull(myElement.getPresentation()).getPresentableText();
    }

    @Override
    public @NotNull ItemPresentation getPresentation() {
        final ItemPresentation presentation = myElement.getPresentation();
        assert presentation != null;
        return presentation;
    }

    @Override
    public Icon getIcon(boolean open) {
        return AntlersIcons.DOUBLE_BRACES;
    }

    @Override
    public boolean canNavigate() {
        return myElement.canNavigate();
    }

    @Override
    public void navigate(boolean requestFocus) {
        myElement.navigate(requestFocus);
    }

    @Override
    public boolean canNavigateToSource() {
        return myElement.canNavigateToSource();
    }
}
