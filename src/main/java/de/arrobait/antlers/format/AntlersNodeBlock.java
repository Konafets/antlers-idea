package de.arrobait.antlers.format;

import com.intellij.formatting.*;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.psi.AntlersTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersNodeBlock extends AntlersBlock {

    @NotNull
    private final Alignment myChildAttributeAlignment;

    public AntlersNodeBlock(@NotNull ASTNode node,
                            @Nullable Wrap wrap,
                            @Nullable Alignment alignment,
                            @NotNull TemplateLanguageBlockFactory blockFactory,
                            @NotNull CodeStyleSettings settings,
                            @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                            @NotNull AntlersBlockContext context,
                            @NotNull HtmlPolicy policy,
                            @NotNull SpacingBuilder spacingBuilder) {
        super(node, wrap, alignment, blockFactory, settings, foreignChildren, context, policy, spacingBuilder);

        myChildAttributeAlignment = Alignment.createAlignment();
    }

    @Override
    public @NotNull ChildAttributes getChildAttributes(int newChildIndex) {
        if (newChildIndex > 0) {
            List<Block> blocks = getSubBlocks();
            if (blocks.size() > newChildIndex - 1) {
                Block prevBlock = blocks.get(newChildIndex - 1);
                if (prevBlock instanceof AbstractBlock) {
                    ASTNode node = ((AbstractBlock) prevBlock).getNode();
                    if (isAttribute(node)) {
                        return new ChildAttributes(null, prevBlock.getAlignment());
                    }
                }
            }
        }

        return super.getChildAttributes(newChildIndex);
    }

    @Override
    protected Alignment createChildAlignment(ASTNode child) {
        if (isAttribute(child)) {
            return myChildAttributeAlignment;
        }

        return super.createChildAlignment(child);
    }

//    @Override
//    protected Wrap createChildWrap(ASTNode child) {
//        final Wrap wrap = myWrappingProcessor.createChildWrap(child, myWrap);
//
//        return wrap;
//    }

    private static boolean isAttribute(ASTNode child) {
        IElementType type = child.getElementType();

        // TODO: Add here the params of an Antlers Tine
        return type == AntlersTypes.MODIFIER_PARAM;
    }
}
