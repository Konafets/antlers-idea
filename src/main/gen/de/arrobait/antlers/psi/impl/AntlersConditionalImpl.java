// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersConditionalImpl extends ASTWrapperPsiElement implements AntlersConditional {

  public AntlersConditionalImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitConditional(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersBlockCloseNode getBlockCloseNode() {
    return findChildByClass(AntlersBlockCloseNode.class);
  }

  @Override
  @NotNull
  public AntlersBlockOpenNode getBlockOpenNode() {
    return findNotNullChildByClass(AntlersBlockOpenNode.class);
  }

  @Override
  @Nullable
  public AntlersConditionalElse getConditionalElse() {
    return findChildByClass(AntlersConditionalElse.class);
  }

  @Override
  @NotNull
  public List<AntlersConditionalElseif> getConditionalElseifList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersConditionalElseif.class);
  }

  @Override
  @NotNull
  public List<AntlersTines> getTinesList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersTines.class);
  }

}
