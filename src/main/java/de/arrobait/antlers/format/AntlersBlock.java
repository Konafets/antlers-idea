package de.arrobait.antlers.format;

import com.intellij.formatting.*;
import com.intellij.formatting.templateLanguages.BlockWithParent;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.formatter.xml.SyntheticBlock;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.xml.XmlTag;
import de.arrobait.antlers.format.processors.AntlersSpacingProcessor;
import de.arrobait.antlers.format.processors.AntlersWrappingProcessor;
import de.arrobait.antlers.psi.AntlersPsiUtil;
import de.arrobait.antlers.psi.AntlersTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static de.arrobait.antlers.psi.AntlersTypes.*;

public class AntlersBlock extends AntlersAbstractBlock {

    private final AntlersSpacingProcessor mySpacingProcessor;

    protected final AntlersWrappingProcessor myWrappingProcessor;

    private CodeStyleSettings myCustomSettings;

    public AntlersBlock(@NotNull ASTNode node,
                        @Nullable Wrap wrap,
                        @Nullable Alignment alignment,
                        @NotNull TemplateLanguageBlockFactory blockFactory,
                        @NotNull CodeStyleSettings customSettings,
                        @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                        @NotNull HtmlPolicy policy) {
        super(node, wrap, alignment, blockFactory, customSettings, foreignChildren, policy);

        mySpacingProcessor = new AntlersSpacingProcessor(node, customSettings);
        myWrappingProcessor = new AntlersWrappingProcessor(node);
    }

    @Override
    public @Nullable Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
        return mySpacingProcessor.getSpacing(child1, child2);
    }

    @Override
    public Indent getIndent() {
        // ignore whitespace
        if (myNode.getText().trim().length() == 0) {
            return Indent.getNoneIndent();
        }

        if (isAttribute(myNode)) {
            return null;
        }

        if (AntlersPsiUtil.isNonRootStatementsElement(myNode.getPsi())) {
            // we're computing the indent for a non-root STATEMENTS:
            //      if it's not contained in a foreign block, indent!

            DataLanguageBlockWrapper foreignBlockParent = getForeignBlockParent(false);
            if (foreignBlockParent == null) {
                return Indent.getNormalIndent();
            }

            // otherwise, only indent if our foreign parent isn't indenting us
            if (foreignBlockParent.getNode() instanceof XmlTag) {
                XmlTag xmlTag = (XmlTag) foreignBlockParent.getNode();
                if (!myHtmlPolicy.indentChildrenOf(xmlTag)) {
                    // no indent from xml parent, add our own
                    return Indent.getNormalIndent();
                }
            }

            return Indent.getNoneIndent();
        }

        if (myNode.getTreeParent() != null
                && AntlersPsiUtil.isNonRootStatementsElement(myNode.getTreeParent().getPsi())) {
            // we're computing the indent for a direct descendant of a non-root STATEMENTS:
            //    if its Block parent (i.e. not Antlers AST Tree parent) is an Antlers block
            //    which has NOT been indented, then have the element provide the indent itself
            if (getParent() instanceof AntlersBlock && ((AntlersBlock)getParent()).getIndent() == Indent.getNoneIndent()) {
                return Indent.getNormalIndent();
            }
        }

        // any element that is the direct descendant of a foreign block gets an indent
        // (unless that foreign element has been configured to not indent its children)
        DataLanguageBlockWrapper foreignParent = getForeignBlockParent(true);
        if (foreignParent != null) {
            if (foreignParent.getNode() instanceof XmlTag && !myHtmlPolicy.indentChildrenOf((XmlTag) foreignParent.getNode())) {
                return Indent.getNoneIndent();
            }
            return Indent.getNormalIndent();
        }

        return Indent.getNoneIndent();
    }

    @Override
    public @NotNull ChildAttributes getChildAttributes(int newChildIndex) {
        BlockWithParent parent = getParent();
        IElementType elementType = myNode.getElementType();
        ASTNode parentNode = myNode.getTreeParent();
        boolean parentInstanceOfDataLangBlockWrapper = parent instanceof DataLanguageBlockWrapper;

        if (newChildIndex == 0) {
            if (parentNode.getElementType() == CONDITIONAL) {
                if (elementType == TINES) {
                    return new ChildAttributes(Indent.getNoneIndent(), null);
                } else {
                    return new ChildAttributes(Indent.getNormalIndent(), null);
                }
            }
            return new ChildAttributes(Indent.getNoneIndent(), null);
        }

        if ((elementType == AntlersTypes.BLOCK_WRAPPER || elementType == CONDITIONAL || elementType == TAG_PAIR)
                || (parentInstanceOfDataLangBlockWrapper && (elementType != TINES || elementType != TAG_SINGLE || myNode.getTreeNext() instanceof PsiErrorElement))) {
          return new ChildAttributes(Indent.getNormalIndent(), null);
        }

        return new ChildAttributes(Indent.getNoneIndent(), null);
    }

    @Override
    public @Nullable Wrap getWrap() {
        if (AntlersPsiUtil.hasElementType(myNode, BLOCK_WRAPPER)) {
            return Wrap.createWrap(WrapType.ALWAYS, true);
        }

        return super.getWrap();
    }

//    @Override
//    protected Wrap createChildWrap(ASTNode child) {
//        final Wrap wrap = myWrappingProcessor.createChildWrap(child, myWrap);
//
//        return wrap;
//    }

    /**
     * Returns this blocks first real foreign block parent if it exists and null otherwise. (By "real" here, we mean that this method
     * skips SyntheticBlock blocks inserted by the template formatter)
     *
     * @param immediate Pass true to only check for an immediate foreign parent, false to look up the hierarchy.
     */
    private DataLanguageBlockWrapper getForeignBlockParent(boolean immediate) {
        DataLanguageBlockWrapper foreignBlockParent = null;
        BlockWithParent parent = getParent();

        while (parent != null) {
            if (parent instanceof DataLanguageBlockWrapper && !(((DataLanguageBlockWrapper) parent).getOriginal() instanceof SyntheticBlock)) {
                foreignBlockParent = (DataLanguageBlockWrapper) parent;
                break;
            } else if (immediate && parent instanceof AntlersBlock) {
                break;
            }
            parent = parent.getParent();
        }

        return foreignBlockParent;
    }

    private static boolean isAttribute(ASTNode child) {
        IElementType type = child.getElementType();

        // TODO: Add here the params of an Antlers Tine
        return type == AntlersTypes.MODIFIER_PARAM;
    }
}
