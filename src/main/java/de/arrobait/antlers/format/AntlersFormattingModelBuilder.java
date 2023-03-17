package de.arrobait.antlers.format;

import com.intellij.formatting.*;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlock;
import com.intellij.formatting.templateLanguages.TemplateLanguageFormattingModelBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.project.Project;
import com.intellij.prettierjs.PrettierConfiguration;
import com.intellij.psi.PsiFile;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.DocumentBasedFormattingModel;
import com.intellij.psi.formatter.FormattingDocumentModelImpl;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.templateLanguages.SimpleTemplateLanguageFormattingModelBuilder;
import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.psi.AntlersCustomElementTypes;
import de.arrobait.antlers.psi.AntlersFile;
import de.arrobait.antlers.psi.AntlersTokenSets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static de.arrobait.antlers.psi.AntlersTypes.COMMENT_BLOCK;

public class AntlersFormattingModelBuilder extends TemplateLanguageFormattingModelBuilder {
    PsiFile myFile;

    /**
     * We have to override {@link TemplateLanguageFormattingModelBuilder#createModel} since after
     * we delegate to some templated languages. Those languages (xml/html for sure, potentially others)
     * delegate right back to us to format the AntlersTypes.OUTER_ELEMENT_TYPE token we tell them to ignore,
     * causing a stack-overflowing loop of polite format-delegation.
     */
    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext context) {
        final PsiFile file = context.getContainingFile();
        myFile = file;
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
        TemplateLanguageBlock block;
        IElementType elementType = node.getElementType();
        AntlersBlockContext context = new AntlersBlockContext(settings);

        if (AntlersTokenSets.NODES.contains(elementType)) {
            block = new AntlersNodeBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy);
        } else if (AntlersTokenSets.CONDITIONAL_BLOCKS.contains(elementType)) {
            block = new AntlersConditionalBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy);
        } else if (elementType == COMMENT_BLOCK) {
            block = new AntlersCommentBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy);
        } else {
            block = new AntlersBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy);
        }

        return block;
    }

    /**
     * This is double negation. So, two "no" means "yes".
     */
    @Override
    public boolean dontFormatMyModel() {
        if (myFile != null) {
            Project project = myFile.getProject();
            PrettierConfiguration prettierConfiguration = PrettierConfiguration.getInstance(project);
            return prettierConfiguration.isRunOnReformat();
        }

        return false;
    }
}
