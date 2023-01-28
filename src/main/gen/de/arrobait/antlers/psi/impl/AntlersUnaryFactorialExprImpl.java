// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersExpr;
import de.arrobait.antlers.psi.AntlersUnaryFactorialExpr;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;

public class AntlersUnaryFactorialExprImpl extends AntlersExprImpl implements AntlersUnaryFactorialExpr {

  public AntlersUnaryFactorialExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitUnaryFactorialExpr(this);
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

}
