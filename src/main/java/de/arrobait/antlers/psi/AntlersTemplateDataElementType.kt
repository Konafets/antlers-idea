package de.arrobait.antlers.psi

import com.intellij.lang.Language
import com.intellij.psi.templateLanguages.TemplateDataElementType
import com.intellij.psi.tree.IElementType
import org.jetbrains.annotations.NonNls

class AntlersTemplateDataElementType(
    debugName: @NonNls String?,
    language: Language?,
    templateElementType: IElementType,
    outerElementType: IElementType
) : TemplateDataElementType(debugName, language, templateElementType, outerElementType) {

}
