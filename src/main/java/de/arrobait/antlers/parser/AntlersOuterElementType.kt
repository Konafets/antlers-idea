package de.arrobait.antlers.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.Language
import com.intellij.psi.templateLanguages.OuterLanguageElementImpl
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.ILeafElementType
import de.arrobait.antlers.AntlersLanguage

class AntlersOuterElementType(
    debugName: String,
    language: Language?,
): IElementType(debugName, language), ILeafElementType {
    constructor(debugName: String) : this(debugName, AntlersLanguage.INSTANCE)

    override fun createLeafNode(leafText: CharSequence): ASTNode {
        return OuterLanguageElementImpl(this, leafText)
    }
}
