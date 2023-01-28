// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersOrderbyArg;
import de.arrobait.antlers.psi.AntlersOrderbyDirection;
import de.arrobait.antlers.psi.AntlersVariable;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;

public class AntlersOrderbyArgImpl extends ASTWrapperPsiElement implements AntlersOrderbyArg {

  public AntlersOrderbyArgImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitOrderbyArg(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AntlersOrderbyDirection getOrderbyDirection() {
    return findNotNullChildByClass(AntlersOrderbyDirection.class);
  }

  @Override
  @NotNull
  public AntlersVariable getVariable() {
    return findNotNullChildByClass(AntlersVariable.class);
  }

}
