package de.arrobait.antlers.psi

import com.intellij.psi.PsiFile

/**
 * An interface representing an Antlers file.
 */
interface AntlersFileInterface {
    fun getContainingFile(): PsiFile

    /**
     * Returns all tines found in this files
     */
    fun getTines(): List<AntlersPsiElement>
}
