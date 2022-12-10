package de.arrobait.antlers.format;

import com.intellij.formatting.*;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlock;
import com.intellij.formatting.templateLanguages.TemplateLanguageFormattingModelBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.DocumentBasedFormattingModel;
import com.intellij.psi.formatter.FormattingDocumentModelImpl;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.templateLanguages.SimpleTemplateLanguageFormattingModelBuilder;
import de.arrobait.antlers.psi.AntlersCustomElementTypes;
import de.arrobait.antlers.psi.AntlersFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersFormattingModelBuilder extends TemplateLanguageFormattingModelBuilder {

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final PsiFile psiFile = formattingContext.getContainingFile();
        CodeStyleSettings settings = formattingContext.getCodeStyleSettings();
        final Block rootBlock;

        final ASTNode rootNode = psiFile instanceof AntlersFile ? psiFile.getNode() : formattingContext.getNode();

        if (rootNode.getElementType() == AntlersCustomElementTypes.OUTER_ELEMENT_TYPE) {
            return new SimpleTemplateLanguageFormattingModelBuilder().createModel(formattingContext);
        } else {
            rootBlock = getRootBlock(psiFile, psiFile.getViewProvider(), formattingContext.getCodeStyleSettings());
        }

        return new DocumentBasedFormattingModel(rootBlock, formattingContext.getProject(), settings, psiFile.getFileType(), psiFile);
    }

    @Override
    public TemplateLanguageBlock createTemplateLanguageBlock(@NotNull ASTNode node,
                                                             @Nullable Wrap wrap,
                                                             @Nullable Alignment alignment,
                                                             @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                                                             @NotNull CodeStyleSettings codeStyleSettings) {
        final FormattingDocumentModel documentModel = FormattingDocumentModelImpl.createOn(node.getPsi().getContainingFile());
        HtmlPolicy policy = new HtmlPolicy(codeStyleSettings, documentModel);
        AntlersBlockContext context = new AntlersBlockContext(codeStyleSettings);

        return new AntlersBlock(node, wrap, alignment, this, codeStyleSettings, foreignChildren, policy, context);
    }

    /**
     * This is double negation. So, two "no" means "yes".
     */
    @Override
    public boolean dontFormatMyModel() {
        return false;
    }
}
