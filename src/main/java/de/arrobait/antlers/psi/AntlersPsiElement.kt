package de.arrobait.antlers.psi

import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement

interface AntlersPsiElement : PsiElement, NavigatablePsiElement {
    override fun getName(): String?
}
