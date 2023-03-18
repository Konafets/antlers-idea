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
            AntlersNodeBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy)
        } else if (AntlersTokenSets.CONDITIONAL_BLOCKS.contains(elementType)) {
            AntlersConditionalBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy)
        } else if (elementType === AntlersTypes.COMMENT_BLOCK) {
            AntlersCommentBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy)
        } else {
            AntlersBlock(node, wrap, alignment, this, settings, foreignChildren, context, policy)
        }

        return block
    }

    /**
         * This is double negation. So, two "no" means "yes".
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
}
