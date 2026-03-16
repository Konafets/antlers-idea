package de.arrobait.antlers.format.blocks

import com.intellij.formatting.*
import com.intellij.formatting.templateLanguages.BlockWithParent
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.xml.HtmlPolicy
import com.intellij.psi.formatter.xml.SyntheticBlock
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.xml.XmlTag
import de.arrobait.antlers.format.AntlersAbstractBlock
import de.arrobait.antlers.format.AntlersBlockContext
import de.arrobait.antlers.psi.AntlersPsiUtil
import de.arrobait.antlers.psi.AntlersTypes
import de.arrobait.antlers.psi.AntlersTypes.*

open class AntlersBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
    blockFactory: TemplateLanguageBlockFactory,
    settings: CodeStyleSettings,
    foreignChildren: MutableList<DataLanguageBlockWrapper>?,
    context: AntlersBlockContext?,
    htmlPolicy: HtmlPolicy,
    spacingBuilder: SpacingBuilder,
) : AntlersAbstractBlock(node, wrap, alignment, blockFactory, settings, foreignChildren, context, htmlPolicy, spacingBuilder) {

    override fun getIndent(): Indent? {
        // Ignore Whitespace
        if (myNode.text.trim().isEmpty()) {
            return Indent.getNoneIndent()
        }

        val treeParent = myNode.treeParent

        // If the tree parent of the current node is the file itself, we are the root, so no indent
        if (treeParent.elementType is IFileElementType) {
            return Indent.getNoneIndent()
        }

//        if (isAttribute(myNode)) {
//            return null
//        }

        if (AntlersPsiUtil.isNonRootStatementsElement(myNode.psi)) {
            // we are computing the indent for a non-root node
            // if it's not contained in a foreign block, indent

            val foreignBlockParent = getForeignBlockParent(false)
            if (foreignBlockParent == null) {
                return Indent.getNormalIndent()
            }

            // otherwise, only indent if our foreign parent isn't indenting us
            if (foreignBlockParent.node is XmlTag) {
                val xmlTag = foreignBlockParent.node as XmlTag
                if (!myHtmlPolicy.indentChildrenOf(xmlTag)) {
                    // no indent from xml parent, add our own
                    return Indent.getNormalIndent()
                }
            }
            return Indent.getNoneIndent()
        }

        if (AntlersPsiUtil.isNonRootStatementsElement(treeParent.psi)) {
            // we are computing the indent for a direct descendant of a non-root node
            // if its Block parent (i.e. not Antlers AST Tree parent) is an Antlers block
            // which has NOT been indented, then have the element provide the indent itself
            if (parent is AntlersBlock && (parent as AntlersBlock).indent == Indent.getNoneIndent()) {
                return Indent.getNormalIndent()
            }
        }

        // any element this is the direct descendant of a foreign block gets an indent
        // (unless that foreign element has been configured to not indent its children)
        val foreignParent = getForeignBlockParent(true)
        if (foreignParent != null) {
            val foreignParentNode = foreignParent.node
            if (foreignParentNode is XmlTag && !myHtmlPolicy.indentChildrenOf(foreignParentNode)) {
                return Indent.getNoneIndent()
            }
            return Indent.getNormalIndent()
        }

        return Indent.getNoneIndent()
    }

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        val parent = parent
        val elementType = myNode.elementType
        val parentNode = myNode.treeParent
        val parentIsInstanceOfDataLanguageBlockWrapper = parent is DataLanguageBlockWrapper

        if (newChildIndex == 0) {
            if (parentNode.elementType == IF_STATEMENT || parentNode.elementType == UNLESS_STATEMENT) {
                if (elementType == TINES) {
                    return ChildAttributes(Indent.getNoneIndent(), null)
                } else {
                    return ChildAttributes(Indent.getNormalIndent(), null)
                }
            }
            if (parentNode.elementType == TAG_PAIR) {
                return ChildAttributes(Indent.getNormalIndent(), null)
            }
            return ChildAttributes(Indent.getNoneIndent(), null)
        }
        if (elementType == BLOCK_WRAPPER || elementType == IF_STATEMENT || elementType == UNLESS_STATEMENT || elementType == TAG_PAIR
            || (parentIsInstanceOfDataLanguageBlockWrapper && (elementType != TINES || elementType != TAG_SINGLE || myNode.treeNext is PsiErrorElement))) {
            return ChildAttributes(Indent.getNormalIndent(), null)
        }

        return ChildAttributes(Indent.getNoneIndent(), null)
    }

    override fun getWrap(): Wrap? {
        if (AntlersPsiUtil.hasElementType(myNode, BLOCK_WRAPPER)) {
            return Wrap.createWrap(WrapType.ALWAYS, true)
        }

        return super.getWrap()
    }

    private fun getForeignBlockParent(immediate: Boolean): DataLanguageBlockWrapper? {
        var foreignBlockParent: DataLanguageBlockWrapper? = null
        var parent: BlockWithParent? = parent

        while (parent != null) {
            if (parent is DataLanguageBlockWrapper && parent.original !is SyntheticBlock) {
                foreignBlockParent = parent
                break
            } else if (immediate && parent is AntlersBlock) {
                break
            }
            parent = parent.parent
        }

        return foreignBlockParent
    }

    companion object {
        @JvmStatic
        private fun isAttribute(child: ASTNode): Boolean {
            val type = child.elementType

            return type == AntlersTypes.MODIFIER_PARAM
        }
    }
}
