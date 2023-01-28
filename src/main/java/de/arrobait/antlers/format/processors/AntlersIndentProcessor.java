package de.arrobait.antlers.format.processors;

import com.intellij.formatting.Indent;
import com.intellij.formatting.templateLanguages.BlockWithParent;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.lang.ASTNode;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import com.intellij.psi.formatter.xml.SyntheticBlock;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.xml.XmlTag;
import de.arrobait.antlers.format.AntlersBlock;
import de.arrobait.antlers.psi.AntlersPsiUtil;
import de.arrobait.antlers.psi.AntlersTypes;

import static de.arrobait.antlers.psi.AntlersTypes.*;

public class AntlersIndentProcessor {
    private final BlockWithParent myParent;
    private final HtmlPolicy myHtmlPolicy;

    public AntlersIndentProcessor(BlockWithParent parent, HtmlPolicy htmlPolicy) {
        myHtmlPolicy = htmlPolicy;
        myParent = parent;
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

        if (parentType == SWITCH_TAG && (elementType == SWITCH_CASE || elementType == DEFAULT_CASE)) {
            return Indent.getNormalIndent();
        }

        if (AntlersPsiUtil.isNonRootStatementsElement(node.getPsi())) {
            DataLanguageBlockWrapper foreignBlockParent = getForeignBlockParent(false);
            if (foreignBlockParent == null) {
                return Indent.getNormalIndent();
            }

            if (foreignBlockParent.getNode() instanceof XmlTag) {
                XmlTag xmlTag = (XmlTag) foreignBlockParent.getNode();
                if (!myHtmlPolicy.indentChildrenOf(xmlTag)) {
                    return Indent.getNormalIndent();
                }
            }

            return Indent.getNoneIndent();
        }

        if (parent != null && AntlersPsiUtil.isNonRootStatementsElement(parent.getPsi())) {
            if (myParent instanceof AntlersBlock && ((AntlersBlock) myParent).getIndent() == Indent.getNoneIndent()) {
                return Indent.getNormalIndent();
            }
        }

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


    private static boolean isAttribute(ASTNode child) {
        IElementType type = child.getElementType();

        // TODO: Add here the params of an Antlers Tine
        return type == AntlersTypes.MODIFIER_PARAM;
    }
}
