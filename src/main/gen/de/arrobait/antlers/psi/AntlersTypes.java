// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.arrobait.antlers.psi.impl.*;

public interface AntlersTypes {

  IElementType ADD_EXPR = new AntlersElementType("ADD_EXPR");
  IElementType ANTLERS_NODE = new AntlersElementType("ANTLERS_NODE");
  IElementType ARRAY = new AntlersElementType("ARRAY");
  IElementType BOOLEAN_LITERAL = new AntlersElementType("BOOLEAN_LITERAL");
  IElementType BRACKET_PROPERTY_ACCESS = new AntlersElementType("BRACKET_PROPERTY_ACCESS");
  IElementType COLON_PROPERTY_ACCESS = new AntlersElementType("COLON_PROPERTY_ACCESS");
  IElementType COMMENT_BLOCK = new AntlersElementType("COMMENT_BLOCK");
  IElementType CONCAT_EXPR = new AntlersElementType("CONCAT_EXPR");
  IElementType DIV_EXPR = new AntlersElementType("DIV_EXPR");
  IElementType DOT_PROPERTY_ACCESS = new AntlersElementType("DOT_PROPERTY_ACCESS");
  IElementType EXPR = new AntlersElementType("EXPR");
  IElementType INTERPOLATED_STATEMENT = new AntlersElementType("INTERPOLATED_STATEMENT");
  IElementType LITERAL_EXPR = new AntlersElementType("LITERAL_EXPR");
  IElementType MOD_EXPR = new AntlersElementType("MOD_EXPR");
  IElementType MUL_EXPR = new AntlersElementType("MUL_EXPR");
  IElementType NUMBER_LITERAL = new AntlersElementType("NUMBER_LITERAL");
  IElementType PHP_ECHO_NODE = new AntlersElementType("PHP_ECHO_NODE");
  IElementType PHP_RAW_NODE = new AntlersElementType("PHP_RAW_NODE");
  IElementType POW_EXPR = new AntlersElementType("POW_EXPR");
  IElementType STRING_LITERAL = new AntlersElementType("STRING_LITERAL");
  IElementType SUB_EXPR = new AntlersElementType("SUB_EXPR");
  IElementType SUB_EXPRESSION = new AntlersElementType("SUB_EXPRESSION");
  IElementType TENARY_EXPR = new AntlersElementType("TENARY_EXPR");
  IElementType UNARY_FACTORIAL_EXPR = new AntlersElementType("UNARY_FACTORIAL_EXPR");
  IElementType UNARY_MINUS_EXPR = new AntlersElementType("UNARY_MINUS_EXPR");
  IElementType UNARY_NOT_EXPR = new AntlersElementType("UNARY_NOT_EXPR");
  IElementType VARIABLE = new AntlersElementType("VARIABLE");
  IElementType VARIABLE_ASSIGNMENT_NODE = new AntlersElementType("VARIABLE_ASSIGNMENT_NODE");

