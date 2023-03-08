package de.arrobait.antlers.editor.structure

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.util.ReflectionUtil
import de.arrobait.antlers.psi.AntlersPsiElement
import de.arrobait.antlers.psi.AntlersTine

class AntlersStructuredViewElement(private val element: NavigatablePsiElement) : PsiTreeElementBase<NavigatablePsiElement>(element) {
    companion object {
        fun getStructuredViewTreeElements(psiElement: NavigatablePsiElement): MutableList<StructureViewTreeElement> {
            val children: MutableList<StructureViewTreeElement> = arrayListOf()
            for (childElement: PsiElement in psiElement.children) {
                if (childElement !is AntlersPsiElement) {
                    continue
                }

                if (childElement is AntlersTine) {
                    children.addAll(
                        AntlersStructuredViewElement(childElement as AntlersPsiElement).childrenBase
                    )
                }

                for (suitableClass in AntlersStructureViewModel.ourSuitableClasses) {
                    if (ReflectionUtil.isAssignable(suitableClass, childElement.javaClass)) {
                        children.add(AntlersStructuredViewElement(childElement))
                        break
                    }
                }
            }

            return children
        }
    }

    override fun getChildrenBase(): MutableCollection<StructureViewTreeElement> {
        return getStructuredViewTreeElements(element)
    }

    override fun getPresentableText(): String? = element.name

    override fun getPresentation(): ItemPresentation {
        return element.presentation ?: PresentationData()
    }

    override fun navigate(requestFocus: Boolean) = element.navigate(requestFocus)

    override fun canNavigate(): Boolean = element.canNavigate()

    override fun canNavigateToSource(): Boolean = element.canNavigateToSource()
}
