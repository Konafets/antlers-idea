package de.arrobait.antlers.format

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.xml.XmlFormattingPolicy
import com.intellij.xml.template.formatter.AbstractXmlTemplateFormattingModelBuilder
import com.intellij.xml.template.formatter.TemplateLanguageBlock
import de.arrobait.antlers.AntlersLanguage
import de.arrobait.antlers.parser.AntlersParserDefinition.COMMENTS
import de.arrobait.antlers.psi.AntlersPsiUtil
import de.arrobait.antlers.psi.AntlersTypes

class AntlersBlockKt(
    builder: AbstractXmlTemplateFormattingModelBuilder,
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
    settings: CodeStyleSettings,
    xmlFormattingPolicy: XmlFormattingPolicy,
    indent: Indent,
    var spacingBuilder: SpacingBuilder,
) : TemplateLanguageBlock(builder, node, wrap, alignment, settings, xmlFormattingPolicy, indent) {

    init {
        var isPair: Boolean = true
        if (node.firstChildNode == null) {
            isPair = false
        }
    }

    override fun getIndent(): Indent? {
        return Indent.getNoneIndent()
    }

    override fun getChildIndent(node: ASTNode): Indent {
        return Indent.getNormalIndent()
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
}
