package de.arrobait.antlers.psi.impl

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import de.arrobait.antlers.psi.AntlersNamedElement
import de.arrobait.antlers.psi.AntlersTypes
import org.apache.commons.lang.StringUtils

open class AntlersNamedElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), AntlersNamedElement {
    override fun getName(): String {
        return stripAntlersDelimiters(text)
    }

    override fun getId(): PsiElement? {
        return findChildByType(AntlersTypes.T_IDENTIFIER)
    }

    override fun setName(name: String): PsiElement {
        return this
    }

    override fun getNameIdentifier(): PsiElement? {
        return getId()
    }

    private fun stripAntlersDelimiters(text: String): String {
        if (text.isNotEmpty()) {
            val firstChars = StringUtils.left(text, 3)
            val lastChars = StringUtils.right(text, 3)
            if (firstChars == "{{ " && lastChars == " }}") {
                return text.substring(3, text.length - 3)
            }
        }

        return text
    }
}
