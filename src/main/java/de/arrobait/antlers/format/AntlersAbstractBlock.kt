package de.arrobait.antlers.format

import com.intellij.formatting.*
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper
import com.intellij.formatting.templateLanguages.TemplateLanguageBlock
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.xml.HtmlPolicy
import com.intellij.psi.tree.IElementType
import de.arrobait.antlers.psi.AntlersTypes

abstract class AntlersAbstractBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
    blockFactory: TemplateLanguageBlockFactory,
    settings: CodeStyleSettings,
    foreignChildren: MutableList<DataLanguageBlockWrapper>?,
    context: AntlersBlockContext?,
    htmlPolicy: HtmlPolicy,
    private var spacingBuilder: SpacingBuilder,
) : TemplateLanguageBlock(node, wrap, alignment, blockFactory, settings, foreignChildren) {
    val myHtmlPolicy: HtmlPolicy
    private val myContext: AntlersBlockContext?

    init {
        myContext = context
        myHtmlPolicy = htmlPolicy
    }

    override fun isIncomplete(): Boolean {
        return super.isIncomplete()
    }

    override fun getTemplateTextElementType(): IElementType {
        // We ignore OUTER_CONTENT tokens since they get formatted by the templated language.
        return AntlersTypes.OUTER_CONTENT
    }

    override fun isRequiredRange(range: TextRange?): Boolean {
        return false
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacingBuilder.getSpacing(this, child1, child2)
    }
}
