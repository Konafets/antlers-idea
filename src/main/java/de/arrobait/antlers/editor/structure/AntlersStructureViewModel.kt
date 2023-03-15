package de.arrobait.antlers.editor.structure

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import de.arrobait.antlers.psi.*

class AntlersStructureViewModel(psiFile: PsiFile, editor: Editor?) : StructureViewModelBase(psiFile, editor, AntlersStructureViewFile(psiFile as AntlersFile)), StructureViewModel.ElementInfoProvider {
    companion object {
        val ourSuitableClasses: Array<Class<*>> = arrayOf(
            AntlersBlockWrapper::class.java,
            AntlersIfStatement::class.java,
            AntlersUnlessStatement::class.java,
            AntlersFile::class.java,
            AntlersSwitchNode::class.java,
            AntlersTagSingle::class.java,
            AntlersTagPair::class.java,
            AntlersTine::class.java,
            AntlersVariableAssignmentNode::class.java,
            AntlersNoparseRegion::class.java,
            AntlersRecursiveChildrenNode::class.java,
            AntlersCommentBlock::class.java,
            AntlersPhpEchoNode::class.java,
            AntlersPhpRawNode::class.java,
        )
    }

    override fun getSuitableClasses(): Array<Class<*>> = ourSuitableClasses

    override fun getSorters(): Array<Sorter> {
        return arrayOf(Sorter.ALPHA_SORTER)
    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
        return element?.value is AntlersFile
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
        return element?.value is AntlersTine
    }
}
