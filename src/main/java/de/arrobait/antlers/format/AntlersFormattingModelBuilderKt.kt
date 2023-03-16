package de.arrobait.antlers.format

import com.intellij.formatting.Alignment
import com.intellij.formatting.Block
import com.intellij.formatting.Indent
import com.intellij.formatting.Wrap
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.xml.XmlFormattingPolicy
import com.intellij.xml.template.formatter.AbstractXmlTemplateFormattingModelBuilder
import de.arrobait.antlers.psi.AntlersCustomElementTypes
import de.arrobait.antlers.psi.AntlersFile
import de.arrobait.antlers.psi.AntlersTypes

class AntlersFormattingModelBuilderKt : AbstractXmlTemplateFormattingModelBuilder() {
    override fun isTemplateFile(file: PsiFile): Boolean {
        val result = file is AntlersFile
        return result
    }

    override fun isOuterLanguageElement(element: PsiElement): Boolean {
        val result = element.node.elementType == AntlersCustomElementTypes.OUTER_ANTLERS
        return result
    }

    override fun isMarkupLanguageElement(element: PsiElement): Boolean {
        val result = element.node.elementType == AntlersTypes.OUTER_CONTENT
        return result
    }

    override fun createTemplateLanguageBlock(
        node: ASTNode,
        settings: CodeStyleSettings,
        xmlFormattingPolicy: XmlFormattingPolicy,
        indent: Indent,
        alignment: Alignment?,
        wrap: Wrap?
    ): Block {
        return AntlersBlockKt(this, node, wrap, alignment, settings, xmlFormattingPolicy, indent)
    }
}
