package de.arrobait.antlers.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner

interface AntlersNamedElement : AntlersPsiElement, PsiNameIdentifierOwner {
    override fun getName(): String

    fun getId(): PsiElement?
}
