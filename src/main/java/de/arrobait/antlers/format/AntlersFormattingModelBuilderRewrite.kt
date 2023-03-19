package de.arrobait.antlers.format

import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.project.Project
import com.intellij.prettierjs.PrettierConfiguration
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.xml.XmlFormattingPolicy
import com.intellij.psi.tree.TokenSet
import com.intellij.xml.template.formatter.AbstractXmlTemplateFormattingModelBuilder
import de.arrobait.antlers.AntlersLanguage
import de.arrobait.antlers.format.blocks.AntlersBlockRewrite
import de.arrobait.antlers.format.settings.AntlersCodeStyleSettings
import de.arrobait.antlers.psi.AntlersCustomElementTypes
import de.arrobait.antlers.psi.AntlersFile
import de.arrobait.antlers.psi.AntlersTokenSets
import de.arrobait.antlers.psi.AntlersTypes

class AntlersFormattingModelBuilderRewrite() : AbstractXmlTemplateFormattingModelBuilder(),
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
        return AntlersBlockRewrite(this, node, wrap, alignment, settings, xmlFormattingPolicy, indent, createSpacingBuilder(settings))
    }

    override fun dontFormatMyModel(): Boolean {
        if (myFile != null) {
            val project: Project? = myFile?.project
            project!!
            val prettierConfiguration = PrettierConfiguration.getInstance(project)
            return prettierConfiguration.isRunOnReformat
        }

        return false
    }

    companion object {
        private val ASSIGNMENT_OPERATORS = TokenSet.create(
                    AntlersTypes.T_OP_ASSIGN,
                    AntlersTypes.T_OP_SELF_ASSIGN_ADD,
                    AntlersTypes.T_OP_SELF_ASSIGN_SUB,
                    AntlersTypes.T_OP_SELF_ASSIGN_MUL,
                    AntlersTypes.T_OP_SELF_ASSIGN_DIV,
                    AntlersTypes.T_OP_SELF_ASSIGN_MOD
                )

        private val OPERATORS = TokenSet.create(
                    AntlersTypes.TENARY_BRANCH_OP,
                    AntlersTypes.T_DOT,
                    AntlersTypes.T_OP_EXCLAMATION_MARK,
                    AntlersTypes.T_OP_QUESTIONMARK,
                    AntlersTypes.T_OP_PLUS,
                    AntlersTypes.T_OP_MINUS,
                    AntlersTypes.T_OP_MUL,
                    AntlersTypes.DIV_OP,
                    AntlersTypes.T_PERCENT,
                    AntlersTypes.T_OP_POW,
                    AntlersTypes.T_OP_EQ,
                    AntlersTypes.T_OP_NEQ,
                    AntlersTypes.T_OP_IDENT,
                    AntlersTypes.T_OP_NOT_IDENT,
                    AntlersTypes.T_OP_LT,
                    AntlersTypes.T_OP_LTE,
                    AntlersTypes.T_OP_GT,
                    AntlersTypes.T_OP_GTE,
                    AntlersTypes.T_OP_SPACESHIP,
                    AntlersTypes.T_OP_NULL_COALESCENCE,
                    AntlersTypes.T_OP_GATEKEEPER,
                    AntlersTypes.T_OP_AND,
                    AntlersTypes.T_OP_OR,
                    AntlersTypes.T_OP_XOR,
                    AntlersTypes.T_OP_ARROW
                )

        @JvmStatic
        private fun createSpacingBuilder(settings: CodeStyleSettings): SpacingBuilder {
            val commonSettings = settings.getCommonSettings(AntlersLanguage.INSTANCE)
            val mySettings = settings.getCustomSettings(AntlersCodeStyleSettings::class.java)
            return SpacingBuilder(settings, AntlersLanguage.INSTANCE)
                .after(AntlersTypes.T_COMMA)
                .spaceIf(commonSettings.SPACE_AFTER_COMMA)

                .after(AntlersTokenSets.OPENING_DELIMITERS)
                .spaceIf(mySettings.SPACE_AFTER_AND_BEFORE_ANTLERS_DELIMITERS)

                .before(AntlersTokenSets.CLOSING_DELIMITERS)
                .spaceIf(mySettings.SPACE_AFTER_AND_BEFORE_ANTLERS_DELIMITERS)

                .around(OPERATORS)
                .spaceIf(mySettings.SPACE_AROUND_OPERATORS)

                .around(AntlersTypes.T_PIPE)
                .spaceIf(mySettings.SPACE_AROUND_MODIFIER_PIPE)

                .around(ASSIGNMENT_OPERATORS)
                .spaceIf(commonSettings.SPACE_AROUND_ASSIGNMENT_OPERATORS)
        }
    }
}
