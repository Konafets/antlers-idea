package de.arrobait.antlers.format;

import com.intellij.formatting.Indent;
import com.intellij.formatting.templateLanguages.BlockWithParent;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.lang.ASTNode;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.formatter.xml.SyntheticBlock;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.xml.XmlTag;
import de.arrobait.antlers.psi.AntlersPsiUtil;

import static de.arrobait.antlers.psi.AntlersTypes.*;

public class AntlersIndentProcessor {
    private final BlockWithParent myParent;
    private final HtmlPolicy myHtmlPolicy;

    public AntlersIndentProcessor(BlockWithParent parent, HtmlPolicy htmlPolicy) {
        myParent = parent;
        myHtmlPolicy = htmlPolicy;
    }

    public Indent getChildIndent(final ASTNode node) {
        final IElementType elementType = node.getElementType();
        final ASTNode prevSibling = AntlersPsiUtil.getPrevSiblingSkipWhiteSpacesAndComments(node);
        final IElementType prevSiblingType = prevSibling == null ? null : prevSibling.getElementType();
        final ASTNode parent = node.getTreeParent();
        final IElementType parentType = parent != null ? parent.getElementType() : null;
        final ASTNode superParent = parent == null ? null : parent.getTreeParent();
        final IElementType superParentType = superParent == null ? null : superParent.getElementType();

        // Ignore whitespace
        if (node.getText().trim().length() == 0) {
            return Indent.getNoneIndent();
        }

        // TODO Add isAttribute()
//        if (superParentType == SWITCH_NODE) {
//            if (elementType == T_LP) {
//                return Indent.getNormalIndent();
//            }
//        }

        if (parentType == SWITCH_TAG && (elementType == SWITCH_CASE || elementType == DEFAULT_CASE)) {
            return Indent.getNormalIndent();
        }

        if (AntlersPsiUtil.isNonRootStatementsElement(node.getPsi())) {
            // Here we have a non-root Antlers element we are computing the indent for:
            // if it's not contained in a foreign block, indent!
            DataLanguageBlockWrapper foreignBlockParent = getForeignBlockParent(false);
            if (foreignBlockParent == null) {
                return Indent.getNormalIndent();
            }

            // otherwise, only indent if our foreign parent isn't indenting us
            if (foreignBlockParent.getNode() instanceof XmlTag) {
                XmlTag xmlTag = (XmlTag) foreignBlockParent.getNode();
                if (!myHtmlPolicy.indentChildrenOf(xmlTag)) {
                    // no indent from XML parent, odd our own
                    return Indent.getNormalIndent();
                }
            }

            return Indent.getNoneIndent();
        }

        if (parent != null && AntlersPsiUtil.isNonRootStatementsElement(parent.getPsi())) {
            // we are computing the indent for a direct descendant of a non-root TINE:
            // if its Block parent (i.e. not Antlers AST tree parent) is a AntlersBlock
            // which has NOT been indented, then hae the element provide the indent itself
            if (myParent instanceof AntlersBlock && ((AntlersBlock) myParent).getIndent() == Indent.getNoneIndent()) {
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

    /**
     * Returns this blocks first real foreign block parent if it exists and null otherwise. (By "real" here, we mean that this method
     * skips SyntheticBlock blocks inserted by the template formatter)
     *
     * @param immediate Pass true to only check for an immediate foreign parent, false to look up the hierarchy.
     */
    private DataLanguageBlockWrapper getForeignBlockParent(boolean immediate) {
        DataLanguageBlockWrapper foreignBlockParent = null;
        BlockWithParent parent = myParent;

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

}
