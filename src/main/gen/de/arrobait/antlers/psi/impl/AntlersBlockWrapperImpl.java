// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersBlockWrapper;
import de.arrobait.antlers.psi.AntlersConditional;
import de.arrobait.antlers.psi.AntlersTagPair;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersBlockWrapperImpl extends ASTWrapperPsiElement implements AntlersBlockWrapper {

  public AntlersBlockWrapperImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitBlockWrapper(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersConditional getConditional() {
    return findChildByClass(AntlersConditional.class);
  }

  @Override
  @Nullable
  public AntlersTagPair getTagPair() {
    return findChildByClass(AntlersTagPair.class);
  }

}
