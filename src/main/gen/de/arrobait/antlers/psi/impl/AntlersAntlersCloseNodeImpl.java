// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersAntlersCloseNodeImpl extends ASTWrapperPsiElement implements AntlersAntlersCloseNode {

  public AntlersAntlersCloseNodeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitAntlersCloseNode(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersNodeCloser getNodeCloser() {
    return findChildByClass(AntlersNodeCloser.class);
  }

  @Override
  @NotNull
  public AntlersNodeOpener getNodeOpener() {
    return findNotNullChildByClass(AntlersNodeOpener.class);
  }

  @Override
  @NotNull
  public AntlersVariable getVariable() {
    return findNotNullChildByClass(AntlersVariable.class);
  }

}
