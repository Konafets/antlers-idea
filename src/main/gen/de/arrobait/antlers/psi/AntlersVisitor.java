// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class AntlersVisitor extends PsiElementVisitor {

  public void visitAntlersNode(@NotNull AntlersAntlersNode o) {
    visitPsiElement(o);
  }

  public void visitBooleanLiteral(@NotNull AntlersBooleanLiteral o) {
    visitPsiElement(o);
  }

  public void visitCommentBlock(@NotNull AntlersCommentBlock o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull AntlersExpr o) {
    visitPsiElement(o);
  }

  public void visitLiteralExpr(@NotNull AntlersLiteralExpr o) {
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

  public void visitStringLiteral(@NotNull AntlersStringLiteral o) {
    visitPsiElement(o);
  }

  public void visitVariable(@NotNull AntlersVariable o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
