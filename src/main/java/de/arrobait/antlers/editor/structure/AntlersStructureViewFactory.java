package de.arrobait.antlers.editor.structure;

import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.impl.TemplateLanguageStructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.psi.PsiFile;
import de.arrobait.antlers.psi.AntlersFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersStructureViewFactory implements PsiStructureViewFactory {
    @Nullable
    @Override
    public StructureViewBuilder getStructureViewBuilder(@NotNull PsiFile psiFile) {
        if (!(psiFile instanceof AntlersFile)) {
            return null;
        }

        return AntlersTemplateLanguageStructureViewBuilder.create(psiFile, AntlersStructureViewModel::new);
    }
}
