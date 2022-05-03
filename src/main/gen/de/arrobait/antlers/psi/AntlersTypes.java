// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.arrobait.antlers.psi.impl.*;

public interface AntlersTypes {

  IElementType COMMENT_BLOCK = new AntlersElementType("COMMENT_BLOCK");

  IElementType OUTER_CONTENT = new AntlersTokenType("OUTER_CONTENT");
  IElementType T_COMMENT_CLOSE = new AntlersTokenType("#}}");
  IElementType T_COMMENT_OPEN = new AntlersTokenType("{{#");
  IElementType T_COMMENT_TEXT = new AntlersTokenType("T_COMMENT_TEXT");
  IElementType T_LD = new AntlersTokenType("{{");
  IElementType T_RD = new AntlersTokenType("}}");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMENT_BLOCK) {
        return new AntlersCommentBlockImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
