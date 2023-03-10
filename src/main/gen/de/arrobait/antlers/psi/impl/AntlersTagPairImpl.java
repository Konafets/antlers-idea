// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersTagPairImpl extends ASTWrapperPsiElement implements AntlersTagPair {

  public AntlersTagPairImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitTagPair(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AntlersTagNodeClose getTagNodeClose() {
    return findNotNullChildByClass(AntlersTagNodeClose.class);
  }

  @Override
  @NotNull
  public AntlersTagNodeOpen getTagNodeOpen() {
    return findNotNullChildByClass(AntlersTagNodeOpen.class);
  }

  @Override
  @NotNull
  public AntlersTines getTines() {
    return findNotNullChildByClass(AntlersTines.class);
  }

  @Override
  @NotNull
  public String getName() {
    return AntlersPsiImplUtil.getName(this);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return AntlersPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  @NotNull
  public ItemPresentation getPresentation() {
    return AntlersPsiImplUtil.getPresentation(this);
  }

}
