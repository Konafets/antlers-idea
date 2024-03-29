// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersConcatExprImpl extends AntlersExprImpl implements AntlersConcatExpr {

  public AntlersConcatExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitConcatExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersNumberLiteral getNumberLiteral() {
    return findChildByClass(AntlersNumberLiteral.class);
  }

  @Override
  @NotNull
  public List<AntlersStringLiteral> getStringLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersStringLiteral.class);
  }

  @Override
  @Nullable
  public AntlersVariable getVariable() {
    return findChildByClass(AntlersVariable.class);
  }

}
