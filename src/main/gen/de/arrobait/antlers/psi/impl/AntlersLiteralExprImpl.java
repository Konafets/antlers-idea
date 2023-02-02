// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersLiteralExprImpl extends AntlersExprImpl implements AntlersLiteralExpr {

  public AntlersLiteralExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitLiteralExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersBooleanLiteral getBooleanLiteral() {
    return findChildByClass(AntlersBooleanLiteral.class);
  }

  @Override
  @Nullable
  public AntlersNumberLiteral getNumberLiteral() {
    return findChildByClass(AntlersNumberLiteral.class);
  }

  @Override
  @Nullable
  public AntlersStringLiteral getStringLiteral() {
    return findChildByClass(AntlersStringLiteral.class);
  }

  @Override
  @Nullable
  public AntlersVariable getVariable() {
    return findChildByClass(AntlersVariable.class);
  }

  @Override
  @NotNull
  public List<AntlersVariableAttributeAssignment> getVariableAttributeAssignmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersVariableAttributeAssignment.class);
  }

}
