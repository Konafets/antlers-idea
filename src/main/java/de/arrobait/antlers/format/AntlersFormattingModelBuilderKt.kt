package de.arrobait.antlers.format

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.project.Project
import com.intellij.prettierjs.PrettierConfiguration
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.xml.XmlFormattingPolicy
import com.intellij.xml.template.formatter.AbstractXmlTemplateFormattingModelBuilder
import de.arrobait.antlers.AntlersLanguage
import de.arrobait.antlers.psi.AntlersCustomElementTypes
import de.arrobait.antlers.psi.AntlersFile
import de.arrobait.antlers.psi.AntlersTokenSets
import de.arrobait.antlers.psi.AntlersTypes

class AntlersFormattingModelBuilderKt() : AbstractXmlTemplateFormattingModelBuilder(),
    DelegatingFormattingModelBuilder {
    var myFile: PsiFile? = null

    override fun isTemplateFile(file: PsiFile): Boolean {
        myFile = file
        return file is AntlersFile
    }

    override fun isOuterLanguageElement(element: PsiElement): Boolean {
        return element.node.elementType == AntlersCustomElementTypes.OUTER_ANTLERS
    }

    override fun isMarkupLanguageElement(element: PsiElement): Boolean {
        return element.node.elementType == AntlersTypes.OUTER_CONTENT
    }

    override fun createTemplateLanguageBlock(
        node: ASTNode,
        settings: CodeStyleSettings,
        xmlFormattingPolicy: XmlFormattingPolicy,
        indent: Indent,
        alignment: Alignment?,
        wrap: Wrap?
    ): Block {
        return AntlersBlockKt(this, node, wrap, alignment, settings, xmlFormattingPolicy, indent, createSpacingBuilder(settings))
    }

    companion object {
        @JvmStatic
        private fun createSpacingBuilder(settings: CodeStyleSettings): SpacingBuilder {
            return SpacingBuilder(settings, AntlersLanguage.INSTANCE)
                .after(AntlersTypes.T_COMMA).spaces(1)
                .after(AntlersTokenSets.OPENING_DELIMITERS).spaces(1)
                .before(AntlersTokenSets.CLOSING_DELIMITERS).spaces(1)
                .around(AntlersTokenSets.OPERATORS).spaces(1)
                .around(AntlersTypes.T_PIPE).spaces(1)
        }
    }

    override fun dontFormatMyModel(): Boolean {
        val project: Project? = myFile?.project
        project!!
        val prettierConfiguration = PrettierConfiguration.getInstance(project)
        val isRunOnReformat = prettierConfiguration.isRunOnReformat
        val isRunOnSave = prettierConfiguration.isRunOnReformat

        return isRunOnReformat || isRunOnSave
    }
}
