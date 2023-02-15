package de.arrobait.antlers.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.AntlersLanguage;
import org.eclipse.sisu.Nullable;
import org.jetbrains.annotations.NotNull;

import static de.arrobait.antlers.psi.AntlersTypes.OUTER_CONTENT;
import static de.arrobait.antlers.psi.AntlersTypes.TAG_ATTRIBUTE_ASSIGNMENT;

/**
 * Various helper methods for working with PSI of Antlers language
 */
public final class AntlersPsiUtil {
    private AntlersPsiUtil() {
        // empty
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

    public static boolean isNonRootStatementsElement(PsiElement element) {
        PsiElement tinesParent = PsiTreeUtil.findFirstParent(element, true, element1 -> element1 instanceof AntlersTines);

        // we're a non-root statements if we're of type AntlersTine, and we have a Tines parent
        boolean isNonRootElement = element instanceof AntlersTines && tinesParent != null;

        return isNonRootElement;
    }

    /**
     * Check that element type of the given AST node belongs to the token set
     */
    public static boolean hasElementType(@NotNull ASTNode node, @NotNull TokenSet set) {
        return set.contains(node.getElementType());
    }

    public static boolean hasElementType(@NotNull ASTNode node, IElementType... types) {
        return hasElementType(node, TokenSet.create(types));
    }

    public static boolean hasElementType(@NotNull PsiElement element, @NotNull TokenSet set) {
        return element.getNode() != null && hasElementType(element.getNode(), set);
    }

    public static boolean hasElementType(@NotNull PsiElement element, IElementType... types) {
        return element.getNode() != null && hasElementType(element.getNode(), types);
    }

    /**
     * Used to determine if an element is part of an "open node" (i.e. "{{ if }}")
     * <p/>
     * If the given element is the descendant of an {@link AntlersBlockOpenNode}, this method returns the parent.
     * <p/>
     * Otherwise, returns null
     *
     * @param element The element whose ancestors will be searched
     * @return An ancestor of type {@link AntlersBlockOpenNode} or null if none exists
     */
    public static AntlersBlockOpenNode findParentOpenNodeElement(PsiElement element) {
        return (AntlersBlockOpenNode) PsiTreeUtil.findFirstParent(element, true, element1 -> element1 instanceof AntlersBlockOpenNode);
    }

    /**
     * Used to determine if an element is part of a "close node" (i.e. "{{ /if }}")
     * <p/>
     * If the given element is the descendant of an {@link AntlersBlockCloseNode}, this method returns the parent.
     * <p/>
     * Otherwise, returns null
     *
     * @param element The element whose ancestors will be searched
     * @return An ancestor of type {@link AntlersBlockCloseNode} or null if none exists
     */
    public static AntlersBlockCloseNode findParentCloseNodeElement(PsiElement element) {
        return (AntlersBlockCloseNode) PsiTreeUtil.findFirstParent(element, true, element1 -> element1 instanceof AntlersBlockCloseNode);
    }

    public static AntlersNodeCloser findNodeCloserElement(PsiElement element) {
        return (AntlersNodeCloser) PsiTreeUtil.findFirstParent(element, true, element1 -> element1 instanceof AntlersNodeCloser);
    }

    public static boolean insideAntlersNode(int offset, FileViewProvider provider) {
        PsiElement elementAtCaret = provider.findElementAt(offset - 1, AntlersLanguage.class);
        assert elementAtCaret != null;
        return elementAtCaret.getNode().getElementType() != OUTER_CONTENT;
    }


    public static boolean isAttributeElement(final IElementType element) {
        return element == TAG_ATTRIBUTE_ASSIGNMENT;
    }
}
