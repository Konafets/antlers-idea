// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.psi.AntlersExpr;
import de.arrobait.antlers.psi.AntlersNeqExpr;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AntlersNeqExprImpl extends AntlersExprImpl implements AntlersNeqExpr {

  public AntlersNeqExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitNeqExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AntlersExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersExpr.class);
  }

}
