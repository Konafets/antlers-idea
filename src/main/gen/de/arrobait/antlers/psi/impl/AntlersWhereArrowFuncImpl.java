// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersVisitor;
import de.arrobait.antlers.psi.AntlersWhereArrowFunc;
import org.jetbrains.annotations.NotNull;

public class AntlersWhereArrowFuncImpl extends ASTWrapperPsiElement implements AntlersWhereArrowFunc {

  public AntlersWhereArrowFuncImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitWhereArrowFunc(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

}
