package de.arrobait.antlers.editor.structure

import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase
import com.intellij.navigation.ItemPresentation
import de.arrobait.antlers.file.AntlersIcons
import de.arrobait.antlers.psi.AntlersFile
import javax.swing.Icon

class AntlersStructureViewFile(myFile: AntlersFile) : PsiTreeElementBase<AntlersFile>(myFile) {
    override fun getChildrenBase(): Collection<StructureViewTreeElement> {
        return AntlersTreeElement.getStructuredViewTreeElements(element)
    }

    override fun getPresentableText(): String? = getFilePresentation()?.presentableText

    private fun getFilePresentation(): ItemPresentation? {
        val file: AntlersFile? = element
        return file?.presentation
    }

    override fun getIcon(open: Boolean): Icon {
        return AntlersIcons.FILE
    }
}
