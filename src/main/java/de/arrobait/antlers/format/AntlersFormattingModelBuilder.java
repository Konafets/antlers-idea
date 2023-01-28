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
import de.arrobait.antlers.psi.AntlersTokenSets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersFormattingModelBuilder extends TemplateLanguageFormattingModelBuilder {

    /**
     * We have to override {@link TemplateLanguageFormattingModelBuilder#createModel} since after
     * we delegate to some templated languages. Those languages (xml/html for sure, potentially others)
     * delegate right back to us to format the AntlersTypes.OUTER_ELEMENT_TYPE token we tell them to ignore,
     * causing a stack-overflowing loop of polite format-delegation.
     */
    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext context) {
        final PsiFile file = context.getContainingFile();
        CodeStyleSettings settings = context.getCodeStyleSettings();
        final Block rootBlock;

        final ASTNode node = file instanceof AntlersFile ? file.getNode() : context.getNode();

        if (node.getElementType() == AntlersCustomElementTypes.OUTER_ELEMENT_TYPE) {
            // If we're looking at a AntlersCustomElementTypes.OUTER_ELEMENT_TYPE element, then we've been invoked by our templated
            // language. Make a dummy block to allow that formatter to continue.
            return new SimpleTemplateLanguageFormattingModelBuilder().createModel(context);
        } else {
            rootBlock = getRootBlock(file, file.getViewProvider(), settings);
        }

        return new DocumentBasedFormattingModel(rootBlock, settings, file);
    }

    @Override
    public TemplateLanguageBlock createTemplateLanguageBlock(@NotNull ASTNode node,
                                                             @Nullable Wrap wrap,
                                                             @Nullable Alignment alignment,
                                                             @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                                                             @NotNull CodeStyleSettings settings) {
        final FormattingDocumentModel documentModel = FormattingDocumentModelImpl.createOn(node.getPsi().getContainingFile());
        HtmlPolicy policy = new HtmlPolicy(settings, documentModel);
        return AntlersTokenSets.NODES.contains(node.getElementType()) ?
                new AntlersNodeBlock(node, wrap, alignment, this, settings, foreignChildren, policy) :
                new AntlersBlock(node, wrap, alignment, this, settings, foreignChildren, policy);
    }

    /**
     * This is double negation. So, two "no" means "yes".
     */
    @Override
    public boolean dontFormatMyModel() {
        return false;
    }
}
