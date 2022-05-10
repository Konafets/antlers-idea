// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import de.arrobait.antlers.psi.impl.*;

public interface AntlersTypes {

  IElementType ADD_EXPR = new AntlersElementType("ADD_EXPR");
  IElementType AND_EXPR = new AntlersElementType("AND_EXPR");
  IElementType ANTLERS_CLOSE_NODE = new AntlersElementType("ANTLERS_CLOSE_NODE");
  IElementType ANTLERS_NODE = new AntlersElementType("ANTLERS_NODE");
  IElementType ARRAY = new AntlersElementType("ARRAY");
  IElementType BOOLEAN_LITERAL = new AntlersElementType("BOOLEAN_LITERAL");
  IElementType BRACKET_PROPERTY_ACCESS = new AntlersElementType("BRACKET_PROPERTY_ACCESS");
  IElementType COLON_PROPERTY_ACCESS = new AntlersElementType("COLON_PROPERTY_ACCESS");
  IElementType COMMENT_BLOCK = new AntlersElementType("COMMENT_BLOCK");
  IElementType CONCAT_EXPR = new AntlersElementType("CONCAT_EXPR");
  IElementType CONDITIONAL = new AntlersElementType("CONDITIONAL");
  IElementType CONDITIONAL_ELSE = new AntlersElementType("CONDITIONAL_ELSE");
  IElementType CONDITIONAL_ELSEIF = new AntlersElementType("CONDITIONAL_ELSEIF");
  IElementType CONDITIONAL_END = new AntlersElementType("CONDITIONAL_END");
  IElementType CONDITIONAL_IF = new AntlersElementType("CONDITIONAL_IF");
  IElementType CONDITIONAL_UNLESS = new AntlersElementType("CONDITIONAL_UNLESS");
  IElementType DIV_EXPR = new AntlersElementType("DIV_EXPR");
  IElementType DOT_PROPERTY_ACCESS = new AntlersElementType("DOT_PROPERTY_ACCESS");
  IElementType EQ_EXPR = new AntlersElementType("EQ_EXPR");
  IElementType EXPR = new AntlersElementType("EXPR");
  IElementType GATEKEEPER_EXPR = new AntlersElementType("GATEKEEPER_EXPR");
  IElementType GTE_EXPR = new AntlersElementType("GTE_EXPR");
  IElementType GT_EXPR = new AntlersElementType("GT_EXPR");
  IElementType IDENT_EXPR = new AntlersElementType("IDENT_EXPR");
  IElementType INTERPOLATED_STATEMENT = new AntlersElementType("INTERPOLATED_STATEMENT");
  IElementType LITERAL_EXPR = new AntlersElementType("LITERAL_EXPR");
  IElementType LTE_EXPR = new AntlersElementType("LTE_EXPR");
  IElementType LT_EXPR = new AntlersElementType("LT_EXPR");
  IElementType MODIFIER_LIST = new AntlersElementType("MODIFIER_LIST");
  IElementType MODIFIER_PARAM = new AntlersElementType("MODIFIER_PARAM");
  IElementType MODIFIER_PARAMS_LIST = new AntlersElementType("MODIFIER_PARAMS_LIST");
  IElementType MOD_EXPR = new AntlersElementType("MOD_EXPR");
  IElementType MUL_EXPR = new AntlersElementType("MUL_EXPR");
  IElementType NEQ_EXPR = new AntlersElementType("NEQ_EXPR");
  IElementType NOT_IDENT_EXPR = new AntlersElementType("NOT_IDENT_EXPR");
  IElementType NULL_COALESCING_EXPR = new AntlersElementType("NULL_COALESCING_EXPR");
  IElementType NUMBER_LITERAL = new AntlersElementType("NUMBER_LITERAL");
  IElementType OR_EXPR = new AntlersElementType("OR_EXPR");
  IElementType PHP_ECHO_NODE = new AntlersElementType("PHP_ECHO_NODE");
  IElementType PHP_RAW_NODE = new AntlersElementType("PHP_RAW_NODE");
  IElementType POW_EXPR = new AntlersElementType("POW_EXPR");
  IElementType SPACESHIP_EXPR = new AntlersElementType("SPACESHIP_EXPR");
  IElementType STRING_LITERAL = new AntlersElementType("STRING_LITERAL");
  IElementType SUB_EXPR = new AntlersElementType("SUB_EXPR");
  IElementType SUB_EXPRESSION = new AntlersElementType("SUB_EXPRESSION");
  IElementType SWITCH_CASE = new AntlersElementType("SWITCH_CASE");
  IElementType SWITCH_NODE = new AntlersElementType("SWITCH_NODE");
  IElementType SWITCH_TAG = new AntlersElementType("SWITCH_TAG");
  IElementType TENARY_EXPR = new AntlersElementType("TENARY_EXPR");
  IElementType UNARY_FACTORIAL_EXPR = new AntlersElementType("UNARY_FACTORIAL_EXPR");
  IElementType UNARY_MINUS_EXPR = new AntlersElementType("UNARY_MINUS_EXPR");
  IElementType UNARY_NOT_EXPR = new AntlersElementType("UNARY_NOT_EXPR");
  IElementType VARIABLE = new AntlersElementType("VARIABLE");
  IElementType VARIABLE_ASSIGNMENT_NODE = new AntlersElementType("VARIABLE_ASSIGNMENT_NODE");
  IElementType XOR_EXPR = new AntlersElementType("XOR_EXPR");

