package de.arrobait.antlers.editor

import com.intellij.codeInsight.template.CustomTemplateCallback
import com.intellij.codeInsight.template.emmet.generators.XmlZenCodingGeneratorImpl
import com.intellij.lang.Language
import com.intellij.lang.xml.XMLLanguage
import de.arrobait.antlers.psi.AntlersFile

class AntlersHtmlZenCodingGenerator : XmlZenCodingGeneratorImpl() {
    override fun isMyContext(callback: CustomTemplateCallback, wrapping: Boolean): Boolean {
        return callback.context.containingFile is AntlersFile
    }

    override fun isMyLanguage(language: Language): Boolean {
        return language.isKindOf(XMLLanguage.INSTANCE)
    }

    override fun isHtml(callback: CustomTemplateCallback): Boolean {
        return true
    }
}
