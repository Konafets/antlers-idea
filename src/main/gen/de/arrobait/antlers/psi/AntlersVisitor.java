// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class AntlersVisitor extends PsiElementVisitor {

  public void visitAddExpr(@NotNull AntlersAddExpr o) {
    visitExpr(o);
  }

  public void visitAntlersNode(@NotNull AntlersAntlersNode o) {
    visitPsiElement(o);
  }

  public void visitArray(@NotNull AntlersArray o) {
    visitPsiElement(o);
  }

  public void visitBooleanLiteral(@NotNull AntlersBooleanLiteral o) {
    visitPsiElement(o);
  }

  public void visitBracketPropertyAccess(@NotNull AntlersBracketPropertyAccess o) {
    visitPsiElement(o);
  }

  public void visitColonPropertyAccess(@NotNull AntlersColonPropertyAccess o) {
    visitPsiElement(o);
  }

  public void visitCommentBlock(@NotNull AntlersCommentBlock o) {
    visitPsiElement(o);
  }

  public void visitConcatExpr(@NotNull AntlersConcatExpr o) {
    visitExpr(o);
  }

  public void visitDivExpr(@NotNull AntlersDivExpr o) {
    visitExpr(o);
  }

  public void visitDotPropertyAccess(@NotNull AntlersDotPropertyAccess o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull AntlersExpr o) {
    visitPsiElement(o);
  }

  public void visitInterpolatedStatement(@NotNull AntlersInterpolatedStatement o) {
    visitExpr(o);
  }

  public void visitLiteralExpr(@NotNull AntlersLiteralExpr o) {
    visitExpr(o);
  }

  public void visitModExpr(@NotNull AntlersModExpr o) {
    visitExpr(o);
  }

  public void visitMulExpr(@NotNull AntlersMulExpr o) {
    visitExpr(o);
  }

  public void visitNumberLiteral(@NotNull AntlersNumberLiteral o) {
    visitPsiElement(o);
  }

  public void visitPhpEchoNode(@NotNull AntlersPhpEchoNode o) {
    visitPsiElement(o);
  }

  public void visitPhpRawNode(@NotNull AntlersPhpRawNode o) {
    visitPsiElement(o);
  }

  public void visitPowExpr(@NotNull AntlersPowExpr o) {
    visitExpr(o);
  }

  public void visitStringLiteral(@NotNull AntlersStringLiteral o) {
    visitPsiElement(o);
  }

  public void visitSubExpr(@NotNull AntlersSubExpr o) {
    visitExpr(o);
  }

  public void visitSubExpression(@NotNull AntlersSubExpression o) {
    visitExpr(o);
  }

  public void visitUnaryFactorialExpr(@NotNull AntlersUnaryFactorialExpr o) {
    visitExpr(o);
  }

  public void visitUnaryMinusExpr(@NotNull AntlersUnaryMinusExpr o) {
    visitExpr(o);
  }

  public void visitUnaryNotExpr(@NotNull AntlersUnaryNotExpr o) {
    visitExpr(o);
  }

  public void visitVariable(@NotNull AntlersVariable o) {
    visitPsiElement(o);
  }

  public void visitVariableAssignmentNode(@NotNull AntlersVariableAssignmentNode o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
