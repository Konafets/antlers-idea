package de.arrobait.antlers.format

import com.intellij.formatting.Alignment
import com.intellij.formatting.Indent
import com.intellij.formatting.Wrap
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory
import com.intellij.lang.ASTNode
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.xml.HtmlPolicy

class AntlersConditionalBlock(
    node: ASTNode,
    wrap: Wrap?,
    alignment: Alignment?,
    blockFactory: TemplateLanguageBlockFactory,
    customSettings: CodeStyleSettings,
    foreignChildren: MutableList<DataLanguageBlockWrapper>?,
    context: AntlersBlockContext?,
    policy: HtmlPolicy
) : AntlersAbstractBlock(node, wrap, alignment, blockFactory, customSettings, foreignChildren, context, policy) {

    override fun getIndent(): Indent {
        return Indent.getNoneIndent()
    }
}
