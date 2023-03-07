package de.arrobait.antlers.editor.structure

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import de.arrobait.antlers.psi.AntlersBlockWrapper
import de.arrobait.antlers.psi.AntlersFile
import de.arrobait.antlers.psi.AntlersTine

class AntlersStructureViewModel(psiFile: PsiFile, editor: Editor?) : StructureViewModelBase(psiFile, editor, AntlersStructureViewFile(psiFile as AntlersFile)), StructureViewModel.ElementInfoProvider {
    companion object {
        val ourSuitableClasses: Array<Class<*>> = arrayOf(
            AntlersFile::class.java,
            AntlersBlockWrapper::class.java,
            AntlersTine::class.java
        )
    }

    override fun getSuitableClasses(): Array<Class<*>> = ourSuitableClasses

    override fun getSorters(): Array<Sorter> {
        return arrayOf(Sorter.ALPHA_SORTER)
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
        return element?.value is AntlersTine
    }
}
