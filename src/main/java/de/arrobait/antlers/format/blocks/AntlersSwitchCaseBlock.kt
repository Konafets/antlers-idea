package de.arrobait.antlers.format.blocks

import com.intellij.formatting.*
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory
import com.intellij.lang.ASTNode
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.xml.HtmlPolicy
import de.arrobait.antlers.AntlersLanguage
import de.arrobait.antlers.format.AntlersAbstractBlock
import de.arrobait.antlers.format.AntlersBlockContext

class AntlersSwitchCaseBlock(
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
        val commonsSettings = settings.getCommonSettings(AntlersLanguage.INSTANCE)
        if (commonsSettings.INDENT_CASE_FROM_SWITCH) {
            val indentOptions = settings.getCommonSettings(AntlersLanguage.INSTANCE).indentOptions
            indentOptions!!
            return Indent.getSpaceIndent(indentOptions.INDENT_SIZE * 2)
        }

        return Indent.getNoneIndent()
    }

    override fun getWrap(): Wrap? {
        val commonsSettings = settings.getCommonSettings(AntlersLanguage.INSTANCE)
        if (commonsSettings.CASE_STATEMENT_ON_NEW_LINE) {
            return Wrap.createWrap(WrapType.ALWAYS, true)
        }

        return null
    }
}
