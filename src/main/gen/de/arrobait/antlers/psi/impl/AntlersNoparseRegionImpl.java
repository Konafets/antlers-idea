// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static de.arrobait.antlers.psi.AntlersTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import de.arrobait.antlers.psi.*;

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

}
