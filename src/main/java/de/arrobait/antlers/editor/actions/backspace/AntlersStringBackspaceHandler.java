package de.arrobait.antlers.editor.actions.backspace;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import de.arrobait.antlers.psi.impl.AntlersStringLiteralImpl;

public class AntlersStringBackspaceHandler extends AbstractBackspaceHandler {
    public AntlersStringBackspaceHandler(char quoteChar) {
        super(quoteChar, quoteChar);
    }

    @Override
    public boolean shouldBeDeleted(PsiFile file, int offset) {
        PsiElement currentElement = file.findElementAt(offset);
        if (currentElement == null) {
            return false;
        }

        return currentElement.getParent() instanceof AntlersStringLiteralImpl;
    }
}
