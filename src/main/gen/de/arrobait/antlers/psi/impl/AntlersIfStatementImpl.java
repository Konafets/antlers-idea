// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersIfStatementImpl extends ASTWrapperPsiElement implements AntlersIfStatement {

  public AntlersIfStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitIfStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersElseNode getElseNode() {
    return findChildByClass(AntlersElseNode.class);
  }

  @Override
  @NotNull
  public List<AntlersElseifNode> getElseifNodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersElseifNode.class);
  }

  @Override
  @Nullable
  public AntlersIfCloseNode getIfCloseNode() {
    return findChildByClass(AntlersIfCloseNode.class);
  }

  @Override
  @NotNull
  public AntlersIfOpenNode getIfOpenNode() {
    return findNotNullChildByClass(AntlersIfOpenNode.class);
  }

  @Override
  @NotNull
  public List<AntlersTines> getTinesList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersTines.class);
  }

  @Override
  @Nullable
  public PsiElement getNameIdentifier() {
    return AntlersPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  @NotNull
  public String getName() {
    return AntlersPsiImplUtil.getName(this);
  }

  @Override
  @NotNull
  public ItemPresentation getPresentation() {
    return AntlersPsiImplUtil.getPresentation(this);
  }

}
