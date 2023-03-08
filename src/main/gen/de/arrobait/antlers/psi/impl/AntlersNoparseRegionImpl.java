// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersNoparseRegionImpl extends ASTWrapperPsiElement implements AntlersNoparseRegion {

  public AntlersNoparseRegionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitNoparseRegion(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersNoparseRegionClose getNoparseRegionClose() {
    return findChildByClass(AntlersNoparseRegionClose.class);
  }

  @Override
  @NotNull
  public AntlersNoparseRegionOpen getNoparseRegionOpen() {
    return findNotNullChildByClass(AntlersNoparseRegionOpen.class);
  }

  @Override
  @Nullable
  public AntlersTines getTines() {
    return findChildByClass(AntlersTines.class);
  }

  @Override
  public ItemPresentation getPresentation() {
    return AntlersPsiImplUtil.getPresentation(this);
  }

}
