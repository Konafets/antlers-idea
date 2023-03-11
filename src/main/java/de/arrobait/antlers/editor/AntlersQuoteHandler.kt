package de.arrobait.antlers.editor

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler
import de.arrobait.antlers.psi.AntlersTokenSets

class AntlersQuoteHandler : SimpleTokenSetQuoteHandler(AntlersTokenSets.STRINGS)
