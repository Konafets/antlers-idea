package de.arrobait.antlers.psi.mixins

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiComment
import com.intellij.psi.tree.IElementType

abstract class AntlersCommentMixin(node: ASTNode) : ASTWrapperPsiElement(node), PsiComment {
    override fun getTokenType(): IElementType {
        return node.elementType
    }
}
