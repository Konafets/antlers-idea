// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static de.arrobait.antlers.psi.AntlersTypes.T_INTEGER_NUMBER;

public class AntlersBracketPropertyAccessImpl extends ASTWrapperPsiElement implements AntlersBracketPropertyAccess {

  public AntlersBracketPropertyAccessImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitBracketPropertyAccess(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersColonPropertyAccess getColonPropertyAccess() {
    return findChildByClass(AntlersColonPropertyAccess.class);
  }

  @Override
  @Nullable
  public AntlersDotPropertyAccess getDotPropertyAccess() {
    return findChildByClass(AntlersDotPropertyAccess.class);
  }

  @Override
  @Nullable
  public AntlersInterpolatedStatement getInterpolatedStatement() {
    return findChildByClass(AntlersInterpolatedStatement.class);
  }

  @Override
  @Nullable
  public AntlersStringLiteral getStringLiteral() {
    return findChildByClass(AntlersStringLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getTIntegerNumber() {
    return findChildByType(T_INTEGER_NUMBER);
  }

}
