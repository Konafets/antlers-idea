package de.arrobait.antlers.editor.structure;

import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.ide.structureView.impl.TemplateLanguageStructureViewBuilder;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.PairFunction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AntlersTemplateLanguageStructureViewBuilder extends TemplateLanguageStructureViewBuilder {
    protected AntlersTemplateLanguageStructureViewBuilder(PsiElement psiElement) {
        super(psiElement);
    }

    @NotNull
    public static TemplateLanguageStructureViewBuilder create(@NotNull PsiFile psiFile,
                                                              @Nullable PairFunction<? super PsiFile, ? super Editor, ? extends StructureViewModel> modelFactory) {
      return new TemplateLanguageStructureViewBuilder(psiFile) {
        @Override
        protected TreeBasedStructureViewBuilder createMainBuilder(@NotNull PsiFile psi) {
          return modelFactory == null ? null : new TreeBasedStructureViewBuilder() {
            @NotNull
            @Override
            public StructureViewModel createStructureViewModel(@Nullable Editor editor) {
              return modelFactory.fun(psi, editor);
            }
          };
        }
      };
    }
}
