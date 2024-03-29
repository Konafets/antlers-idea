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

public class AntlersTagNodeOpenImpl extends ASTWrapperPsiElement implements AntlersTagNodeOpen {

  public AntlersTagNodeOpenImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitTagNodeOpen(this);
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
  public AntlersTag getTag() {
    return findNotNullChildByClass(AntlersTag.class);
  }

  @Override
  @NotNull
  public List<AntlersTagAttributeAssignment> getTagAttributeAssignmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersTagAttributeAssignment.class);
  }

  @Override
  @NotNull
  public List<AntlersTagTaxonomyCondition> getTagTaxonomyConditionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersTagTaxonomyCondition.class);
  }

}
