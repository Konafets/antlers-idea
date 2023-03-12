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

public class AntlersUnlessStatementImpl extends ASTWrapperPsiElement implements AntlersUnlessStatement {

  public AntlersUnlessStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitUnlessStatement(this);
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
  @NotNull
  public List<AntlersTines> getTinesList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersTines.class);
  }

  @Override
  @Nullable
  public AntlersUnlessCloseNode getUnlessCloseNode() {
    return findChildByClass(AntlersUnlessCloseNode.class);
  }

  @Override
  @NotNull
  public AntlersUnlessOpenNode getUnlessOpenNode() {
    return findNotNullChildByClass(AntlersUnlessOpenNode.class);
  }

}
