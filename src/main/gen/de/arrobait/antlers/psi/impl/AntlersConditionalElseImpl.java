// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersConditionalElse;
import de.arrobait.antlers.psi.AntlersNodeCloser;
import de.arrobait.antlers.psi.AntlersNodeOpener;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersConditionalElseImpl extends ASTWrapperPsiElement implements AntlersConditionalElse {

  public AntlersConditionalElseImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitConditionalElse(this);
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

}
