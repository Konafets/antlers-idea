// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static de.arrobait.antlers.psi.AntlersTypes.*;
import static de.arrobait.antlers.parser.AntlersParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

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
    create_token_set_(EXPR, LITERAL_EXPR),
  };

  /* ********************************************************** */
  // nodes*
  static boolean antlersFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlersFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nodes(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "antlersFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // expr
  static boolean antlers_expression_or_statement(PsiBuilder b, int l) {
    return expr(b, l + 1);
  }

  /* ********************************************************** */
  // '{{' antlers_expression_or_statement  '}}'
  public static boolean antlers_node(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlers_node")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ANTLERS_NODE, "<antlers node>");
    r = consumeToken(b, T_LD);
    r = r && antlers_expression_or_statement(b, l + 1);
    p = r; // pin = 2
    r = r && consumeToken(b, T_RD);
    exit_section_(b, l, m, r, p, AntlersParser::antlers_node_recover);
    return r || p;
  }

  /* ********************************************************** */
  // !('{{' | outer_content | '{{#' | '{{?' | '{{$')
  static boolean antlers_node_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlers_node_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !antlers_node_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '{{' | outer_content | '{{#' | '{{?' | '{{$'
  private static boolean antlers_node_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "antlers_node_recover_0")) return false;
    boolean r;
    r = consumeToken(b, T_LD);
    if (!r) r = outer_content(b, l + 1);
    if (!r) r = consumeToken(b, T_COMMENT_OPEN);
    if (!r) r = consumeToken(b, T_PHP_RAW_OPEN);
    if (!r) r = consumeToken(b, T_PHP_ECHO_OPEN);
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
  // group_primary
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPR, "<expr>");
    r = group_primary(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // literal_expr
  static boolean group_primary(PsiBuilder b, int l) {
    return literal_expr(b, l + 1);
  }

  /* ********************************************************** */
  // number_literal
  //                 | boolean_literal
  //                 | string_literal
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = number_literal(b, l + 1);
    if (!r) r = boolean_literal(b, l + 1);
    if (!r) r = string_literal(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // antlers_node
  //                 | comment_block
  //                 | php_node
  //                 | outer_content
  static boolean nodes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nodes")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = antlers_node(b, l + 1);
    if (!r) r = comment_block(b, l + 1);
    if (!r) r = php_node(b, l + 1);
    if (!r) r = outer_content(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // OUTER_CONTENT
  static boolean outer_content(PsiBuilder b, int l) {
    return consumeToken(b, OUTER_CONTENT);
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
  // T_STRING_START T_STRING_CONTENT* T_STRING_END
  public static boolean string_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal")) return false;
    if (!nextTokenIs(b, T_STRING_START)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, T_STRING_START);
    r = r && string_literal_1(b, l + 1);
    r = r && consumeToken(b, T_STRING_END);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

  // T_STRING_CONTENT*
  private static boolean string_literal_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_literal_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, T_STRING_CONTENT)) break;
      if (!empty_element_parsed_guard_(b, "string_literal_1", c)) break;
    }
    return true;
  }

}
