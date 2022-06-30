package de.arrobait.antlers.format;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.ChildAttributes;
import com.intellij.formatting.Wrap;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import de.arrobait.antlers.psi.AntlersTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.List;

public class AntlersTagBlock extends AntlersBlock {
    @NotNull
    private final Alignment myChildAttributAlignment;

    public AntlersTagBlock(@NotNull ASTNode node,
                           Wrap wrap,
                           Alignment alignment,
                           @NotNull TemplateLanguageBlockFactory blockFactory,
                           @NotNull CodeStyleSettings settings,
                           @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                           @NotNull HtmlPolicy htmlPolicy,
                           @NotNull AntlersBlockContext context
    ) {
        super(node, wrap, alignment, blockFactory, settings, foreignChildren, htmlPolicy, context);
        this.myChildAttributAlignment = Alignment.createAlignment();
    }

    @NotNull
    @Override
    public ChildAttributes getChildAttributes(int newChildIndex) {
        if (newChildIndex > 0) {
            List<Block> blocks = getSubBlocks();
            if (blocks.size() > newChildIndex - 1) {
                Block prevBlock = blocks.get(newChildIndex - 1);
                if (prevBlock instanceof AbstractBlock) {
                    ASTNode node = ((AbstractBlock) prevBlock).getNode();
                    if (node.getElementType() == AntlersTypes.LITERAL_EXPR) {
                        return new ChildAttributes(null, prevBlock.getAlignment());
                    }
                }
            }
        }

        return super.getChildAttributes(newChildIndex);
    }

    @Override
    protected Alignment createChildAlignment(ASTNode child) {
        return super.createChildAlignment(child);
    }

    @Override
    protected Wrap createChildWrap(ASTNode child) {
        return null;
    }
}
