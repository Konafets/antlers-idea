package de.arrobait.antlers.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.Nullable;

public class AntlersPsiUtil {

    public static AntlersConditionalStart findParentOpenTagElement(PsiElement element) {
        return (AntlersConditionalStart) PsiTreeUtil.findFirstParent(element, true, element1 -> element1 instanceof AntlersConditionalStart);
    }

    public static AntlersConditionalEnd findParentCloseTagElement(PsiElement element) {
        return (AntlersConditionalEnd) PsiTreeUtil.findFirstParent(element, true, element1 -> element1 instanceof AntlersConditionalEnd);
    }

    /**
     * Tests to see if the given element is not the "root" statements expression of the grammar
     */
    public static boolean isNonRootStatementsElement(PsiElement element) {
        PsiElement tinesParent = PsiTreeUtil.findFirstParent(element, true, element1 -> element1 instanceof AntlersTines);

        // we're a non-root statements if we're of type statements, and we have a statements parent
        // we are a non-root statements if we are of type nodes, and we have a statements parent
        boolean isNonRootElement = element instanceof AntlersTines && tinesParent != null;

        return isNonRootElement;
    }

    public static ASTNode getPrevSiblingSkipWhiteSpacesAndComments(@Nullable ASTNode sibling) {
        if (sibling == null) {
            return null;
        }

        ASTNode result = sibling.getTreePrev();
        while (result != null && isWhitespaceOrComment(result.getPsi())) {
            result = result.getTreePrev();
        }

        return result;
    }

    private static boolean isWhitespaceOrComment(PsiElement element) {
        return element instanceof PsiWhiteSpace || element instanceof PsiComment;
    }
}
