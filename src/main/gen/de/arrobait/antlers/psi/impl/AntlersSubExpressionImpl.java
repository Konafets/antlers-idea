// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.psi.AntlersExpr;
import de.arrobait.antlers.psi.AntlersModifierList;
import de.arrobait.antlers.psi.AntlersSubExpression;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersSubExpressionImpl extends AntlersExprImpl implements AntlersSubExpression {

  public AntlersSubExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitSubExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersExpr getExpr() {
    return findChildByClass(AntlersExpr.class);
  }

  @Override
  @NotNull
  public List<AntlersModifierList> getModifierListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersModifierList.class);
  }

}
