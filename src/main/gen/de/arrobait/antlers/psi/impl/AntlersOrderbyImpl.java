// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersOrderby;
import de.arrobait.antlers.psi.AntlersOrderbyArgsList;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;

public class AntlersOrderbyImpl extends ASTWrapperPsiElement implements AntlersOrderby {

  public AntlersOrderbyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitOrderby(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AntlersOrderbyArgsList getOrderbyArgsList() {
    return findNotNullChildByClass(AntlersOrderbyArgsList.class);
  }

}
