// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.arrobait.antlers.psi.impl.*;

public interface AntlersTypes {

  IElementType COMMENT_BLOCK = new AntlersElementType("COMMENT_BLOCK");
  IElementType PHP_ECHO_NODE = new AntlersElementType("PHP_ECHO_NODE");
  IElementType PHP_RAW_NODE = new AntlersElementType("PHP_RAW_NODE");

  IElementType OUTER_CONTENT = new AntlersTokenType("OUTER_CONTENT");
  IElementType T_COMMENT_CLOSE = new AntlersTokenType("#}}");
  IElementType T_COMMENT_OPEN = new AntlersTokenType("{{#");
  IElementType T_COMMENT_TEXT = new AntlersTokenType("T_COMMENT_TEXT");
  IElementType T_LD = new AntlersTokenType("{{");
  IElementType T_PHP_CONTENT = new AntlersTokenType("T_PHP_CONTENT");
  IElementType T_PHP_ECHO_CLOSE = new AntlersTokenType("$}}");
  IElementType T_PHP_ECHO_OPEN = new AntlersTokenType("{{$");
  IElementType T_PHP_RAW_CLOSE = new AntlersTokenType("?}}");
  IElementType T_PHP_RAW_OPEN = new AntlersTokenType("{{?");
  IElementType T_RD = new AntlersTokenType("}}");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMENT_BLOCK) {
        return new AntlersCommentBlockImpl(node);
      }
      else if (type == PHP_ECHO_NODE) {
        return new AntlersPhpEchoNodeImpl(node);
      }
      else if (type == PHP_RAW_NODE) {
        return new AntlersPhpRawNodeImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
