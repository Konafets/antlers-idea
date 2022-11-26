package de.arrobait.antlers.format;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.FormattingDocumentModel;
import com.intellij.formatting.Wrap;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlock;
import com.intellij.formatting.templateLanguages.TemplateLanguageFormattingModelBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.FormattingDocumentModelImpl;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersFormattingModelBuilder extends TemplateLanguageFormattingModelBuilder {
    @Override
    public TemplateLanguageBlock createTemplateLanguageBlock(@NotNull ASTNode node,
                                                             @Nullable Wrap wrap,
                                                             @Nullable Alignment alignment,
                                                             @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                                                             @NotNull CodeStyleSettings codeStyleSettings) {
        final FormattingDocumentModel documentModel = FormattingDocumentModelImpl.createOn(node.getPsi().getContainingFile());
        HtmlPolicy policy = new HtmlPolicy(codeStyleSettings, documentModel);

        return new AntlersBlock(node, wrap, alignment, this, codeStyleSettings, foreignChildren, policy);
    }
}
