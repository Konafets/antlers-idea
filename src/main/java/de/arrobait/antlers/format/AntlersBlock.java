package de.arrobait.antlers.format;

import com.intellij.formatting.*;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlock;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.psi.AntlersTokenSets;
import de.arrobait.antlers.psi.AntlersTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static de.arrobait.antlers.psi.AntlersTypes.*;

public class AntlersBlock extends TemplateLanguageBlock {

    public static final List<AntlersBlock> ANTLERS_EMPTY = Collections.emptyList();

    private final AntlersSpacingProcessor mySpacingProcessor;

    private final AntlersBlockContext myContext;

    @NotNull
    private final Indent myIndent;

    private List<AntlersBlock> mySubAntlersBlocks;

    public AntlersBlock(@NotNull ASTNode node,
                        Wrap wrap,
                        Alignment alignment,
                        @NotNull TemplateLanguageBlockFactory blockFactory,
                        @NotNull CodeStyleSettings settings,
                        @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                        @NotNull HtmlPolicy htmlPolicy,
                        @NotNull AntlersBlockContext context
    ) {
        super(node, wrap, alignment, blockFactory, settings, foreignChildren);
        myContext = context;
        mySpacingProcessor = new AntlersSpacingProcessor(node, context.getAntlersSettings());
        myIndent = new AntlersIndentProcessor(getParent(), htmlPolicy).getChildIndent(node);
    }

    /**
     * We indent the code in the following manner, playing nice with the formatting from the language
     * we are implementing.
     * <pre>
     *     * Block expressions:
     *          {{ collection:blog }}
     *              INDENTED_CONTENT
     *          {{ /collection:blog }}
     *     * Conditional expressions using "if" syntax:
     *          {{ if foo}}
     *              INDENTED_CONTENT
     *          {{ elseif }}
     *              INDENTED_CONTENT
     *          {{ else }}
     *              INDENTED_CONTENT
     *          {{ /if }}
     *     * Conditional expressions using "unless" syntax:
     *          {{ unless foo}}
     *              INDENTED_CONTENT
     *          {{ elseif }}
     *              INDENTED_CONTENT
     *          {{ else }}
     *              INDENTED_CONTENT
     *          {{ /unless }}
     * </pre>
     *
     * This naturally maps to any "tines" expressions in the grammar which is not a child of
     * the root program element.
     *
     * To understand the approach in this method, consider the following:
     * {{ collection:blog }}
     * BEGIN_STATEMENTS
     * TEMPLATE_STUFF
     * END_STATEMENTS
     * {{ /collection:blog }}
     *
     * then formatting looks easy. Simply add an indent (represented by "[antlers_indent]") to the STATEMENTS
     *
     * {{ collection:blog }}
     * [antlers_indent]BEGIN_STATEMENTS
     * [antlers_indent]TEMPLATE_STUFF
     * [antlers_indent]END_STATEMENTS
     * {{ /collection:blog }}
     *
     * However, if we contained in templated language block, its going to provide same indents of its own
     * (call them "[tpl_indent]") which quickly leads to undesirable double-indenting:
     *
     * <pre>
     * <div>
     * [tpl_indent]{{ collection:blog }}
     *   [antlers_indent]BEGIN_STATEMENTS
     *   [tpl_indent][antlers_indent]TEMPLATE_STUFF
     *   [antlers_indent]END_STATEMENTS
     * [tpl_indent]{{ /collection:blog }}
     * </div>
     * </pre>
     *
     * So to behave correctly in both situations, we indent STATEMENTS from the "outside" anytime we're not wrapped
     * in a templated language block, and we indent STATEMENTS from the "inside" (i.e. apply an indent to each non-template
     * language STATEMENT inside the STATEMENTS) to interleave nicely with templated-language provided indents.
     */
    @Override
    public Indent getIndent() {
        return myIndent;
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return mySpacingProcessor.getSpacing(child1, child2);
    }

    @Override
    protected IElementType getTemplateTextElementType() {
        // we ignore OUTER_CONTENT tokens since they get formatted by the templated language
        return AntlersTypes.OUTER_CONTENT;
    }

    @Override
    public boolean isRequiredRange(TextRange range) {
        // seems our approach doesn't require us to inisert any custom DataLanguageBlockFragmentWrapper blocks
        return false;
    }

    @Override
    @NotNull
    public ChildAttributes getChildAttributes(int newChildIndex) {
        // We indent if we are in a BLOCK_WRAPPER (note that this works nicely since Enter can only be invoked INSIDE
        // a block (i.e. after the open block)
        //
        // Also indent if we are wrapped in a block created by the templated language
        final IElementType elementType = myNode.getElementType();
        final AntlersBlock previousBlock = newChildIndex == 0 ? null : getSubAntlersBlocks().get(newChildIndex - 1);
        final IElementType previousType = previousBlock == null ? null : previousBlock.getNode().getElementType();

        if (getParent() instanceof DataLanguageBlockWrapper && (elementType != AntlersTypes.TINES || newChildIndex != 0 || myNode.getTreeNext() instanceof PsiErrorElement)) {
            return new ChildAttributes(Indent.getNormalIndent(), null);
        }

        if (AntlersTokenSets.BLOCKS.contains(elementType)) {
            return new ChildAttributes(Indent.getNormalIndent(), null);
        }

        if (elementType == SWITCH_TAG
                && (previousType == T_LP || previousType == SWITCH_CASE)) {
            return new ChildAttributes(Indent.getNormalIndent(), null);
        }

        return new ChildAttributes(Indent.getNoneIndent(), null);
    }

    private List<AntlersBlock> getSubAntlersBlocks() {
        if (mySubAntlersBlocks == null) {
            mySubAntlersBlocks = new ArrayList<>();
            for (Block block : getSubBlocks()) {
                mySubAntlersBlocks.add((AntlersBlock) block);
            }

            mySubAntlersBlocks = !mySubAntlersBlocks.isEmpty() ? mySubAntlersBlocks : ANTLERS_EMPTY;
        }

        return mySubAntlersBlocks;
    }

//
//    @Override
//    public @Nullable Alignment getAlignment() {
//        return null;
//    }

    //    private final SpacingBuilder spacingBuilder;
//
//    public AntlersBlock(@NotNull ASTNode node,
//                        @Nullable Wrap wrap,
//                        @Nullable Alignment alignment,
//                        SpacingBuilder spacingBuilder
//    ) {
//        super(node, wrap, alignment);
//        this.spacingBuilder = spacingBuilder;
//    }

//    @Override
//    protected List<Block> buildChildren() {
//        if (isLeaf()) {
//            return EMPTY;
//        }
//
//        final List<Block> blocks = new ArrayList<>();
//
//        ASTNode child = myNode.getFirstChildNode();
//        while (child != null) {
//            if (FormatterUtil.containsWhiteSpacesOnly(child)) {
//                continue;
//            }
//
//            final AntlersBlock childBlock = new AntlersBlock(child, createChildWrap(child), null);
//            if (child.getElementType() != TokenType.WHITE_SPACE) {
//                Block block = new AntlersBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(), spacingBuilder);
//                blocks.add(block);
//            }
//            child = child.getTreeNext();
//        }
//
//        return blocks;
//
//    }

//    @Override
//    public boolean isLeaf() {
//        return myNode.getFirstChildNode() == null;
//    }
}
