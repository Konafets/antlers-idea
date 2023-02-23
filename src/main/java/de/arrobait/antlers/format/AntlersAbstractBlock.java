package de.arrobait.antlers.format;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Wrap;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlock;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.psi.AntlersTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public abstract class AntlersAbstractBlock extends TemplateLanguageBlock {

    @NotNull
    protected final HtmlPolicy myHtmlPolicy;

    protected final AntlersBlockContext myContext;

    public AntlersAbstractBlock(@NotNull ASTNode node,
                                @Nullable Wrap wrap,
                                @Nullable Alignment alignment,
                                @NotNull TemplateLanguageBlockFactory blockFactory,
                                @NotNull CodeStyleSettings customSettings,
                                @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                                @Nullable AntlersBlockContext context,
                                @NotNull HtmlPolicy policy) {
        super(node, wrap, alignment, blockFactory, customSettings, foreignChildren);

        myContext = context;
        myHtmlPolicy = policy;
    }

    @Override
    public boolean isIncomplete() {
        boolean isIncomplete = super.isIncomplete();
        return isIncomplete;
    }

    @Override
    protected IElementType getTemplateTextElementType() {
        // We ignore OUTER_CONTENT tokens since they get formatted by the templated language.
        return AntlersTypes.OUTER_CONTENT;
    }

    @Override
    public boolean isRequiredRange(TextRange range) {
        return false;
    }
}
