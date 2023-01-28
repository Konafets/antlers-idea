package de.arrobait.antlers.editor.actions;

import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.lang.html.HTMLLanguage;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.file.AntlersFileType;
import de.arrobait.antlers.psi.*;
import org.jetbrains.annotations.NotNull;

public class AntlersTypedHandler extends TypedHandlerDelegate {
    private static final Logger LOG = Logger.getInstance(AntlersTypedHandler.class);
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
                    if (file.getLanguage().equals(HTMLLanguage.INSTANCE)
                            || file.getLanguage().equals(AntlersLanguage.INSTANCE)) {
                        editor.getDocument().insertString(offset, "}");
                        editor.getCaretModel().moveToOffset(offset);
                    }
                } else {
                    String previousChars = editor.getDocument().getText(new TextRange(offset - 2, offset));
                    if (file.getLanguage().equals(HTMLLanguage.INSTANCE) && previousChars.equals("{{")) {
                        editor.getDocument().insertString(offset, "  }");
                        editor.getCaretModel().moveToOffset(offset + 1);
                    } else if (file.getLanguage().equals(HTMLLanguage.INSTANCE)
                        || file.getLanguage().equals(AntlersLanguage.INSTANCE)) {
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

//            String previousChars = editor.getDocument().getText(new TextRange(offset - 4, offset - 1)).trim();
//
//            if (c == ' ' && AntlersPsiUtil.insideAntlersNode(offset, provider)) {
//                autoInsertCloseTag(project, offset, editor, provider);
//            } else if (c == '/' && previousChars.equals("{{")) {
//                finishClosingTag(offset, editor, provider);
//            }
        }

        return Result.CONTINUE;
    }

    private void finishClosingTag(int offset, Editor editor, FileViewProvider provider) {
        PsiElement elementAtCaret = provider.findElementAt(offset - 1, AntlersLanguage.class);
        if (elementAtCaret != null) {
            AntlersBlockWrapper block = PsiTreeUtil.getParentOfType(elementAtCaret, AntlersBlockWrapper.class);
            if (block != null) {
                final AntlersBlockOpenNode open = PsiTreeUtil.findChildOfAnyType(block, AntlersBlockOpenNode.class);
                final AntlersBlockCloseNode close = PsiTreeUtil.findChildOfType(block, AntlersBlockCloseNode.class);

                if (open != null && close == null) {
                    final AntlersTag tagHandle = PsiTreeUtil.findChildOfType(open, AntlersTag.class);
                    if (tagHandle != null) {
                        if (offset > 3) {
                            final String prePreviousChar = editor.getDocument().getText(new TextRange(offset - 3, offset - 2));
                            if (prePreviousChar.equals("{")) {
                                editor.getDocument().insertString(offset, tagHandle.getText() + " }}");
                                editor.getCaretModel().moveToOffset(offset + tagHandle.getText().length() + " }}".length());
                            } else {
                                editor.getDocument().replaceString(offset - 1, offset, "{{ /" + tagHandle.getText() + " }}");
                                editor.getCaretModel().moveToOffset(offset + tagHandle.getText().length() + " }}".length() + 1);
                            }
                        } else {
                            LOG.warn("Unexpected offset inset AntlersBlockWrapper element");
                        }
                    }
                }

            }
        }
    }

    private static void autoInsertCloseTag(Project project, int offset, Editor editor, FileViewProvider provider) {
        PsiDocumentManager.getInstance(project).commitDocument(editor.getDocument());
        PsiElement elementAtCaret = provider.findElementAt(offset - 1, AntlersLanguage.class);

        if (elementAtCaret == null || elementAtCaret.getNode().getElementType() != TokenType.WHITE_SPACE) {
            return;
        }

        AntlersBlockOpenNode openBlock = AntlersPsiUtil.findParentOpenNodeElement(elementAtCaret);

        if (openBlock != null && openBlock.getChildren().length > 0) {
            AntlersConditionalIf conditionalIf = PsiTreeUtil.findChildOfType(openBlock, AntlersConditionalIf.class);

            AntlersNodeCloser nodeCloser = AntlersPsiUtil.findNodeCloserElement(elementAtCaret);
            String foo = nodeCloser.getText();
            String foo2 = nodeCloser.getText();
            if (conditionalIf != null) {
                // insert the corresponding close tag
                editor.getDocument().insertString(offset, "{{ /if }}");
            }
        }
    }
}
