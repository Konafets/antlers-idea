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

        if (file.getName().endsWith(AntlersFileType.DEFAULT_EXTENSION)) {
            if (c == '{') {
                PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());

                if (offset < 2 || offset > editor.getDocument().getTextLength()) {
                    if (file.getLanguage().equals(HTMLLanguage.INSTANCE)) {
                        editor.getDocument().insertString(offset, "}");
                        editor.getCaretModel().moveToOffset(offset);
                    } else if (file.getLanguage().equals(AntlersLanguage.INSTANCE)) {
                        editor.getDocument().insertString(offset, "}");
                        editor.getCaretModel().moveToOffset(offset);
                    }
                } else if (offset >= 2 || offset > editor.getDocument().getTextLength()) {
                    String previousChars = editor.getDocument().getText(new TextRange(offset - 2, offset));
                    if (file.getLanguage().equals(HTMLLanguage.INSTANCE) && previousChars.equals("{{")) {
                        editor.getDocument().insertString(offset, "  }");
                        editor.getCaretModel().moveToOffset(offset + 1);
                    } else if (file.getLanguage().equals(HTMLLanguage.INSTANCE)) {
                        editor.getDocument().insertString(offset, "}");
                        editor.getCaretModel().moveToOffset(offset);
                    } else if (file.getLanguage().equals(AntlersLanguage.INSTANCE)) {
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
}
