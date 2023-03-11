package de.arrobait.antlers.file

import com.intellij.lang.Language
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.LanguageSubstitutor
import com.intellij.testFramework.LightVirtualFile
import de.arrobait.antlers.AntlersLanguage
import de.arrobait.antlers.extensions.isAntlersFile

class AntlersLanguageSubstitutor : LanguageSubstitutor() {
    override fun getLanguage(file: VirtualFile, project: Project): Language? {
        if (file is LightVirtualFile) return null

        return if (file.isAntlersFile()) AntlersLanguage.INSTANCE else null
    }
}
