package de.arrobait.antlers.format.blocks

import com.intellij.formatting.*
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory
import com.intellij.lang.ASTNode
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.xml.HtmlPolicy
import de.arrobait.antlers.format.AntlersAbstractBlock
import de.arrobait.antlers.format.AntlersBlockContext

class AntlersSwitchCloseBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
    blockFactory: TemplateLanguageBlockFactory,
    settings: CodeStyleSettings,
    foreignChildren: MutableList<DataLanguageBlockWrapper>?,
    context: AntlersBlockContext?,
    htmlPolicy: HtmlPolicy,
    spacingBuilder: SpacingBuilder
) : AntlersAbstractBlock(
    node,
    wrap,
    alignment,
    blockFactory,
    settings,
    foreignChildren,
    context,
    htmlPolicy,
    spacingBuilder
) {
    override fun getIndent(): Indent? {
        return Indent.getNormalIndent()
    }

    override fun getWrap(): Wrap? {
        return Wrap.createWrap(WrapType.ALWAYS, true)
    }
}
