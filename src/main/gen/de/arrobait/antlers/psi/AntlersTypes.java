// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.arrobait.antlers.psi.impl.*;

public interface AntlersTypes {

  IElementType ANTLERS_NODE = new AntlersElementType("ANTLERS_NODE");
  IElementType BOOLEAN_LITERAL = new AntlersElementType("BOOLEAN_LITERAL");
  IElementType COMMENT_BLOCK = new AntlersElementType("COMMENT_BLOCK");
  IElementType EXPR = new AntlersElementType("EXPR");
  IElementType INTERPOLATED_STATEMENT = new AntlersElementType("INTERPOLATED_STATEMENT");
  IElementType LITERAL_EXPR = new AntlersElementType("LITERAL_EXPR");
  IElementType NUMBER_LITERAL = new AntlersElementType("NUMBER_LITERAL");
  IElementType PHP_ECHO_NODE = new AntlersElementType("PHP_ECHO_NODE");
  IElementType PHP_RAW_NODE = new AntlersElementType("PHP_RAW_NODE");
  IElementType STRING_LITERAL = new AntlersElementType("STRING_LITERAL");
  IElementType SUB_EXPRESSION = new AntlersElementType("SUB_EXPRESSION");
  IElementType VARIABLE = new AntlersElementType("VARIABLE");
  IElementType VARIABLE_ASSIGNMENT_NODE = new AntlersElementType("VARIABLE_ASSIGNMENT_NODE");

  IElementType OUTER_CONTENT = new AntlersTokenType("OUTER_CONTENT");
  IElementType T_COMMENT_CLOSE = new AntlersTokenType("#}}");
  IElementType T_COMMENT_OPEN = new AntlersTokenType("{{#");
  IElementType T_COMMENT_TEXT = new AntlersTokenType("T_COMMENT_TEXT");
  IElementType T_FALSE = new AntlersTokenType("false");
  IElementType T_FLOAT_NUMBER = new AntlersTokenType("T_FLOAT_NUMBER");
  IElementType T_IDENTIFIER = new AntlersTokenType("T_IDENTIFIER");
  IElementType T_INTEGER_NUMBER = new AntlersTokenType("T_INTEGER_NUMBER");
  IElementType T_LD = new AntlersTokenType("{{");
  IElementType T_LEFT_BRACE = new AntlersTokenType("{");
  IElementType T_LP = new AntlersTokenType("(");
  IElementType T_OP_ASSIGN = new AntlersTokenType("=");
  IElementType T_PHP_CONTENT = new AntlersTokenType("T_PHP_CONTENT");
  IElementType T_PHP_ECHO_CLOSE = new AntlersTokenType("$}}");
  IElementType T_PHP_ECHO_OPEN = new AntlersTokenType("{{$");
  IElementType T_PHP_RAW_CLOSE = new AntlersTokenType("?}}");
  IElementType T_PHP_RAW_OPEN = new AntlersTokenType("{{?");
  IElementType T_RD = new AntlersTokenType("}}");
  IElementType T_RIGHT_BRACE = new AntlersTokenType("}");
  IElementType T_RP = new AntlersTokenType(")");
  IElementType T_STRING_CONTENT = new AntlersTokenType("T_STRING_CONTENT");
  IElementType T_STRING_END = new AntlersTokenType("T_STRING_END");
  IElementType T_STRING_START = new AntlersTokenType("T_STRING_START");
  IElementType T_TRUE = new AntlersTokenType("true");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ANTLERS_NODE) {
        return new AntlersAntlersNodeImpl(node);
      }
      else if (type == BOOLEAN_LITERAL) {
        return new AntlersBooleanLiteralImpl(node);
      }
      else if (type == COMMENT_BLOCK) {
        return new AntlersCommentBlockImpl(node);
      }
      else if (type == INTERPOLATED_STATEMENT) {
        return new AntlersInterpolatedStatementImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new AntlersLiteralExprImpl(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new AntlersNumberLiteralImpl(node);
      }
      else if (type == PHP_ECHO_NODE) {
        return new AntlersPhpEchoNodeImpl(node);
      }
      else if (type == PHP_RAW_NODE) {
        return new AntlersPhpRawNodeImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new AntlersStringLiteralImpl(node);
      }
      else if (type == SUB_EXPRESSION) {
        return new AntlersSubExpressionImpl(node);
      }
      else if (type == VARIABLE) {
        return new AntlersVariableImpl(node);
      }
      else if (type == VARIABLE_ASSIGNMENT_NODE) {
        return new AntlersVariableAssignmentNodeImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