  IElementType OUTER_CONTENT = new AntlersTokenType("OUTER_CONTENT");
  IElementType T_COLON = new AntlersTokenType(":");
  IElementType T_COMMA = new AntlersTokenType(",");
  IElementType T_COMMENT_CLOSE = new AntlersTokenType("#}}");
  IElementType T_COMMENT_OPEN = new AntlersTokenType("{{#");
  IElementType T_COMMENT_TEXT = new AntlersTokenType("T_COMMENT_TEXT");
  IElementType T_DOT = new AntlersTokenType(".");
  IElementType T_FALSE = new AntlersTokenType("false");
  IElementType T_FLOAT_NUMBER = new AntlersTokenType("T_FLOAT_NUMBER");
  IElementType T_IDENTIFIER = new AntlersTokenType("T_IDENTIFIER");
  IElementType T_INTEGER_NUMBER = new AntlersTokenType("T_INTEGER_NUMBER");
  IElementType T_LD = new AntlersTokenType("{{");
  IElementType T_LEFT_BRACE = new AntlersTokenType("{");
  IElementType T_LEFT_BRACKET = new AntlersTokenType("[");
  IElementType T_LP = new AntlersTokenType("(");
  IElementType T_OP_ASSIGN = new AntlersTokenType("=");
  IElementType T_OP_EXCLAMATION_MARK = new AntlersTokenType("!");
  IElementType T_OP_MINUS = new AntlersTokenType("-");
  IElementType T_OP_MOD = new AntlersTokenType("%");
  IElementType T_OP_MUL = new AntlersTokenType("*");
  IElementType T_OP_PLUS = new AntlersTokenType("+");
  IElementType T_OP_POW = new AntlersTokenType("**");
  IElementType T_OP_QUESTIONMARK = new AntlersTokenType("?");
  IElementType T_OP_SELF_ASSIGN_ADD = new AntlersTokenType("+=");
  IElementType T_OP_SELF_ASSIGN_DIV = new AntlersTokenType("/=");
  IElementType T_OP_SELF_ASSIGN_MOD = new AntlersTokenType("%=");
  IElementType T_OP_SELF_ASSIGN_MUL = new AntlersTokenType("*=");
  IElementType T_OP_SELF_ASSIGN_SUB = new AntlersTokenType("-=");
  IElementType T_PHP_CONTENT = new AntlersTokenType("T_PHP_CONTENT");
  IElementType T_PHP_ECHO_CLOSE = new AntlersTokenType("$}}");
  IElementType T_PHP_ECHO_OPEN = new AntlersTokenType("{{$");
  IElementType T_PHP_RAW_CLOSE = new AntlersTokenType("?}}");
  IElementType T_PHP_RAW_OPEN = new AntlersTokenType("{{?");
  IElementType T_RD = new AntlersTokenType("}}");
  IElementType T_RIGHT_BRACE = new AntlersTokenType("}");
  IElementType T_RIGHT_BRACKET = new AntlersTokenType("]");
  IElementType T_RP = new AntlersTokenType(")");
  IElementType T_SLASH = new AntlersTokenType("/");
  IElementType T_STRING_CONTENT = new AntlersTokenType("T_STRING_CONTENT");
  IElementType T_STRING_END = new AntlersTokenType("T_STRING_END");
  IElementType T_STRING_START = new AntlersTokenType("T_STRING_START");
  IElementType T_TRUE = new AntlersTokenType("true");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADD_EXPR) {
        return new AntlersAddExprImpl(node);
      }
      else if (type == ANTLERS_NODE) {
        return new AntlersAntlersNodeImpl(node);
      }
      else if (type == ARRAY) {
        return new AntlersArrayImpl(node);
      }
      else if (type == BOOLEAN_LITERAL) {
        return new AntlersBooleanLiteralImpl(node);
      }
      else if (type == BRACKET_PROPERTY_ACCESS) {
        return new AntlersBracketPropertyAccessImpl(node);
      }
      else if (type == COLON_PROPERTY_ACCESS) {
        return new AntlersColonPropertyAccessImpl(node);
      }
      else if (type == COMMENT_BLOCK) {
        return new AntlersCommentBlockImpl(node);
      }
      else if (type == CONCAT_EXPR) {
        return new AntlersConcatExprImpl(node);
      }
      else if (type == DIV_EXPR) {
        return new AntlersDivExprImpl(node);
      }
      else if (type == DOT_PROPERTY_ACCESS) {
        return new AntlersDotPropertyAccessImpl(node);
      }
      else if (type == INTERPOLATED_STATEMENT) {
        return new AntlersInterpolatedStatementImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new AntlersLiteralExprImpl(node);
      }
      else if (type == MOD_EXPR) {
        return new AntlersModExprImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new AntlersMulExprImpl(node);
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
      else if (type == POW_EXPR) {
        return new AntlersPowExprImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new AntlersStringLiteralImpl(node);
      }
      else if (type == SUB_EXPR) {
        return new AntlersSubExprImpl(node);
      }
      else if (type == SUB_EXPRESSION) {
        return new AntlersSubExpressionImpl(node);
      }
      else if (type == TENARY_EXPR) {
        return new AntlersTenaryExprImpl(node);
      }
      else if (type == UNARY_FACTORIAL_EXPR) {
        return new AntlersUnaryFactorialExprImpl(node);
      }
      else if (type == UNARY_MINUS_EXPR) {
        return new AntlersUnaryMinusExprImpl(node);
      }
      else if (type == UNARY_NOT_EXPR) {
        return new AntlersUnaryNotExprImpl(node);
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
