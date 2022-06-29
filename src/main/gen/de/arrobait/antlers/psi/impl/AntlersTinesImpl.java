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

public class AntlersTinesImpl extends ASTWrapperPsiElement implements AntlersTines {

  public AntlersTinesImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitTines(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AntlersAntlersCloseNode> getAntlersCloseNodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersAntlersCloseNode.class);
  }

  @Override
  @NotNull
  public List<AntlersCommentBlock> getCommentBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersCommentBlock.class);
  }

  @Override
  @NotNull
  public List<AntlersConditional> getConditionalList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersConditional.class);
  }

  @Override
  @NotNull
  public List<AntlersNoparseRegion> getNoparseRegionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersNoparseRegion.class);
  }

  @Override
  @NotNull
  public List<AntlersPhpEchoNode> getPhpEchoNodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersPhpEchoNode.class);
  }

  @Override
  @NotNull
  public List<AntlersPhpRawNode> getPhpRawNodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersPhpRawNode.class);
  }

  @Override
  @NotNull
  public List<AntlersRecursiveChildrenNode> getRecursiveChildrenNodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersRecursiveChildrenNode.class);
  }

  @Override
  @NotNull
  public List<AntlersSwitchNode> getSwitchNodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersSwitchNode.class);
  }

  @Override
  @NotNull
  public List<AntlersTagNode> getTagNodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersTagNode.class);
  }

  @Override
  @NotNull
  public List<AntlersTine> getTineList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersTine.class);
  }

  @Override
  @NotNull
  public List<AntlersVariableAssignmentNode> getVariableAssignmentNodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersVariableAssignmentNode.class);
  }

}
