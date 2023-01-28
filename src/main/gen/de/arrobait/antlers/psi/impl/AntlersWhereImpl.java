// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersExpr;
import de.arrobait.antlers.psi.AntlersVisitor;
import de.arrobait.antlers.psi.AntlersWhere;
import de.arrobait.antlers.psi.AntlersWhereArrowFunc;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersWhereImpl extends ASTWrapperPsiElement implements AntlersWhere {

  public AntlersWhereImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitWhere(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AntlersExpr getExpr() {
    return findNotNullChildByClass(AntlersExpr.class);
  }

  @Override
  @Nullable
  public AntlersWhereArrowFunc getWhereArrowFunc() {
    return findChildByClass(AntlersWhereArrowFunc.class);
  }

}
