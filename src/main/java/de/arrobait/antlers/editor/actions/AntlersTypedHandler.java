package de.arrobait.antlers.editor.actions;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.lang.html.HTMLLanguage;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.file.AntlersFileType;
import org.jetbrains.annotations.NotNull;

public class AntlersTypedHandler extends TypedHandlerDelegate {
    @NotNull
    @Override
    public Result charTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        int offset = editor.getCaretModel().getOffset();
        FileViewProvider provider = file.getViewProvider();

        if (!provider.getBaseLanguage().isKindOf(AntlersLanguage.INSTANCE)) {
            return Result.CONTINUE;
        }

        if (offset < 1 || offset > editor.getDocument().getTextLength()) {
            return Result.CONTINUE;
        }

        // TODO: Add the *.antlers.php extension here
        if (file.getName().endsWith(AntlersFileType.DEFAULT_EXTENSION)) {
            if (c == '{') {
                PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());

                if (offset < 2 || offset > editor.getDocument().getTextLength()) {
                    if (file.getLanguage().equals(HTMLLanguage.INSTANCE)) {
                        editor.getDocument().insertString(offset, "}");
                        editor.getCaretModel().moveToOffset(offset);
                    } else if (file.getLanguage().equals(AntlersLanguage.INSTANCE)) {
                        // TODO: That is the same like in the if branch.
                        editor.getDocument().insertString(offset, "}");
                        editor.getCaretModel().moveToOffset(offset);
                    }
                } else {
                    String previousChars = editor.getDocument().getText(new TextRange(offset - 2, offset));
                    if (file.getLanguage().equals(HTMLLanguage.INSTANCE) && previousChars.equals("{{")) {
                        editor.getDocument().insertString(offset, "  }");
                        editor.getCaretModel().moveToOffset(offset + 1);
                    } else if (file.getLanguage().equals(HTMLLanguage.INSTANCE)) {
                        editor.getDocument().insertString(offset, "}");
                        editor.getCaretModel().moveToOffset(offset);
                    } else if (file.getLanguage().equals(AntlersLanguage.INSTANCE)) {
                        // TODO: That is the same like in the else if branch
                        editor.getDocument().insertString(offset, "}");
                        editor.getCaretModel().moveToOffset(offset);
                    }
                }
            }

            if (c == '(') {
                editor.getDocument().insertString(offset, ")");
                editor.getCaretModel().moveToOffset(offset);
            }

            if (c == '[') {
                editor.getDocument().insertString(offset, "]");
                editor.getCaretModel().moveToOffset(offset);
            }
        }

        return Result.CONTINUE;
    }
//
//    @Override
//    public @NotNull Result beforeCharTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file, @NotNull FileType fileType) {
//        int offset = editor.getCaretModel().getOffset();
//
//        if (offset == 0 || offset > editor.getDocument().getTextLength()) {
//            return Result.CONTINUE;
//        }
//
//        String previousChar = editor.getDocument().getText(new TextRange(offset - 1, offset));
//
//        if (file.getLanguage().equals(AntlersLanguage.INSTANCE)) {
//            PsiDocumentManager.getInstance(project).commitAllDocuments();
//
//            // we suppress the built-in `}` auto-complete when we see `{{`
//            if (c == '{' && previousChar.equals("{")) {
//                // since the `}` autocomplete is built in to IDEA, we need to hack around it a bit by
//                // intercepting it before it is inserted, doing the work of inserting for the user
//                // by inserting the `{` the user just typed ...
//                editor.getDocument().insertString(offset, c  + "  }");
//                // ... and position their caret after it as they would expect ...
//                editor.getCaretModel().moveToOffset(offset + 2);
//
//                // ... then finally telling subsequent responses to this char typed to do nothing
//                return Result.STOP;
//            }
//        }
//
//        return Result.CONTINUE;
//    }
}
