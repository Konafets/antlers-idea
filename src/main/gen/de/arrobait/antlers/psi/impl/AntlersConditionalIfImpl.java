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

public class AntlersConditionalIfImpl extends ASTWrapperPsiElement implements AntlersConditionalIf {

  public AntlersConditionalIfImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitConditionalIf(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersExpr getExpr() {
    return findChildByClass(AntlersExpr.class);
  }

  @Override
  @NotNull
  public List<AntlersModifierList> getModifierListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersModifierList.class);
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
