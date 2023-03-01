// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.LightPsiParser;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import com.intellij.lang.PsiParser;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

import static de.arrobait.antlers.parser.AntlersParserUtil.*;
import static de.arrobait.antlers.psi.AntlersTypes.*;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class AntlersParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return antlersFile(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ADD_EXPR, AND_EXPR, CONCAT_EXPR, DIV_EXPR,
      EQ_EXPR, EXPR, GATEKEEPER_EXPR, GTE_EXPR,
      GT_EXPR, IDENT_EXPR, INTERPOLATED_STATEMENT, LITERAL_EXPR,
      LTE_EXPR, LT_EXPR, MOD_EXPR, MUL_EXPR,
      NEQ_EXPR, NOT_IDENT_EXPR, NULL_COALESCING_EXPR, OR_EXPR,
      POW_EXPR, SPACESHIP_EXPR, SUB_EXPR, SUB_EXPRESSION,
      TENARY_EXPR, UNARY_FACTORIAL_EXPR, UNARY_MINUS_EXPR, UNARY_NOT_EXPR,
      XOR_EXPR),
  };

  /* ********************************************************** */
  // single_advanced_operator*
  static boolean advanced_operators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "advanced_operators")) return false;
    while (true) {
      int c = current_position_(b);
      if (!single_advanced_operator(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "advanced_operators", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // <<eof>> | [tines]
  static boolean antlersFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlersFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = eof(b, l + 1);
    if (!r) r = antlersFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [tines]
  private static boolean antlersFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlersFile_1")) return false;
    tines(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // node_opener (T_SLASH variable) node_closer
  public static boolean antlers_close_node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlers_close_node")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ANTLERS_CLOSE_NODE, null);
    r = node_opener(b, l + 1);
    r = r && antlers_close_node_1(b, l + 1);
    p = r; // pin = 2
    r = r && node_closer(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // T_SLASH variable
  private static boolean antlers_close_node_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlers_close_node_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SLASH);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr ('|' modifier_list)*
  static boolean antlers_expression_or_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlers_expression_or_statement")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1, -1);
    r = r && antlers_expression_or_statement_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('|' modifier_list)*
  private static boolean antlers_expression_or_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlers_expression_or_statement_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!antlers_expression_or_statement_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "antlers_expression_or_statement_1", c)) break;
    }
    return true;
  }

  // '|' modifier_list
  private static boolean antlers_expression_or_statement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlers_expression_or_statement_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_PIPE);
    r = r && modifier_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(node_opener | outer_content | '{{#' | '{{?' | '{{$' | 'if' | 'else' | 'elseif' | 'endif' | 'unless' | 'endunless' | '/' | '[' | '{' | ':' | '=')
  static boolean antlers_node_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlers_node_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !antlers_node_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // node_opener | outer_content | '{{#' | '{{?' | '{{$' | 'if' | 'else' | 'elseif' | 'endif' | 'unless' | 'endunless' | '/' | '[' | '{' | ':' | '='
  private static boolean antlers_node_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlers_node_recover_0")) return false;
    boolean r;
    r = node_opener(b, l + 1);
    if (!r) r = outer_content(b, l + 1);
    if (!r) r = consumeToken(b, T_COMMENT_OPEN);
    if (!r) r = consumeToken(b, T_PHP_RAW_OPEN);
    if (!r) r = consumeToken(b, T_PHP_ECHO_OPEN);
    if (!r) r = consumeToken(b, T_IF);
    if (!r) r = consumeToken(b, T_ELSE);
    if (!r) r = consumeToken(b, T_ELSE_IF);
    if (!r) r = consumeToken(b, T_END_IF);
    if (!r) r = consumeToken(b, T_UNLESS);
    if (!r) r = consumeToken(b, T_END_UNLESS);
    if (!r) r = consumeToken(b, T_SLASH);
    if (!r) r = consumeToken(b, T_LEFT_BRACKET);
    if (!r) r = consumeToken(b, T_LEFT_BRACE);
    if (!r) r = consumeToken(b, T_COLON);
    if (!r) r = consumeToken(b, T_OP_ASSIGN);
    return r;
  }

  /* ********************************************************** */
  // '[' array_value (',' array_value*)* ']'
  public static boolean array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array")) return false;
    if (!nextTokenIs(b, T_LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LEFT_BRACKET);
    r = r && array_value(b, l + 1);
    r = r && array_2(b, l + 1);
    r = r && consumeToken(b, T_RIGHT_BRACKET);
    exit_section_(b, m, ARRAY, r);
    return r;
  }

  // (',' array_value*)*
  private static boolean array_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_2", c)) break;
    }
    return true;
  }

  // ',' array_value*
  private static boolean array_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && array_2_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // array_value*
  private static boolean array_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_2_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!array_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "array_2_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (string_literal | number_literal | array) ['=>' variable]
  static boolean array_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_value")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = array_value_0(b, l + 1);
    r = r && array_value_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // string_literal | number_literal | array
  private static boolean array_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_value_0")) return false;
    boolean r;
    r = string_literal(b, l + 1);
    if (!r) r = number_literal(b, l + 1);
    if (!r) r = array(b, l + 1);
    return r;
  }

  // ['=>' variable]
  private static boolean array_value_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_value_1")) return false;
    array_value_1_0(b, l + 1);
    return true;
  }

  // '=>' variable
  private static boolean array_value_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_value_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_OP_ARROW);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER '=>'
  static boolean arrow_func(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrow_func")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 2, T_IDENTIFIER, T_OP_ARROW);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // boolean_literal
  //                            | number_literal
  //                            | string_literal
  //                            | variable [advanced_operators]
  //                            | array
  //                            | interpolated_statement [advanced_operators]
  //                            | sub_expression
  static boolean assignable_items(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignable_items")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = boolean_literal(b, l + 1);
    if (!r) r = number_literal(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = assignable_items_3(b, l + 1);
    if (!r) r = array(b, l + 1);
    if (!r) r = assignable_items_5(b, l + 1);
    if (!r) r = sub_expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // variable [advanced_operators]
  private static boolean assignable_items_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignable_items_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
    r = r && assignable_items_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [advanced_operators]
  private static boolean assignable_items_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignable_items_3_1")) return false;
    advanced_operators(b, l + 1);
    return true;
  }

  // interpolated_statement [advanced_operators]
  private static boolean assignable_items_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignable_items_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = interpolated_statement(b, l + 1);
    r = r && assignable_items_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [advanced_operators]
  private static boolean assignable_items_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignable_items_5_1")) return false;
    advanced_operators(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // conditional_end
  public static boolean block_close_node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_close_node")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = conditional_end(b, l + 1);
    exit_section_(b, m, BLOCK_CLOSE_NODE, r);
    return r;
  }

  /* ********************************************************** */
  // conditional_start
  public static boolean block_open_node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_open_node")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = conditional_start(b, l + 1);
    exit_section_(b, m, BLOCK_OPEN_NODE, r);
    return r;
  }

  /* ********************************************************** */
  // conditional
  //                 | tag_pair
  public static boolean block_wrapper(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_wrapper")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = conditional(b, l + 1);
    if (!r) r = tag_pair(b, l + 1);
    exit_section_(b, m, BLOCK_WRAPPER, r);
    return r;
  }

  /* ********************************************************** */
  // 'true' | 'false'
  public static boolean boolean_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_literal")) return false;
    if (!nextTokenIs(b, "<boolean literal>", T_FALSE, T_TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_LITERAL, "<boolean literal>");
    r = consumeToken(b, T_TRUE);
    if (!r) r = consumeToken(b, T_FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' (T_INTEGER_NUMBER | T_IDENTIFIER [dot_property_access | colon_property_access] | string_literal | interpolated_statement) ']'
  public static boolean bracket_property_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_property_access")) return false;
    if (!nextTokenIs(b, T_LEFT_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LEFT_BRACKET);
    r = r && bracket_property_access_1(b, l + 1);
    r = r && consumeToken(b, T_RIGHT_BRACKET);
    exit_section_(b, m, BRACKET_PROPERTY_ACCESS, r);
    return r;
  }

  // T_INTEGER_NUMBER | T_IDENTIFIER [dot_property_access | colon_property_access] | string_literal | interpolated_statement
  private static boolean bracket_property_access_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_property_access_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_INTEGER_NUMBER);
    if (!r) r = bracket_property_access_1_1(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = interpolated_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_IDENTIFIER [dot_property_access | colon_property_access]
  private static boolean bracket_property_access_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_property_access_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    r = r && bracket_property_access_1_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [dot_property_access | colon_property_access]
  private static boolean bracket_property_access_1_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_property_access_1_1_1")) return false;
    bracket_property_access_1_1_1_0(b, l + 1);
    return true;
  }

  // dot_property_access | colon_property_access
  private static boolean bracket_property_access_1_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bracket_property_access_1_1_1_0")) return false;
    boolean r;
    r = dot_property_access(b, l + 1);
    if (!r) r = colon_property_access(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ':' (T_INTEGER_NUMBER | T_IDENTIFIER | string_literal)
  public static boolean colon_property_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "colon_property_access")) return false;
    if (!nextTokenIs(b, T_COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && colon_property_access_1(b, l + 1);
    exit_section_(b, m, COLON_PROPERTY_ACCESS, r);
    return r;
  }

  // T_INTEGER_NUMBER | T_IDENTIFIER | string_literal
  private static boolean colon_property_access_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "colon_property_access_1")) return false;
    boolean r;
    r = consumeToken(b, T_INTEGER_NUMBER);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = string_literal(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_COMMENT_OPEN T_COMMENT_TEXT* T_COMMENT_CLOSE
  public static boolean comment_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_block")) return false;
    if (!nextTokenIs(b, T_COMMENT_OPEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, COMMENT_BLOCK, null);
    r = consumeToken(b, T_COMMENT_OPEN);
    p = r; // pin = 1
    r = r && report_error_(b, comment_block_1(b, l + 1));
    r = p && consumeToken(b, T_COMMENT_CLOSE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // T_COMMENT_TEXT*
  private static boolean comment_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "comment_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, T_COMMENT_TEXT)) break;
      if (!empty_element_parsed_guard_(b, "comment_block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // block_open_node tines (conditional_elseif tines)* (conditional_else tines)? block_close_node
  public static boolean conditional(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL, null);
    r = block_open_node(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, tines(b, l + 1));
    r = p && report_error_(b, conditional_2(b, l + 1)) && r;
    r = p && report_error_(b, conditional_3(b, l + 1)) && r;
    r = p && block_close_node(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (conditional_elseif tines)*
  private static boolean conditional_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditional_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditional_2", c)) break;
    }
    return true;
  }

  // conditional_elseif tines
  private static boolean conditional_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = conditional_elseif(b, l + 1);
    r = r && tines(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (conditional_else tines)?
  private static boolean conditional_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_3")) return false;
    conditional_3_0(b, l + 1);
    return true;
  }

  // conditional_else tines
  private static boolean conditional_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = conditional_else(b, l + 1);
    r = r && tines(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // node_opener 'else' node_closer
  public static boolean conditional_else(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_else")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_ELSE, null);
    r = node_opener(b, l + 1);
    r = r && consumeToken(b, T_ELSE);
    p = r; // pin = 2
    r = r && node_closer(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // node_opener 'elseif' expr ('|' modifier_list)* node_closer
  public static boolean conditional_elseif(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_elseif")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_ELSEIF, null);
    r = node_opener(b, l + 1);
    r = r && consumeToken(b, T_ELSE_IF);
    p = r; // pin = 2
    r = r && report_error_(b, expr(b, l + 1, -1));
    r = p && report_error_(b, conditional_elseif_3(b, l + 1)) && r;
    r = p && node_closer(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('|' modifier_list)*
  private static boolean conditional_elseif_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_elseif_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditional_elseif_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditional_elseif_3", c)) break;
    }
    return true;
  }

  // '|' modifier_list
  private static boolean conditional_elseif_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_elseif_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_PIPE);
    r = r && modifier_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // slash_unless_if | endunless_endif
  public static boolean conditional_end(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_end")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = slash_unless_if(b, l + 1);
    if (!r) r = endunless_endif(b, l + 1);
    exit_section_(b, m, CONDITIONAL_END, r);
    return r;
  }

  /* ********************************************************** */
  // node_opener 'if' expr ('|' modifier_list)* node_closer
  public static boolean conditional_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_if")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_IF, null);
    r = node_opener(b, l + 1);
    r = r && consumeToken(b, T_IF);
    p = r; // pin = 2
    r = r && report_error_(b, expr(b, l + 1, -1));
    r = p && report_error_(b, conditional_if_3(b, l + 1)) && r;
    r = p && node_closer(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('|' modifier_list)*
  private static boolean conditional_if_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_if_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditional_if_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditional_if_3", c)) break;
    }
    return true;
  }

  // '|' modifier_list
  private static boolean conditional_if_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_if_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_PIPE);
    r = r && modifier_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // conditional_if | conditional_unless
  static boolean conditional_start(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_start")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r;
    r = conditional_if(b, l + 1);
    if (!r) r = conditional_unless(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // node_opener 'unless' expr ('|' modifier_list)* node_closer
  public static boolean conditional_unless(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_unless")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONDITIONAL_UNLESS, null);
    r = node_opener(b, l + 1);
    r = r && consumeToken(b, T_UNLESS);
    p = r; // pin = 2
    r = r && report_error_(b, expr(b, l + 1, -1));
    r = p && report_error_(b, conditional_unless_3(b, l + 1)) && r;
    r = p && node_closer(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ('|' modifier_list)*
  private static boolean conditional_unless_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_unless_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conditional_unless_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conditional_unless_3", c)) break;
    }
    return true;
  }

  // '|' modifier_list
  private static boolean conditional_unless_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conditional_unless_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_PIPE);
    r = r && modifier_list(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' ')' '=>' string_literal ','?
  public static boolean default_case(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "default_case")) return false;
    if (!nextTokenIs(b, T_LP)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DEFAULT_CASE, null);
    r = consumeTokens(b, 0, T_LP, T_RP, T_OP_ARROW);
    r = r && string_literal(b, l + 1);
    p = r; // pin = 4
    r = r && default_case_4(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ','?
  private static boolean default_case_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "default_case_4")) return false;
    consumeToken(b, T_COMMA);
    return true;
  }

  /* ********************************************************** */
  // '.' (T_INTEGER_NUMBER | T_IDENTIFIER | string_literal)
  public static boolean dot_property_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_property_access")) return false;
    if (!nextTokenIs(b, T_DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_DOT);
    r = r && dot_property_access_1(b, l + 1);
    exit_section_(b, m, DOT_PROPERTY_ACCESS, r);
    return r;
  }

  // T_INTEGER_NUMBER | T_IDENTIFIER | string_literal
  private static boolean dot_property_access_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dot_property_access_1")) return false;
    boolean r;
    r = consumeToken(b, T_INTEGER_NUMBER);
    if (!r) r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = string_literal(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // node_opener ('endunless' | 'endif') node_closer
  static boolean endunless_endif(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "endunless_endif")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = node_opener(b, l + 1);
    r = r && endunless_endif_1(b, l + 1);
    p = r; // pin = 2
    r = r && node_closer(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // 'endunless' | 'endif'
  private static boolean endunless_endif_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "endunless_endif_1")) return false;
    boolean r;
    r = consumeToken(b, T_END_UNLESS);
    if (!r) r = consumeToken(b, T_END_IF);
    return r;
  }

  /* ********************************************************** */
  // 'groupby' (groupby_args_list | groupby_args_list_with_arrow_func)
  public static boolean groupby(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby")) return false;
    if (!nextTokenIs(b, T_GROUP_BY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_GROUP_BY);
    r = r && groupby_1(b, l + 1);
    exit_section_(b, m, GROUPBY, r);
    return r;
  }

  // groupby_args_list | groupby_args_list_with_arrow_func
  private static boolean groupby_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_1")) return false;
    boolean r;
    r = groupby_args_list(b, l + 1);
    if (!r) r = groupby_args_list_with_arrow_func(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // string_literal
  public static boolean groupby_alias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_alias")) return false;
    if (!nextTokenIs(b, "<groupby alias>", T_DOUBLE_QUOTE, T_SINGLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GROUPBY_ALIAS, "<groupby alias>");
    r = string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // antlers_expression_or_statement [groupby_alias]
  public static boolean groupby_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GROUPBY_ARG, "<groupby arg>");
    r = antlers_expression_or_statement(b, l + 1);
    r = r && groupby_arg_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [groupby_alias]
  private static boolean groupby_arg_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_arg_1")) return false;
    groupby_alias(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '(' groupby_arg (',' groupby_arg)* ')' ['as' string_literal]
  public static boolean groupby_args_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_args_list")) return false;
    if (!nextTokenIs(b, T_LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LP);
    r = r && groupby_arg(b, l + 1);
    r = r && groupby_args_list_2(b, l + 1);
    r = r && consumeToken(b, T_RP);
    r = r && groupby_args_list_4(b, l + 1);
    exit_section_(b, m, GROUPBY_ARGS_LIST, r);
    return r;
  }

  // (',' groupby_arg)*
  private static boolean groupby_args_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_args_list_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!groupby_args_list_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "groupby_args_list_2", c)) break;
    }
    return true;
  }

  // ',' groupby_arg
  private static boolean groupby_args_list_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_args_list_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && groupby_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ['as' string_literal]
  private static boolean groupby_args_list_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_args_list_4")) return false;
    groupby_args_list_4_0(b, l + 1);
    return true;
  }

  // 'as' string_literal
  private static boolean groupby_args_list_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_args_list_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_AS);
    r = r && string_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(''(' arrow_func groupby_arg [',' groupby_arg] ')'')' ['as' string_literal]
  static boolean groupby_args_list_with_arrow_func(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_args_list_with_arrow_func")) return false;
    if (!nextTokenIs(b, T_LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_LP, T_LP);
    r = r && arrow_func(b, l + 1);
    r = r && groupby_arg(b, l + 1);
    r = r && groupby_args_list_with_arrow_func_4(b, l + 1);
    r = r && consumeTokens(b, 0, T_RP, T_RP);
    r = r && groupby_args_list_with_arrow_func_7(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [',' groupby_arg]
  private static boolean groupby_args_list_with_arrow_func_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_args_list_with_arrow_func_4")) return false;
    groupby_args_list_with_arrow_func_4_0(b, l + 1);
    return true;
  }

  // ',' groupby_arg
  private static boolean groupby_args_list_with_arrow_func_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_args_list_with_arrow_func_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && groupby_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ['as' string_literal]
  private static boolean groupby_args_list_with_arrow_func_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_args_list_with_arrow_func_7")) return false;
    groupby_args_list_with_arrow_func_7_0(b, l + 1);
    return true;
  }

  // 'as' string_literal
  private static boolean groupby_args_list_with_arrow_func_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "groupby_args_list_with_arrow_func_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_AS);
    r = r && string_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'merge' (variable | interpolated_statement)
  public static boolean merge(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "merge")) return false;
    if (!nextTokenIs(b, T_MERGE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MERGE);
    r = r && merge_1(b, l + 1);
    exit_section_(b, m, MERGE, r);
    return r;
  }

  // variable | interpolated_statement
  private static boolean merge_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "merge_1")) return false;
    boolean r;
    r = variable(b, l + 1);
    if (!r) r = interpolated_statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_MODIFIER [modifier_params_list]
  public static boolean modifier_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_list")) return false;
    if (!nextTokenIs(b, T_MODIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_MODIFIER);
    r = r && modifier_list_1(b, l + 1);
    exit_section_(b, m, MODIFIER_LIST, r);
    return r;
  }

  // [modifier_params_list]
  private static boolean modifier_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_list_1")) return false;
    modifier_params_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '=' string_literal
  static boolean modifier_list_assign(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_list_assign")) return false;
    if (!nextTokenIs(b, T_OP_ASSIGN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_OP_ASSIGN);
    r = r && string_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ':' modifier_param (':' modifier_param)*
  static boolean modifier_list_colon(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_list_colon")) return false;
    if (!nextTokenIs(b, T_COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && modifier_param(b, l + 1);
    r = r && modifier_list_colon_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' modifier_param)*
  private static boolean modifier_list_colon_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_list_colon_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!modifier_list_colon_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modifier_list_colon_2", c)) break;
    }
    return true;
  }

  // ':' modifier_param
  private static boolean modifier_list_colon_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_list_colon_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && modifier_param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '(' modifier_param (',' modifier_param)*  ')'
  static boolean modifier_list_paren(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_list_paren")) return false;
    if (!nextTokenIs(b, T_LP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LP);
    r = r && modifier_param(b, l + 1);
    r = r && modifier_list_paren_2(b, l + 1);
    r = r && consumeToken(b, T_RP);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' modifier_param)*
  private static boolean modifier_list_paren_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_list_paren_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!modifier_list_paren_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "modifier_list_paren_2", c)) break;
    }
    return true;
  }

  // ',' modifier_param
  private static boolean modifier_list_paren_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_list_paren_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && modifier_param(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // literal_expr | array
  public static boolean modifier_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_param")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFIER_PARAM, "<modifier param>");
    r = literal_expr(b, l + 1);
    if (!r) r = array(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // modifier_list_paren | modifier_list_colon | modifier_list_assign
  public static boolean modifier_params_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modifier_params_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MODIFIER_PARAMS_LIST, "<modifier params list>");
    r = modifier_list_paren(b, l + 1);
    if (!r) r = modifier_list_colon(b, l + 1);
    if (!r) r = modifier_list_assign(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_RD
  public static boolean node_closer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_closer")) return false;
    if (!nextTokenIs(b, T_RD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_RD);
    exit_section_(b, m, NODE_CLOSER, r);
    return r;
  }

  /* ********************************************************** */
  // T_LD
  public static boolean node_opener(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "node_opener")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_LD);
    exit_section_(b, m, NODE_OPENER, r);
    return r;
  }

  /* ********************************************************** */
  // noparse_region_open tines noparse_region_close
  public static boolean noparse_region(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "noparse_region")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NOPARSE_REGION, null);
    r = noparse_region_open(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, tines(b, l + 1));
    r = p && noparse_region_close(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // node_opener (T_SLASH 'noparse') node_closer
  public static boolean noparse_region_close(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "noparse_region_close")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NOPARSE_REGION_CLOSE, null);
    r = node_opener(b, l + 1);
    r = r && noparse_region_close_1(b, l + 1);
    p = r; // pin = 2
    r = r && node_closer(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // T_SLASH 'noparse'
  private static boolean noparse_region_close_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "noparse_region_close_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_SLASH, T_NOPARSE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // node_opener 'noparse' node_closer
  public static boolean noparse_region_open(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "noparse_region_open")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NOPARSE_REGION_OPEN, null);
    r = node_opener(b, l + 1);
    r = r && consumeToken(b, T_NOPARSE);
    p = r; // pin = 2
    r = r && node_closer(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_INTEGER_NUMBER | T_FLOAT_NUMBER
  public static boolean number_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "number_literal")) return false;
    if (!nextTokenIs(b, "<number literal>", T_FLOAT_NUMBER, T_INTEGER_NUMBER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER_LITERAL, "<number literal>");
    r = consumeToken(b, T_INTEGER_NUMBER);
    if (!r) r = consumeToken(b, T_FLOAT_NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'orderby' '(' orderby_args_list ')'
  public static boolean orderby(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orderby")) return false;
    if (!nextTokenIs(b, T_ORDER_BY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_ORDER_BY, T_LP);
    r = r && orderby_args_list(b, l + 1);
    r = r && consumeToken(b, T_RP);
    exit_section_(b, m, ORDERBY, r);
    return r;
  }

  /* ********************************************************** */
  // variable orderby_direction
  public static boolean orderby_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orderby_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ORDERBY_ARG, "<orderby arg>");
    r = variable(b, l + 1);
    r = r && orderby_direction(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // orderby_arg (',' orderby_arg)*
  public static boolean orderby_args_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orderby_args_list")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ORDERBY_ARGS_LIST, "<orderby args list>");
    r = orderby_arg(b, l + 1);
    r = r && orderby_args_list_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' orderby_arg)*
  private static boolean orderby_args_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orderby_args_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!orderby_args_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "orderby_args_list_1", c)) break;
    }
    return true;
  }

  // ',' orderby_arg
  private static boolean orderby_args_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orderby_args_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COMMA);
    r = r && orderby_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // string_literal | boolean_literal | variable
  public static boolean orderby_direction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "orderby_direction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ORDERBY_DIRECTION, "<orderby direction>");
    r = string_literal(b, l + 1);
    if (!r) r = boolean_literal(b, l + 1);
    if (!r) r = variable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "@"? OUTER_CONTENT
  static boolean outer_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outer_content")) return false;
    if (!nextTokenIs(b, "", OUTER_CONTENT, T_AT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = outer_content_0(b, l + 1);
    r = r && consumeToken(b, OUTER_CONTENT);
    exit_section_(b, m, null, r);
    return r;
  }

  // "@"?
  private static boolean outer_content_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "outer_content_0")) return false;
    consumeToken(b, T_AT);
    return true;
  }

  /* ********************************************************** */
  // "{{$" T_PHP_CONTENT* "$}}"
  public static boolean php_echo_node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "php_echo_node")) return false;
    if (!nextTokenIs(b, T_PHP_ECHO_OPEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PHP_ECHO_NODE, null);
    r = consumeToken(b, T_PHP_ECHO_OPEN);
    p = r; // pin = 1
    r = r && report_error_(b, php_echo_node_1(b, l + 1));
    r = p && consumeToken(b, T_PHP_ECHO_CLOSE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // T_PHP_CONTENT*
  private static boolean php_echo_node_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "php_echo_node_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, T_PHP_CONTENT)) break;
      if (!empty_element_parsed_guard_(b, "php_echo_node_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // php_raw_node | php_echo_node
  static boolean php_node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "php_node")) return false;
    if (!nextTokenIs(b, "", T_PHP_ECHO_OPEN, T_PHP_RAW_OPEN)) return false;
    boolean r;
    r = php_raw_node(b, l + 1);
    if (!r) r = php_echo_node(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "{{?" T_PHP_CONTENT* "?}}"
  public static boolean php_raw_node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "php_raw_node")) return false;
    if (!nextTokenIs(b, T_PHP_RAW_OPEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PHP_RAW_NODE, null);
    r = consumeToken(b, T_PHP_RAW_OPEN);
    p = r; // pin = 1
    r = r && report_error_(b, php_raw_node_1(b, l + 1));
    r = p && consumeToken(b, T_PHP_RAW_CLOSE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // T_PHP_CONTENT*
  private static boolean php_raw_node_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "php_raw_node_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, T_PHP_CONTENT)) break;
      if (!empty_element_parsed_guard_(b, "php_raw_node_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'pluck' '(' (variable | number_literal | string_literal) ')'
  public static boolean pluck(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pluck")) return false;
    if (!nextTokenIs(b, T_PLUCK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_PLUCK, T_LP);
    r = r && pluck_2(b, l + 1);
    r = r && consumeToken(b, T_RP);
    exit_section_(b, m, PLUCK, r);
    return r;
  }

  // variable | number_literal | string_literal
  private static boolean pluck_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pluck_2")) return false;
    boolean r;
    r = variable(b, l + 1);
    if (!r) r = number_literal(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // bracket_property_access | dot_property_access | colon_property_access
  static boolean property_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_access")) return false;
    boolean r;
    r = bracket_property_access(b, l + 1);
    if (!r) r = dot_property_access(b, l + 1);
    if (!r) r = colon_property_access(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // node_opener T_STAR T_RECURSIVE_CHILDREN [':' T_IDENTIFIER] T_STAR node_closer
  public static boolean recursive_children_node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recursive_children_node")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RECURSIVE_CHILDREN_NODE, null);
    r = node_opener(b, l + 1);
    r = r && consumeTokens(b, 2, T_STAR, T_RECURSIVE_CHILDREN);
    p = r; // pin = 3
    r = r && report_error_(b, recursive_children_node_3(b, l + 1));
    r = p && report_error_(b, consumeToken(b, T_STAR)) && r;
    r = p && node_closer(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [':' T_IDENTIFIER]
  private static boolean recursive_children_node_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recursive_children_node_3")) return false;
    parseTokens(b, 0, T_COLON, T_IDENTIFIER);
    return true;
  }

  /* ********************************************************** */
  // tag_name
  static boolean regular_tag(PsiBuilder b, int l) {
    return tag_name(b, l + 1);
  }

  /* ********************************************************** */
  // regular_tag T_SHORTHAND_SEPARATOR tag_method_part
  static boolean shorthand_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shorthand_tag")) return false;
    if (!nextTokenIs(b, T_TAG)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = regular_tag(b, l + 1);
    r = r && consumeToken(b, T_SHORTHAND_SEPARATOR);
    p = r; // pin = 2
    r = r && tag_method_part(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // groupby
  //                            | merge
  //                            | orderby
  //                            | pluck
  //                            | skip
  //                            | take
  //                            | where
  public static boolean single_advanced_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "single_advanced_operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_ADVANCED_OPERATOR, "<single advanced operator>");
    r = groupby(b, l + 1);
    if (!r) r = merge(b, l + 1);
    if (!r) r = orderby(b, l + 1);
    if (!r) r = pluck(b, l + 1);
    if (!r) r = skip(b, l + 1);
    if (!r) r = take(b, l + 1);
    if (!r) r = where(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'skip' '(' number_literal ')'
  public static boolean skip(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "skip")) return false;
    if (!nextTokenIs(b, T_SKIP)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_SKIP, T_LP);
    r = r && number_literal(b, l + 1);
    r = r && consumeToken(b, T_RP);
    exit_section_(b, m, SKIP, r);
    return r;
  }

  /* ********************************************************** */
  // node_opener (T_END_UNLESS | T_END_IF) node_closer
  static boolean slash_unless_if(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slash_unless_if")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = node_opener(b, l + 1);
    r = r && slash_unless_if_1(b, l + 1);
    p = r; // pin = 2
    r = r && node_closer(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // T_END_UNLESS | T_END_IF
  private static boolean slash_unless_if_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "slash_unless_if_1")) return false;
    boolean r;
    r = consumeToken(b, T_END_UNLESS);
    if (!r) r = consumeToken(b, T_END_IF);
    return r;
  }

  /* ********************************************************** */
  // "'" T_STRING_CONTENT? "'"
  //                   | '"' T_STRING_CONTENT? '"'
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, "<string literal>", T_DOUBLE_QUOTE, T_SINGLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_LITERAL, "<string literal>");
    r = string_literal_0(b, l + 1);
    if (!r) r = string_literal_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "'" T_STRING_CONTENT? "'"
  private static boolean string_literal_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SINGLE_QUOTE);
    r = r && string_literal_0_1(b, l + 1);
    r = r && consumeToken(b, T_SINGLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_STRING_CONTENT?
  private static boolean string_literal_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_0_1")) return false;
    consumeToken(b, T_STRING_CONTENT);
    return true;
  }

  // '"' T_STRING_CONTENT? '"'
  private static boolean string_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_DOUBLE_QUOTE);
    r = r && string_literal_1_1(b, l + 1);
    r = r && consumeToken(b, T_DOUBLE_QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // T_STRING_CONTENT?
  private static boolean string_literal_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_1_1")) return false;
    consumeToken(b, T_STRING_CONTENT);
    return true;
  }

  /* ********************************************************** */
  // '(' group_comp ')' '=>' string_literal ','?
  public static boolean switch_case(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_case")) return false;
    if (!nextTokenIs(b, T_LP)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_CASE, null);
    r = consumeToken(b, T_LP);
    r = r && expr(b, l + 1, 1);
    r = r && consumeTokens(b, 2, T_RP, T_OP_ARROW);
    p = r; // pin = 4
    r = r && report_error_(b, string_literal(b, l + 1));
    r = p && switch_case_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ','?
  private static boolean switch_case_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_case_5")) return false;
    consumeToken(b, T_COMMA);
    return true;
  }

  /* ********************************************************** */
  // node_opener switch_tag node_closer
  public static boolean switch_node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_node")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_NODE, null);
    r = node_opener(b, l + 1);
    r = r && switch_tag(b, l + 1);
    p = r; // pin = 2
    r = r && node_closer(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'switch' '(' switch_case+ default_case? ')'
  public static boolean switch_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_tag")) return false;
    if (!nextTokenIs(b, T_SWITCH)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SWITCH_TAG, null);
    r = consumeTokens(b, 1, T_SWITCH, T_LP);
    p = r; // pin = 1
    r = r && report_error_(b, switch_tag_2(b, l + 1));
    r = p && report_error_(b, switch_tag_3(b, l + 1)) && r;
    r = p && consumeToken(b, T_RP) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // switch_case+
  private static boolean switch_tag_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_tag_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = switch_case(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!switch_case(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "switch_tag_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // default_case?
  private static boolean switch_tag_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switch_tag_3")) return false;
    default_case(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // [T_DISAMBIGUATION] (shorthand_tag | regular_tag)
  public static boolean tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag")) return false;
    if (!nextTokenIs(b, "<tag>", T_DISAMBIGUATION, T_TAG)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG, "<tag>");
    r = tag_0(b, l + 1);
    r = r && tag_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [T_DISAMBIGUATION]
  private static boolean tag_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_0")) return false;
    consumeToken(b, T_DISAMBIGUATION);
    return true;
  }

  // shorthand_tag | regular_tag
  private static boolean tag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_1")) return false;
    boolean r;
    r = shorthand_tag(b, l + 1);
    if (!r) r = regular_tag(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // T_DYNAMIC_BINDING* tag_attribute_key '=' tag_attribute_value
  public static boolean tag_attribute_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_attribute_assignment")) return false;
    if (!nextTokenIs(b, "<tag attribute assignment>", T_DYNAMIC_BINDING, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG_ATTRIBUTE_ASSIGNMENT, "<tag attribute assignment>");
    r = tag_attribute_assignment_0(b, l + 1);
    r = r && tag_attribute_key(b, l + 1);
    r = r && consumeToken(b, T_OP_ASSIGN);
    r = r && tag_attribute_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // T_DYNAMIC_BINDING*
  private static boolean tag_attribute_assignment_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_attribute_assignment_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, T_DYNAMIC_BINDING)) break;
      if (!empty_element_parsed_guard_(b, "tag_attribute_assignment_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // T_IDENTIFIER [T_TAG_CONDITION]
  public static boolean tag_attribute_key(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_attribute_key")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    r = r && tag_attribute_key_1(b, l + 1);
    exit_section_(b, m, TAG_ATTRIBUTE_KEY, r);
    return r;
  }

  // [T_TAG_CONDITION]
  private static boolean tag_attribute_key_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_attribute_key_1")) return false;
    consumeToken(b, T_TAG_CONDITION);
    return true;
  }

  /* ********************************************************** */
  // string_literal
  public static boolean tag_attribute_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_attribute_value")) return false;
    if (!nextTokenIs(b, "<tag attribute value>", T_DOUBLE_QUOTE, T_SINGLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAG_ATTRIBUTE_VALUE, "<tag attribute value>");
    r = string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // T_TAG_METHOD_NAME
  static boolean tag_method_name(PsiBuilder b, int l) {
    return consumeToken(b, T_TAG_METHOD_NAME);
  }

  /* ********************************************************** */
  // tag_method_name (T_SHORTHAND_SEPARATOR tag_method_name)*
  public static boolean tag_method_part(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_method_part")) return false;
    if (!nextTokenIs(b, T_TAG_METHOD_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tag_method_name(b, l + 1);
    r = r && tag_method_part_1(b, l + 1);
    exit_section_(b, m, TAG_METHOD_PART, r);
    return r;
  }

  // (T_SHORTHAND_SEPARATOR tag_method_name)*
  private static boolean tag_method_part_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_method_part_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tag_method_part_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tag_method_part_1", c)) break;
    }
    return true;
  }

  // T_SHORTHAND_SEPARATOR tag_method_name
  private static boolean tag_method_part_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_method_part_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SHORTHAND_SEPARATOR);
    r = r && tag_method_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_TAG
  public static boolean tag_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_name")) return false;
    if (!nextTokenIs(b, T_TAG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_TAG);
    exit_section_(b, m, TAG_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // node_opener (T_SLASH tag) node_closer
  public static boolean tag_node_close(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_node_close")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TAG_NODE_CLOSE, null);
    r = node_opener(b, l + 1);
    r = r && tag_node_close_1(b, l + 1);
    p = r; // pin = 2
    r = r && node_closer(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // T_SLASH tag
  private static boolean tag_node_close_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_node_close_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_SLASH);
    r = r && tag(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // node_opener tag_with_attributes [T_SLASH] node_closer
  public static boolean tag_node_open(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_node_open")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TAG_NODE_OPEN, null);
    r = node_opener(b, l + 1);
    r = r && tag_with_attributes(b, l + 1);
    r = r && tag_node_open_2(b, l + 1);
    p = r; // pin = 3
    r = r && node_closer(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [T_SLASH]
  private static boolean tag_node_open_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_node_open_2")) return false;
    consumeToken(b, T_SLASH);
    return true;
  }

  /* ********************************************************** */
  // tag_node_open tines tag_node_close
  public static boolean tag_pair(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_pair")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tag_node_open(b, l + 1);
    r = r && tines(b, l + 1);
    r = r && tag_node_close(b, l + 1);
    exit_section_(b, m, TAG_PAIR, r);
    return r;
  }

  /* ********************************************************** */
  // tag_node_open
  public static boolean tag_single(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_single")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tag_node_open(b, l + 1);
    exit_section_(b, m, TAG_SINGLE, r);
    return r;
  }

  /* ********************************************************** */
  // T_TAXONOMY taxonomy_name '=' taxonomy_term
  public static boolean tag_taxonomy_condition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_taxonomy_condition")) return false;
    if (!nextTokenIs(b, T_TAXONOMY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_TAXONOMY);
    r = r && taxonomy_name(b, l + 1);
    r = r && consumeToken(b, T_OP_ASSIGN);
    r = r && taxonomy_term(b, l + 1);
    exit_section_(b, m, TAG_TAXONOMY_CONDITION, r);
    return r;
  }

  /* ********************************************************** */
  // tag (tag_attribute_assignment | tag_taxonomy_condition)*
  static boolean tag_with_attributes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_with_attributes")) return false;
    if (!nextTokenIs(b, "", T_DISAMBIGUATION, T_TAG)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = tag(b, l + 1);
    r = r && tag_with_attributes_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (tag_attribute_assignment | tag_taxonomy_condition)*
  private static boolean tag_with_attributes_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_with_attributes_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!tag_with_attributes_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tag_with_attributes_1", c)) break;
    }
    return true;
  }

  // tag_attribute_assignment | tag_taxonomy_condition
  private static boolean tag_with_attributes_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tag_with_attributes_1_0")) return false;
    boolean r;
    r = tag_attribute_assignment(b, l + 1);
    if (!r) r = tag_taxonomy_condition(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'take' '(' number_literal ')'
  public static boolean take(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "take")) return false;
    if (!nextTokenIs(b, T_TAKE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_TAKE, T_LP);
    r = r && number_literal(b, l + 1);
    r = r && consumeToken(b, T_RP);
    exit_section_(b, m, TAKE, r);
    return r;
  }

  /* ********************************************************** */
  // T_IDENTIFIER
  public static boolean taxonomy_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "taxonomy_name")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_IDENTIFIER);
    exit_section_(b, m, TAXONOMY_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // string_literal
  public static boolean taxonomy_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "taxonomy_term")) return false;
    if (!nextTokenIs(b, "<taxonomy term>", T_DOUBLE_QUOTE, T_SINGLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TAXONOMY_TERM, "<taxonomy term>");
    r = string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // node_opener antlers_expression_or_statement  node_closer
  public static boolean tine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tine")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TINE, "<tine>");
    r = node_opener(b, l + 1);
    r = r && antlers_expression_or_statement(b, l + 1);
    p = r; // pin = 2
    r = r && node_closer(b, l + 1);
    exit_section_(b, l, m, r, p, AntlersParser::antlers_node_recover);
    return r || p;
  }

  /* ********************************************************** */
  // ( yaml_frontmatter
  //         | block_wrapper
  //         | antlers_close_node
  //         | switch_node
  //         | tag_single
  //         | noparse_region
  //         | variable_assignment_node
  //         | recursive_children_node
  //         | tine
  //         | comment_block
  //         | unclosed_comment
  //         | yaml_unclosed_frontmatter
  //         | php_node
  //         | outer_content)*
  public static boolean tines(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tines")) return false;
    Marker m = enter_section_(b, l, _NONE_, TINES, "<tines>");
    while (true) {
      int c = current_position_(b);
      if (!tines_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "tines", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // yaml_frontmatter
  //         | block_wrapper
  //         | antlers_close_node
  //         | switch_node
  //         | tag_single
  //         | noparse_region
  //         | variable_assignment_node
  //         | recursive_children_node
  //         | tine
  //         | comment_block
  //         | unclosed_comment
  //         | yaml_unclosed_frontmatter
  //         | php_node
  //         | outer_content
  private static boolean tines_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tines_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = yaml_frontmatter(b, l + 1);
    if (!r) r = block_wrapper(b, l + 1);
    if (!r) r = antlers_close_node(b, l + 1);
    if (!r) r = switch_node(b, l + 1);
    if (!r) r = tag_single(b, l + 1);
    if (!r) r = noparse_region(b, l + 1);
    if (!r) r = variable_assignment_node(b, l + 1);
    if (!r) r = recursive_children_node(b, l + 1);
    if (!r) r = tine(b, l + 1);
    if (!r) r = comment_block(b, l + 1);
    if (!r) r = unclosed_comment(b, l + 1);
    if (!r) r = yaml_unclosed_frontmatter(b, l + 1);
    if (!r) r = php_node(b, l + 1);
    if (!r) r = outer_content(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // T_UNCLOSED_COMMENT
  static boolean unclosed_comment(PsiBuilder b, int l) {
    return consumeToken(b, T_UNCLOSED_COMMENT);
  }

  /* ********************************************************** */
  // '@'? (T_IDENTIFIER | T_SLOT) [property_access*]
  public static boolean variable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE, "<variable>");
    r = variable_0(b, l + 1);
    r = r && variable_1(b, l + 1);
    r = r && variable_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '@'?
  private static boolean variable_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_0")) return false;
    consumeToken(b, T_AT);
    return true;
  }

  // T_IDENTIFIER | T_SLOT
  private static boolean variable_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_1")) return false;
    boolean r;
    r = consumeToken(b, T_IDENTIFIER);
    if (!r) r = consumeToken(b, T_SLOT);
    return r;
  }

  // [property_access*]
  private static boolean variable_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_2")) return false;
    variable_2_0(b, l + 1);
    return true;
  }

  // property_access*
  private static boolean variable_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_2_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!property_access(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variable_2_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // node_opener variable T_OP_ASSIGN assignable_items node_closer
  public static boolean variable_assignment_node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_assignment_node")) return false;
    if (!nextTokenIs(b, T_LD)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_ASSIGNMENT_NODE, null);
    r = node_opener(b, l + 1);
    r = r && variable(b, l + 1);
    r = r && consumeToken(b, T_OP_ASSIGN);
    p = r; // pin = 3
    r = r && report_error_(b, assignable_items(b, l + 1));
    r = p && node_closer(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // T_IDENTIFIER T_OP_ASSIGN string_literal
  public static boolean variable_attribute_assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_attribute_assignment")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_ATTRIBUTE_ASSIGNMENT, null);
    r = consumeTokens(b, 2, T_IDENTIFIER, T_OP_ASSIGN);
    p = r; // pin = 2
    r = r && string_literal(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // 'where' '(' [where_arrow_func] (expr) ')'
  public static boolean where(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "where")) return false;
    if (!nextTokenIs(b, T_WHERE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, T_WHERE, T_LP);
    r = r && where_2(b, l + 1);
    r = r && where_3(b, l + 1);
    r = r && consumeToken(b, T_RP);
    exit_section_(b, m, WHERE, r);
    return r;
  }

  // [where_arrow_func]
  private static boolean where_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "where_2")) return false;
    where_arrow_func(b, l + 1);
    return true;
  }

  // (expr)
  private static boolean where_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "where_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // arrow_func
  public static boolean where_arrow_func(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "where_arrow_func")) return false;
    if (!nextTokenIs(b, T_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arrow_func(b, l + 1);
    exit_section_(b, m, WHERE_ARROW_FUNC, r);
    return r;
  }

  /* ********************************************************** */
  // T_FRONTMATTER_DELIMITER T_FRONTMATTER_CONTENT* T_FRONTMATTER_DELIMITER
  public static boolean yaml_frontmatter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yaml_frontmatter")) return false;
    if (!nextTokenIs(b, T_FRONTMATTER_DELIMITER)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, YAML_FRONTMATTER, null);
    r = consumeToken(b, T_FRONTMATTER_DELIMITER);
    p = r; // pin = 1
    r = r && report_error_(b, yaml_frontmatter_1(b, l + 1));
    r = p && consumeToken(b, T_FRONTMATTER_DELIMITER) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // T_FRONTMATTER_CONTENT*
  private static boolean yaml_frontmatter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "yaml_frontmatter_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, T_FRONTMATTER_CONTENT)) break;
      if (!empty_element_parsed_guard_(b, "yaml_frontmatter_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // UNCLOSED_FRONT_MATTER
  static boolean yaml_unclosed_frontmatter(PsiBuilder b, int l) {
    return consumeToken(b, UNCLOSED_FRONT_MATTER);
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: ATOM(interpolated_statement)
  // 1: BINARY(and_expr) BINARY(or_expr) BINARY(xor_expr)
  // 2: BINARY(eq_expr) BINARY(neq_expr) BINARY(ident_expr) BINARY(not_ident_expr)
  //    BINARY(lt_expr) BINARY(lte_expr) BINARY(gt_expr) BINARY(gte_expr)
  //    BINARY(spaceship_expr) BINARY(null_coalescing_expr) BINARY(gatekeeper_expr) BINARY(tenary_expr)
  // 3: BINARY(add_expr) BINARY(sub_expr)
  // 4: BINARY(mul_expr) BINARY(div_expr) BINARY(mod_expr)
  // 5: BINARY(pow_expr)
  // 6: PREFIX(unary_minus_expr) PREFIX(unary_not_expr) POSTFIX(unary_factorial_expr)
  // 7: ATOM(concat_expr)
  // 8: ATOM(literal_expr) ATOM(sub_expression)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = interpolated_statement(b, l + 1);
    if (!r) r = unary_minus_expr(b, l + 1);
    if (!r) r = unary_not_expr(b, l + 1);
    if (!r) r = concat_expr(b, l + 1);
    if (!r) r = literal_expr(b, l + 1);
    if (!r) r = sub_expression(b, l + 1);
    p = r;
    r = r && expr_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expr_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 1 && and_expr_0(b, l + 1)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, AND_EXPR, r, true, null);
      }
      else if (g < 1 && or_expr_0(b, l + 1)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, OR_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, T_OP_XOR)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, XOR_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_EQ)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, EQ_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_NEQ)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, NEQ_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_IDENT)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, IDENT_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_NOT_IDENT)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, NOT_IDENT_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_LT)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, LT_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_LTE)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, LTE_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_GT)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, GT_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_GTE)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, GTE_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_SPACESHIP)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, SPACESHIP_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_NULL_COALESCENCE)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, NULL_COALESCING_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_GATEKEEPER)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, GATEKEEPER_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, T_OP_QUESTIONMARK)) {
        r = report_error_(b, expr(b, l, 2));
        r = tenary_expr_1(b, l + 1) && r;
        exit_section_(b, l, m, TENARY_EXPR, r, true, null);
      }
      else if (g < 3 && add_expr_0(b, l + 1)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, ADD_EXPR, r, true, null);
      }
      else if (g < 3 && sub_expr_0(b, l + 1)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, SUB_EXPR, r, true, null);
      }
      else if (g < 4 && mul_expr_0(b, l + 1)) {
        r = expr(b, l, 4);
        exit_section_(b, l, m, MUL_EXPR, r, true, null);
      }
      else if (g < 4 && div_expr_0(b, l + 1)) {
        r = expr(b, l, 4);
        exit_section_(b, l, m, DIV_EXPR, r, true, null);
      }
      else if (g < 4 && mod_expr_0(b, l + 1)) {
        r = expr(b, l, 4);
        exit_section_(b, l, m, MOD_EXPR, r, true, null);
      }
      else if (g < 5 && consumeTokenSmart(b, T_OP_POW)) {
        r = expr(b, l, 5);
        exit_section_(b, l, m, POW_EXPR, r, true, null);
      }
      else if (g < 6 && consumeTokenSmart(b, T_OP_EXCLAMATION_MARK)) {
        r = true;
        exit_section_(b, l, m, UNARY_FACTORIAL_EXPR, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // '{' (antlers_expression_or_statement | expr | tag_with_attributes) '}'
  public static boolean interpolated_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interpolated_statement")) return false;
    if (!nextTokenIsSmart(b, T_LEFT_BRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INTERPOLATED_STATEMENT, null);
    r = consumeTokenSmart(b, T_LEFT_BRACE);
    p = r; // pin = 1
    r = r && report_error_(b, interpolated_statement_1(b, l + 1));
    r = p && consumeToken(b, T_RIGHT_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // antlers_expression_or_statement | expr | tag_with_attributes
  private static boolean interpolated_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interpolated_statement_1")) return false;
    boolean r;
    r = antlers_expression_or_statement(b, l + 1);
    if (!r) r = expr(b, l + 1, -1);
    if (!r) r = tag_with_attributes(b, l + 1);
    return r;
  }

  // '&&' | 'and'
  private static boolean and_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "and_expr_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, "&&");
    if (!r) r = consumeTokenSmart(b, "and");
    return r;
  }

  // '||' | 'or'
  private static boolean or_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "or_expr_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, "||");
    if (!r) r = consumeTokenSmart(b, "or");
    return r;
  }

  // ':' expr
  private static boolean tenary_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tenary_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_COLON);
    r = r && expr(b, l + 1, -1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '+' | '+='
  private static boolean add_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "add_expr_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, T_OP_PLUS);
    if (!r) r = consumeTokenSmart(b, T_OP_SELF_ASSIGN_ADD);
    return r;
  }

  // '-' | '-='
  private static boolean sub_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_expr_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, T_OP_MINUS);
    if (!r) r = consumeTokenSmart(b, T_OP_SELF_ASSIGN_SUB);
    return r;
  }

  // '*' | '*='
  private static boolean mul_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_expr_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, T_OP_MUL);
    if (!r) r = consumeTokenSmart(b, T_OP_SELF_ASSIGN_MUL);
    return r;
  }

  // T_SLASH | T_OP_SELF_ASSIGN_DIV
  private static boolean div_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "div_expr_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, T_SLASH);
    if (!r) r = consumeTokenSmart(b, T_OP_SELF_ASSIGN_DIV);
    return r;
  }

  // '%' | '%='
  private static boolean mod_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mod_expr_0")) return false;
    boolean r;
    r = consumeTokenSmart(b, T_OP_MOD);
    if (!r) r = consumeTokenSmart(b, T_OP_SELF_ASSIGN_MOD);
    return r;
  }

  public static boolean unary_minus_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_minus_expr")) return false;
    if (!nextTokenIsSmart(b, T_OP_MINUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, T_OP_MINUS);
    p = r;
    r = p && expr(b, l, 6);
    exit_section_(b, l, m, UNARY_MINUS_EXPR, r, p, null);
    return r || p;
  }

  public static boolean unary_not_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_not_expr")) return false;
    if (!nextTokenIsSmart(b, T_OP_EXCLAMATION_MARK)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, null);
    r = consumeTokenSmart(b, T_OP_EXCLAMATION_MARK);
    p = r;
    r = p && expr(b, l, 6);
    exit_section_(b, l, m, UNARY_NOT_EXPR, r, p, null);
    return r || p;
  }

  // string_literal '+' string_literal
  //               | number_literal '+' string_literal
  //               | string_literal '+' number_literal
  //               | string_literal '+' variable
  //               | variable ('+' | '+=') string_literal
  public static boolean concat_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONCAT_EXPR, "<concat expr>");
    r = concat_expr_0(b, l + 1);
    if (!r) r = concat_expr_1(b, l + 1);
    if (!r) r = concat_expr_2(b, l + 1);
    if (!r) r = concat_expr_3(b, l + 1);
    if (!r) r = concat_expr_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // string_literal '+' string_literal
  private static boolean concat_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_literal(b, l + 1);
    r = r && consumeToken(b, T_OP_PLUS);
    r = r && string_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // number_literal '+' string_literal
  private static boolean concat_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat_expr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = number_literal(b, l + 1);
    r = r && consumeToken(b, T_OP_PLUS);
    r = r && string_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // string_literal '+' number_literal
  private static boolean concat_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat_expr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_literal(b, l + 1);
    r = r && consumeToken(b, T_OP_PLUS);
    r = r && number_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // string_literal '+' variable
  private static boolean concat_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat_expr_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = string_literal(b, l + 1);
    r = r && consumeToken(b, T_OP_PLUS);
    r = r && variable(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // variable ('+' | '+=') string_literal
  private static boolean concat_expr_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat_expr_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
    r = r && concat_expr_4_1(b, l + 1);
    r = r && string_literal(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '+' | '+='
  private static boolean concat_expr_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "concat_expr_4_1")) return false;
    boolean r;
    r = consumeTokenSmart(b, T_OP_PLUS);
    if (!r) r = consumeTokenSmart(b, T_OP_SELF_ASSIGN_ADD);
    return r;
  }

  // number_literal
  //                | boolean_literal
  //                | string_literal
  //                | variable variable_attribute_assignment*
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = number_literal(b, l + 1);
    if (!r) r = boolean_literal(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    if (!r) r = literal_expr_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // variable variable_attribute_assignment*
  private static boolean literal_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable(b, l + 1);
    r = r && literal_expr_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // variable_attribute_assignment*
  private static boolean literal_expr_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr_3_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!variable_attribute_assignment(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "literal_expr_3_1", c)) break;
    }
    return true;
  }

  // '(' (antlers_expression_or_statement | expr) ')'
  public static boolean sub_expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_expression")) return false;
    if (!nextTokenIsSmart(b, T_LP)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SUB_EXPRESSION, null);
    r = consumeTokenSmart(b, T_LP);
    p = r; // pin = 1
    r = r && report_error_(b, sub_expression_1(b, l + 1));
    r = p && consumeToken(b, T_RP) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // antlers_expression_or_statement | expr
  private static boolean sub_expression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sub_expression_1")) return false;
    boolean r;
    r = antlers_expression_or_statement(b, l + 1);
    if (!r) r = expr(b, l + 1, -1);
    return r;
  }

}
