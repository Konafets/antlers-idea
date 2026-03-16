package de.arrobait.antlers.psi

import com.intellij.psi.tree.IElementType
import de.arrobait.antlers.AntlersLanguage
import org.jetbrains.annotations.NonNls

class AntlersElementType(debugName: @NonNls String) : IElementType(debugName, AntlersLanguage.INSTANCE)
