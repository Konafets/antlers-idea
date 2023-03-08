package de.arrobait.antlers.editor.structure

import com.intellij.ide.structureView.StructureViewModel
import com.intellij.ide.structureView.StructureViewModelBase
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiFile
import de.arrobait.antlers.psi.AntlersBlockWrapper
import de.arrobait.antlers.psi.AntlersCommentBlock
import de.arrobait.antlers.psi.AntlersFile
import de.arrobait.antlers.psi.AntlersIfStatement
import de.arrobait.antlers.psi.AntlersNoparseRegion
import de.arrobait.antlers.psi.AntlersPhpEchoNode
import de.arrobait.antlers.psi.AntlersPhpRawNode
import de.arrobait.antlers.psi.AntlersRecursiveChildrenNode
import de.arrobait.antlers.psi.AntlersSwitchNode
import de.arrobait.antlers.psi.AntlersTagPair
import de.arrobait.antlers.psi.AntlersTagSingle
import de.arrobait.antlers.psi.AntlersTine
import de.arrobait.antlers.psi.AntlersUnlessStatement
import de.arrobait.antlers.psi.AntlersVariableAssignmentNode

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
