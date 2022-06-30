package de.arrobait.antlers.format;

import com.intellij.formatting.*;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlock;
import com.intellij.formatting.templateLanguages.TemplateLanguageFormattingModelBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.DocumentBasedFormattingModel;
import com.intellij.psi.formatter.FormattingDocumentModelImpl;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.templateLanguages.SimpleTemplateLanguageFormattingModelBuilder;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.OuterLanguageElementType;
import de.arrobait.antlers.psi.AntlersCustomElementTypes;
import de.arrobait.antlers.psi.AntlersFile;
import de.arrobait.antlers.psi.AntlersTokenSets;
import de.arrobait.antlers.psi.AntlersTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Template aware formatter which provides formatting for Antlers syntax and delegates
 * formatting for the templated language to that languages formatter
 */
public class AntlersFormattingModelBuilder extends TemplateLanguageFormattingModelBuilder {
    /**
     * We have to override {@link TemplateLanguageFormattingModelBuilder#createModel}
     * since after we delegate to some templated languages, those languages (xml/html for sure, potentially others)
     * delegate right back to us to format the AntlersTokenTypes.OUTER_ELEMENT_TYPE token we tell them to ignore,
     * causing a stack-overflowing loop of polite format-delegation.
     */
    @Override
    @NotNull
    public FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final PsiFile psiFile = formattingContext.getContainingFile();
        CodeStyleSettings settings = formattingContext.getCodeStyleSettings();
        final Block rootBlock;

        final ASTNode rootNode = psiFile instanceof AntlersFile ? psiFile.getNode() : formattingContext.getNode();

        if (rootNode.getElementType() == AntlersCustomElementTypes.OUTER_ELEMENT_TYPE) {
            // If we are looking at a AntlersTypes.OUTER_ELEMENT_TYPE, we have been invoked by our templated
            // language. Make a dummy block to allow that formatter to continue.
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
        final FormattingDocumentModelImpl documentModel = FormattingDocumentModelImpl.createOn(node.getPsi().getContainingFile());
        HtmlPolicy htmlPolicy = new HtmlPolicy(codeStyleSettings, documentModel);

        AntlersBlockContext context = new AntlersBlockContext(codeStyleSettings);
        return AntlersTokenSets.FOO.contains(node.getElementType()) ?
                new AntlersTagBlock(node, wrap, alignment, this, codeStyleSettings, foreignChildren, htmlPolicy, context) :
                new AntlersBlock(node, wrap, alignment, this, codeStyleSettings, foreignChildren, htmlPolicy, context);
    }

    /**
     * This is double negation. So, two "no" means "yes".
     */
    @Override
    public boolean dontFormatMyModel() {
        return false;
    }
}
