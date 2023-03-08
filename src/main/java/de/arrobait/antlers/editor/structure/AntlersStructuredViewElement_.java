package de.arrobait.antlers.editor.structure;

import com.intellij.ide.projectView.PresentationData;
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.NavigatablePsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.psi.AntlersFile;
import de.arrobait.antlers.psi.AntlersTine;
import de.arrobait.antlers.psi.impl.AntlersTineImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

//public class AntlersStructuredViewElement implements StructureViewTreeElement, SortableTreeElement {
public class AntlersStructuredViewElement_ implements StructureViewTreeElement, SortableTreeElement {

    private final NavigatablePsiElement myElement;

    public AntlersStructuredViewElement_(NavigatablePsiElement myElement) {
        this.myElement = myElement;
    }

    @Override
    public Object getValue() {
        return myElement;
    }

    @Override
    public @NotNull String getAlphaSortKey() {
        String name = myElement.getName();

        return name != null ? name : "";
    }

    @Override
    public @NotNull ItemPresentation getPresentation() {
        ItemPresentation presentation = myElement.getPresentation();

        return presentation != null ? presentation : new PresentationData();
    }

    @Override
    public TreeElement @NotNull [] getChildren() {
        if (myElement instanceof AntlersFile) {
            List<AntlersTine> tines = PsiTreeUtil.getChildrenOfTypeAsList(myElement, AntlersTine.class);
            List<TreeElement> treeElements = new ArrayList<>(tines.size());
            for (AntlersTine tine : tines) {
                treeElements.add(new AntlersStructuredViewElement_((AntlersTineImpl) tine));
            }
            return treeElements.toArray(new TreeElement[0]);

        }

        return EMPTY_ARRAY;
    }

    @Override
    public void navigate(boolean requestFocus) {

    }

    @Override
    public boolean canNavigate() {
        return false;
    }

    @Override
    public boolean canNavigateToSource() {
        return false;
    }
}
