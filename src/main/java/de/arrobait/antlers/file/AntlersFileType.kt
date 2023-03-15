package de.arrobait.antlers.file

import com.intellij.ide.highlighter.XmlLikeFileType
import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.CharsetUtil
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.fileTypes.TemplateLanguageFileType
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings
import de.arrobait.antlers.AntlersLanguage
import java.nio.charset.Charset

class AntlersFileType(language: Language) : XmlLikeFileType(language), TemplateLanguageFileType {
    constructor() : this(AntlersLanguage.INSTANCE)
    companion object {
        @JvmStatic
        val DOT_DEFAULT_EXTENSION = ".antlers.html"

        @JvmStatic
        val INSTANCE: LanguageFileType = AntlersFileType()

        @JvmStatic
        val DEFAULT_EXTENSION = "antlers.html"

        @JvmStatic
        private fun getAssociatedFileType(project: Project?, file: VirtualFile?): LanguageFileType? {
            if (project == null) return null

            val language: Language? = TemplateDataLanguageMappings.getInstance(project).getMapping(file)

            var associatedFileType: LanguageFileType? = null

            if (language != null) {
                associatedFileType = language.associatedFileType
            }

            if (language == null || associatedFileType == null) {
                associatedFileType = AntlersLanguage.getDefaultTemplateLang()
            }

            return associatedFileType
        }
    }

    override fun getName() = "Antlers"

    override fun getDescription() = "Antlers template file"

    override fun getDefaultExtension() = DEFAULT_EXTENSION

    override fun getIcon() = AntlersIcons.FILE

    override fun extractCharsetFromFileContent(project: Project?, file: VirtualFile?, content: CharSequence): Charset? {
        val associatedFileType: LanguageFileType = getAssociatedFileType(project, file) ?: return null

        return CharsetUtil.extractCharsetFromFileContent(project, file, associatedFileType, content)
    }
}
