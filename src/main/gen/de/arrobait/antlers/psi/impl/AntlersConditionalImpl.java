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
  @NotNull
  public List<AntlersAntlersCloseNode> getAntlersCloseNodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersAntlersCloseNode.class);
  }

  @Override
  @NotNull
  public List<AntlersAntlersNode> getAntlersNodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersAntlersNode.class);
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
  @Nullable
  public AntlersConditionalEnd getConditionalEnd() {
    return findChildByClass(AntlersConditionalEnd.class);
  }

  @Override
  @Nullable
  public AntlersConditionalIf getConditionalIf() {
    return findChildByClass(AntlersConditionalIf.class);
  }

  @Override
  @Nullable
  public AntlersConditionalUnless getConditionalUnless() {
    return findChildByClass(AntlersConditionalUnless.class);
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
  public List<AntlersVariableAssignmentNode> getVariableAssignmentNodeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersVariableAssignmentNode.class);
  }

}
