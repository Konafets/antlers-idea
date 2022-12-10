package de.arrobait.antlers.format;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.Spacing;
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

    private final AntlersSpacingProcessor mySpacingProcessor;

    private final AntlersBlockContext myContext;

    public AntlersBlock(@NotNull ASTNode node,
                        @Nullable Wrap wrap,
                        @Nullable Alignment alignment,
                        @NotNull TemplateLanguageBlockFactory blockFactory,
                        @NotNull CodeStyleSettings settings,
                        @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                        @NotNull HtmlPolicy policy,
                        @NotNull AntlersBlockContext context) {
        super(node, wrap, alignment, blockFactory, settings, foreignChildren);

        myContext = context;
        mySpacingProcessor = new AntlersSpacingProcessor(node, context.getAntlersCodeStyleSettings());
    }

    @Override
    protected IElementType getTemplateTextElementType() {
        return AntlersTypes.OUTER_CONTENT;
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return mySpacingProcessor.getSpacing(child1, child2);
    }

}
