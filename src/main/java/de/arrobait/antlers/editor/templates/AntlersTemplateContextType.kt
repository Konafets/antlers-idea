package de.arrobait.antlers.editor.templates

import com.intellij.codeInsight.template.TemplateActionContext
import com.intellij.codeInsight.template.TemplateContextType
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import de.arrobait.antlers.AntlersLanguage
import de.arrobait.antlers.highlighter.AntlersSyntaxHighlighter

class AntlersTemplateContextType : TemplateContextType("ANTLERS", "Antlers") {
    override fun isInContext(templateActionContext: TemplateActionContext): Boolean {
        return AntlersLanguage.INSTANCE.`is`(templateActionContext.file.language)
    }

    override fun createHighlighter(): SyntaxHighlighter {
        return AntlersSyntaxHighlighter()
    }
}
