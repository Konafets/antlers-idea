package de.arrobait.antlers.editor.actions;

import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegateAdapter;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.CaretModel;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.util.Ref;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import de.arrobait.antlers.psi.AntlersFile;
import de.arrobait.antlers.psi.AntlersPsiUtil;
import org.jetbrains.annotations.NotNull;

public class AntlersEnterHandler extends EnterHandlerDelegateAdapter {
    @Override
    public Result preprocessEnter(@NotNull PsiFile file, @NotNull Editor editor, @NotNull Ref<Integer> caretOffset, @NotNull Ref<Integer> caretAdvance, @NotNull DataContext dataContext, EditorActionHandler originalHandler) {
        /*
         * if we are between open and close tags, we ensure that the caret ends up in the "logical" place on Enter.
         * i.e. "{{ if foo }}<caret>{{ /if }}" becomes the following on Enter:
         *
         * {{ if foo }}
         *     <caret>
         * {{ /if }}
         */
        if (file instanceof AntlersFile
                && (isBetweenAntlersTines(editor, file, caretOffset.get()))) {
            originalHandler.execute(editor, editor.getCaretModel().getCurrentCaret(), dataContext);

            return Result.Default;
        }

        return Result.Continue;
    }

    private boolean isInsideSwitchBody(Editor editor, PsiFile file, int offset) {
        if (offset == 0) {
            return false;
        }

        String previousChars = editor.getDocument().getText(new TextRange(offset - 7, offset));

        return previousChars.equals("switch(");
    }

    private static boolean isBetweenAntlersTines(Editor editor, PsiFile file, int offset) {
        if (offset == 0) {
            return false;
        }

        CharSequence chars = editor.getDocument().getCharsSequence();
        if (chars.charAt(offset - 1) != '}') {
            return false;
        }

        EditorHighlighter highlighter = editor.getHighlighter();
        HighlighterIterator iterator = highlighter.createIterator(offset - 1);

        PsiDocumentManager.getInstance(file.getProject()).commitDocument(editor.getDocument());
        final PsiElement openerElement = file.findElementAt(iterator.getStart());

        PsiElement openTine = AntlersPsiUtil.findParentOpenTagElement(openerElement);

        if (openTine == null) {
            return false;
        }

        iterator.advance();

        if (iterator.atEnd()) {
            return false;
        }

        final PsiElement closerElement = file.findElementAt(iterator.getStart());
        PsiElement closeTine = AntlersPsiUtil.findParentCloseTagElement(closerElement);

        return closeTine != null;
    }
}
