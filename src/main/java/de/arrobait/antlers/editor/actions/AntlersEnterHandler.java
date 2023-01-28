package de.arrobait.antlers.editor.actions;

import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegateAdapter;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.editor.highlighter.HighlighterIterator;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import de.arrobait.antlers.psi.AntlersFile;
import de.arrobait.antlers.psi.AntlersPsiUtil;
import org.jetbrains.annotations.NotNull;

public class AntlersEnterHandler extends EnterHandlerDelegateAdapter {
    @Override
    public Result preprocessEnter(@NotNull PsiFile file,
                                  @NotNull Editor editor,
                                  @NotNull Ref<Integer> caretOffset,
                                  @NotNull Ref<Integer> caretAdvance,
                                  @NotNull DataContext dataContext,
                                  EditorActionHandler originalHandler) {
        /*
         * If we are between open and close nodes, we ensure the caret ends up in the "logical" place on Enter.
         * i.e. "{{ if }}<caret>{{ /if }}" becomes the following on Enter:
         *
         * {{#foo}}
         * <caret>
         * {{/foo}}
         *
         * (Note: <caret> me be indented depending on formatter settings.)
         */
        if (file instanceof AntlersFile && isBetweenAntlersNodes(editor, file, caretOffset.get())) {
            originalHandler.execute(editor, editor.getCaretModel().getCurrentCaret(), dataContext);
            return Result.Default;
        }
        return Result.Continue;
    }

    private boolean isBetweenAntlersNodes(Editor editor, PsiFile file, Integer offset) {
        if (offset == 0) {
            return false;
        }
        CharSequence charSequence = editor.getDocument().getImmutableCharSequence();
        if (charSequence.charAt(offset - 1) != '}') {
            return false;
        }

        EditorHighlighter highlighter = editor.getHighlighter();
        HighlighterIterator iterator = highlighter.createIterator(offset - 1);

        PsiDocumentManager.getInstance(file.getProject()).commitDocument(editor.getDocument());
        final PsiElement openerElement = file.findElementAt(iterator.getStart());

        PsiElement openNode = AntlersPsiUtil.findParentOpenNodeElement(openerElement);

        if (openNode == null) {
            return false;
        }

        iterator.advance();

        if (iterator.atEnd()) {
            // no more tokens, so certainly no close tag
            return false;
        }

        final PsiElement closerElement = file.findElementAt(iterator.getStart());
        PsiElement closeNode = AntlersPsiUtil.findParentCloseNodeElement(closerElement);

        // if we got this far, we're between open and close tags if this is a close tag
        return closeNode != null;
    }
}
