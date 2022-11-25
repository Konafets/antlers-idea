package de.arrobait.antlers.format;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Wrap;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlock;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.psi.AntlersTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersBlock extends TemplateLanguageBlock {

    public AntlersBlock(@NotNull ASTNode node,
                        @Nullable Wrap wrap,
                        @Nullable Alignment alignment,
                        @NotNull TemplateLanguageBlockFactory blockFactory,
                        @NotNull CodeStyleSettings settings,
                        @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                        HtmlPolicy policy) {
        super(node, wrap, alignment, blockFactory, settings, foreignChildren);
    }

    @Override
    protected IElementType getTemplateTextElementType() {
        return AntlersTypes.OUTER_CONTENT;
    }
}
