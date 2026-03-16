package de.arrobait.antlers.file

import com.intellij.lang.Language
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.FileViewProvider
import com.intellij.psi.FileViewProviderFactory
import com.intellij.psi.PsiManager
import de.arrobait.antlers.AntlersLanguage

class AntlersFileViewProviderFactory: FileViewProviderFactory {
    override fun createFileViewProvider(
        file: VirtualFile,
        language: Language?,
        manager: PsiManager,
        eventSystemEnabled: Boolean
    ): FileViewProvider {
        assert(language!!.isKindOf(AntlersLanguage.INSTANCE))
        return AntlersFileViewProvider(manager, file, eventSystemEnabled, language)
    }
}
