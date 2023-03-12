package de.arrobait.antlers.editor.actions.backspace;

import com.intellij.codeInsight.editorActions.BackspaceHandlerDelegate;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import de.arrobait.antlers.file.AntlersFileType;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractBackspaceHandler extends BackspaceHandlerDelegate {
    char expectedDeletedChar;
    char expectedNextChar;

    public AbstractBackspaceHandler(char expectedDeletedChar, char expectedNextChar) {
        this.expectedDeletedChar = expectedDeletedChar;
        this.expectedNextChar = expectedNextChar;
    }

    @Override
    public void beforeCharDeleted(char c, @NotNull PsiFile file, @NotNull Editor editor) {
        // nothing here
    }

    @Override
    public boolean charDeleted(char c, @NotNull PsiFile file, @NotNull Editor editor) {
        if (c != expectedDeletedChar) {
            return false;
        }
        if (file.getFileType() != AntlersFileType.Companion.getINSTANCE()) {
            return false;
        }

        Document document = editor.getDocument();
        int offset = editor.getCaretModel().getOffset();
        if (offset < 1 || offset >= document.getTextLength()) {
            return false;
        }

        char nextChar = document.getCharsSequence().charAt(offset);

        if (nextChar == expectedNextChar && shouldBeDeleted(file, offset)) {
            document.deleteString(offset, offset + 1);
            return true;
        } else {
            return false;
        }
    }

    public abstract boolean shouldBeDeleted(PsiFile file, int offset);
}
