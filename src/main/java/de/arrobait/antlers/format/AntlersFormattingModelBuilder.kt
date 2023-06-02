package de.arrobait.antlers.format

import com.intellij.formatting.*
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper
import com.intellij.formatting.templateLanguages.TemplateLanguageBlock
import com.intellij.formatting.templateLanguages.TemplateLanguageFormattingModelBuilder
import com.intellij.lang.ASTNode
import com.intellij.openapi.project.Project
import com.intellij.prettierjs.PrettierConfiguration
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.DocumentBasedFormattingModel
import com.intellij.psi.formatter.FormattingDocumentModelImpl
import com.intellij.psi.formatter.xml.HtmlPolicy
import com.intellij.psi.templateLanguages.SimpleTemplateLanguageFormattingModelBuilder
import com.intellij.psi.tree.TokenSet
import de.arrobait.antlers.AntlersLanguage
import de.arrobait.antlers.format.blocks.AntlersBlock
import de.arrobait.antlers.format.blocks.AntlersSwitchCaseBlock
import de.arrobait.antlers.format.blocks.AntlersSwitchCloseBlock
import de.arrobait.antlers.format.settings.AntlersCodeStyleSettings
import de.arrobait.antlers.psi.AntlersCustomElementTypes.OUTER_ANTLERS
import de.arrobait.antlers.psi.AntlersFile
import de.arrobait.antlers.psi.AntlersTokenSets
import de.arrobait.antlers.psi.AntlersTypes

class AntlersFormattingModelBuilder: TemplateLanguageFormattingModelBuilder() {
    private var myFile: PsiFile? = null

    /**
     * We have to override {@link TemplateLanguageFormattingModelBuilder#createModel} since after
     * we delegate to some templated languages. Those languages (XML/HTML for sure, potentially others)
     * delegate right back to us to format the Antlers.OUTER_ELEMENT_TYPE token, we tell them to ignore,
     * causing a stack-overflowing loop of polite format-delegation.
     */
    override fun createModel(context: FormattingContext): FormattingModel {
        val file = context.containingFile
        myFile = file
        val settings = context.codeStyleSettings
        val rootBlock: Block

        val node: ASTNode = if (file is AntlersFile) file.node else context.node

        if (node.elementType == OUTER_ANTLERS) {
            // If we're looking at a AntlersCustomElementTypes.OUTER_ANTLERS element, then we've been invoked by our templated
            // language. Make a dummy block to allow that formatter to continue.
            return SimpleTemplateLanguageFormattingModelBuilder().createModel(context)
        } else {
            rootBlock = getRootBlock(file, file.viewProvider, settings)
        }

        return DocumentBasedFormattingModel(rootBlock, settings, file)
    }

    override fun createTemplateLanguageBlock(
        node: ASTNode,
        wrap: Wrap?,
        alignment: Alignment?,
        foreignChildren: MutableList<DataLanguageBlockWrapper>?,
        settings: CodeStyleSettings
    ): TemplateLanguageBlock {
        val documentModel = FormattingDocumentModelImpl.createOn(node.psi.containingFile)
        val policy = HtmlPolicy(settings, documentModel)
        val block: TemplateLanguageBlock
        val elementType = node.elementType
        val context = AntlersBlockContext(settings)

        block = if (AntlersTokenSets.NODES.contains(elementType)) {
            AntlersNodeBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy, createSpacingBuilder(settings))
        } else if (AntlersTokenSets.CONDITIONAL_BLOCKS.contains(elementType)) {
            AntlersConditionalBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy, createSpacingBuilder(settings))
        } else if (elementType === AntlersTypes.COMMENT_BLOCK) {
            AntlersCommentBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy, createSpacingBuilder(settings))
        } else if (elementType === AntlersTypes.SWITCH_CASE || elementType === AntlersTypes.DEFAULT_CASE) {
            AntlersSwitchCaseBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy, createSpacingBuilder(settings))
        } else if (elementType === AntlersTypes.SWITCH_CLOSE) {
            AntlersSwitchCloseBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy, createSpacingBuilder(settings))
        } else {
            AntlersBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy, createSpacingBuilder(settings))
        }

        return block
    }

    /**
     * If the user uses Prettier to format the code, we do NOT format the code.
     */
    override fun dontFormatMyModel(): Boolean {
        if (myFile !== null) {
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

                .aroundInside(ASSIGNMENT_OPERATORS, AntlersTypes.EXPR)
                .spaceIf(commonSettings.SPACE_AROUND_ASSIGNMENT_OPERATORS)

                .aroundInside(ASSIGNMENT_OPERATORS, AntlersTypes.VARIABLE_ASSIGNMENT_NODE)
                .spaceIf(commonSettings.SPACE_AROUND_ASSIGNMENT_OPERATORS)


        }
    }
}