  IElementType OUTER_CONTENT = new AntlersTokenType("OUTER_CONTENT");
  IElementType T_COLON = new AntlersTokenType(":");
  IElementType T_COMMA = new AntlersTokenType(",");
  IElementType T_COMMENT_CLOSE = new AntlersTokenType("#}}");
  IElementType T_COMMENT_OPEN = new AntlersTokenType("{{#");
  IElementType T_COMMENT_TEXT = new AntlersTokenType("T_COMMENT_TEXT");
  IElementType T_DOT = new AntlersTokenType(".");
  IElementType T_ELSE = new AntlersTokenType("else");
  IElementType T_ELSE_IF = new AntlersTokenType("elseif");
  IElementType T_END_IF = new AntlersTokenType("endif");
  IElementType T_END_UNLESS = new AntlersTokenType("endunless");
  IElementType T_FALSE = new AntlersTokenType("false");
  IElementType T_FLOAT_NUMBER = new AntlersTokenType("T_FLOAT_NUMBER");
  IElementType T_IDENTIFIER = new AntlersTokenType("T_IDENTIFIER");
  IElementType T_IF = new AntlersTokenType("if");
  IElementType T_IF_END = new AntlersTokenType("/if");
  IElementType T_INTEGER_NUMBER = new AntlersTokenType("T_INTEGER_NUMBER");
  IElementType T_LD = new AntlersTokenType("{{");
  IElementType T_LEFT_BRACE = new AntlersTokenType("{");
  IElementType T_LEFT_BRACKET = new AntlersTokenType("[");
  IElementType T_LP = new AntlersTokenType("(");
  IElementType T_MODIFIER = new AntlersTokenType("T_MODIFIER");
  IElementType T_OP_AND = new AntlersTokenType("T_OP_AND");
  IElementType T_OP_ARROW = new AntlersTokenType("=>");
  IElementType T_OP_ASSIGN = new AntlersTokenType("=");
  IElementType T_OP_EQ = new AntlersTokenType("==");
  IElementType T_OP_EXCLAMATION_MARK = new AntlersTokenType("!");
  IElementType T_OP_GATEKEEPER = new AntlersTokenType("?=");
  IElementType T_OP_GT = new AntlersTokenType(">");
  IElementType T_OP_GTE = new AntlersTokenType(">=");
  IElementType T_OP_IDENT = new AntlersTokenType("===");
  IElementType T_OP_LT = new AntlersTokenType("<");
  IElementType T_OP_LTE = new AntlersTokenType("<=");
  IElementType T_OP_MINUS = new AntlersTokenType("-");
  IElementType T_OP_MOD = new AntlersTokenType("%");
  IElementType T_OP_MUL = new AntlersTokenType("*");
  IElementType T_OP_NEQ = new AntlersTokenType("!=");
  IElementType T_OP_NOT_IDENT = new AntlersTokenType("!==");
  IElementType T_OP_NULL_COALESCENCE = new AntlersTokenType("??");
  IElementType T_OP_OR = new AntlersTokenType("T_OP_OR");
  IElementType T_OP_PLUS = new AntlersTokenType("+");
  IElementType T_OP_POW = new AntlersTokenType("**");
  IElementType T_OP_QUESTIONMARK = new AntlersTokenType("?");
  IElementType T_OP_SELF_ASSIGN_ADD = new AntlersTokenType("+=");
  IElementType T_OP_SELF_ASSIGN_DIV = new AntlersTokenType("/=");
  IElementType T_OP_SELF_ASSIGN_MOD = new AntlersTokenType("%=");
  IElementType T_OP_SELF_ASSIGN_MUL = new AntlersTokenType("*=");
  IElementType T_OP_SELF_ASSIGN_SUB = new AntlersTokenType("-=");
  IElementType T_OP_SPACESHIP = new AntlersTokenType("<=>");
  IElementType T_OP_XOR = new AntlersTokenType("xor");
  IElementType T_PHP_CONTENT = new AntlersTokenType("T_PHP_CONTENT");
  IElementType T_PHP_ECHO_CLOSE = new AntlersTokenType("$}}");
  IElementType T_PHP_ECHO_OPEN = new AntlersTokenType("{{$");
  IElementType T_PHP_RAW_CLOSE = new AntlersTokenType("?}}");
  IElementType T_PHP_RAW_OPEN = new AntlersTokenType("{{?");
  IElementType T_PIPE = new AntlersTokenType("|");
  IElementType T_RD = new AntlersTokenType("}}");
  IElementType T_RIGHT_BRACE = new AntlersTokenType("}");
  IElementType T_RIGHT_BRACKET = new AntlersTokenType("]");
  IElementType T_RP = new AntlersTokenType(")");
  IElementType T_SLASH = new AntlersTokenType("/");
  IElementType T_STRING_CONTENT = new AntlersTokenType("T_STRING_CONTENT");
  IElementType T_STRING_END = new AntlersTokenType("T_STRING_END");
  IElementType T_STRING_START = new AntlersTokenType("T_STRING_START");
  IElementType T_SWITCH = new AntlersTokenType("switch");
  IElementType T_TRUE = new AntlersTokenType("true");
  IElementType T_UNLESS = new AntlersTokenType("unless");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADD_EXPR) {
        return new AntlersAddExprImpl(node);
      }
      else if (type == AND_EXPR) {
        return new AntlersAndExprImpl(node);
      }
      else if (type == ANTLERS_CLOSE_NODE) {
        return new AntlersAntlersCloseNodeImpl(node);
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
      else if (type == CONDITIONAL) {
        return new AntlersConditionalImpl(node);
      }
      else if (type == CONDITIONAL_ELSE) {
        return new AntlersConditionalElseImpl(node);
      }
      else if (type == CONDITIONAL_ELSEIF) {
        return new AntlersConditionalElseifImpl(node);
      }
      else if (type == CONDITIONAL_END) {
        return new AntlersConditionalEndImpl(node);
      }
      else if (type == CONDITIONAL_IF) {
        return new AntlersConditionalIfImpl(node);
      }
      else if (type == CONDITIONAL_UNLESS) {
        return new AntlersConditionalUnlessImpl(node);
      }
      else if (type == DIV_EXPR) {
        return new AntlersDivExprImpl(node);
      }
      else if (type == DOT_PROPERTY_ACCESS) {
        return new AntlersDotPropertyAccessImpl(node);
      }
      else if (type == EQ_EXPR) {
        return new AntlersEqExprImpl(node);
      }
      else if (type == GATEKEEPER_EXPR) {
        return new AntlersGatekeeperExprImpl(node);
      }
      else if (type == GTE_EXPR) {
        return new AntlersGteExprImpl(node);
      }
      else if (type == GT_EXPR) {
        return new AntlersGtExprImpl(node);
      }
      else if (type == IDENT_EXPR) {
        return new AntlersIdentExprImpl(node);
      }
      else if (type == INTERPOLATED_STATEMENT) {
        return new AntlersInterpolatedStatementImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new AntlersLiteralExprImpl(node);
      }
      else if (type == LTE_EXPR) {
        return new AntlersLteExprImpl(node);
      }
      else if (type == LT_EXPR) {
        return new AntlersLtExprImpl(node);
      }
      else if (type == MODIFIER_LIST) {
        return new AntlersModifierListImpl(node);
      }
      else if (type == MODIFIER_PARAM) {
        return new AntlersModifierParamImpl(node);
      }
      else if (type == MODIFIER_PARAMS_LIST) {
        return new AntlersModifierParamsListImpl(node);
      }
      else if (type == MOD_EXPR) {
        return new AntlersModExprImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new AntlersMulExprImpl(node);
      }
      else if (type == NEQ_EXPR) {
        return new AntlersNeqExprImpl(node);
      }
      else if (type == NOT_IDENT_EXPR) {
        return new AntlersNotIdentExprImpl(node);
      }
      else if (type == NULL_COALESCING_EXPR) {
        return new AntlersNullCoalescingExprImpl(node);
      }
      else if (type == NUMBER_LITERAL) {
        return new AntlersNumberLiteralImpl(node);
      }
      else if (type == OR_EXPR) {
        return new AntlersOrExprImpl(node);
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
      else if (type == SPACESHIP_EXPR) {
        return new AntlersSpaceshipExprImpl(node);
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
      else if (type == SWITCH_CASE) {
        return new AntlersSwitchCaseImpl(node);
      }
      else if (type == SWITCH_NODE) {
        return new AntlersSwitchNodeImpl(node);
      }
      else if (type == SWITCH_TAG) {
        return new AntlersSwitchTagImpl(node);
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
      else if (type == XOR_EXPR) {
        return new AntlersXorExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
