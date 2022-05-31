package de.arrobait.antlers.editor;

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;
import de.arrobait.antlers.psi.AntlersTokenSets;

public class AntlersQuoteHandler extends SimpleTokenSetQuoteHandler {
    public AntlersQuoteHandler() {
        super(AntlersTokenSets.STRINGS);
    }
}
