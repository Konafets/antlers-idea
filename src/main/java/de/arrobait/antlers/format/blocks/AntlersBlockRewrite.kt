package de.arrobait.antlers.format.blocks

import com.intellij.formatting.*
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper
import com.intellij.lang.ASTNode
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.xml.SyntheticBlock
import com.intellij.psi.formatter.xml.XmlFormattingPolicy
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.xml.XmlTag
import com.intellij.xml.template.formatter.AbstractXmlTemplateFormattingModelBuilder
import com.intellij.xml.template.formatter.TemplateLanguageBlock
import de.arrobait.antlers.parser.AntlersParserDefinition.COMMENTS
import de.arrobait.antlers.psi.AntlersPsiUtil

class AntlersBlockRewrite(
    builder: AbstractXmlTemplateFormattingModelBuilder,
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
    settings: CodeStyleSettings,
    xmlFormattingPolicy: XmlFormattingPolicy,
    indent: Indent,
    private var spacingBuilder: SpacingBuilder,
) : TemplateLanguageBlock(builder, node, wrap, alignment, settings, xmlFormattingPolicy, indent) {

    init {
        var isPair: Boolean = true
        if (node.firstChildNode == null) {
            isPair = false
        }
    }

    override fun getIndent(): Indent? {
        if (node.text.trim().isEmpty()) {
            return Indent.getNoneIndent()
        }

        val treeParent = myNode.treeParent

        // If the tree parent of the current node is the file itself, we are the root, so do ont indent
        if (treeParent.elementType is IFileElementType) {
            return Indent.getNoneIndent()
        }

        val elementType = node.elementType
        val myParent = parent
        val psi = node.psi

        if (AntlersPsiUtil.isNonRootStatementsElement(psi)) {
            // We are computing the indent for a non-root TINE
            // if its not contained in a foreign block, indent.

            val foreignBlockParent = getForeignBlockParent(false) ?: return Indent.getNormalIndent()

            if (foreignBlockParent.node is XmlTag) {
                val xmlTag = foreignBlockParent.node as XmlTag
//                if (!htmlPolicy().indentChildrenOf(xmlTag)) {
//                    // no indent from XML parent, add our own
//                    return Indent.getNormalIndent()
//                }
            }

            return  Indent.getNoneIndent()
        }
        return Indent.getNoneIndent()
    }

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        val parent = parent
        val elementType = myNode.elementType
        val treeParent = myNode.treeParent
        val parentInstanceOfDataLangBlockWrapper = parent is DataLanguageBlockWrapper

        return super.getChildAttributes(newChildIndex)
    }

    override fun getChildIndent(node: ASTNode): Indent {
        val parent = parent
        val elementType = myNode.elementType
        val treeParent = myNode.treeParent
        val parentInstanceOfDataLangBlockWrapper = parent is DataLanguageBlockWrapper
        return Indent.getNoneIndent()
    }

    override fun getSpacing(adjacentBlock: TemplateLanguageBlock?): Spacing? {
        return null
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }

    override fun isLeaf(): Boolean {
        return COMMENTS.contains(node.elementType)
    }

    private fun getForeignBlockParent(immediate: Boolean): DataLanguageBlockWrapper? {
        var foreignBlockParent: DataLanguageBlockWrapper? = null
        var parent = parent

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
}
