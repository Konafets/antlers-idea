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

public class AntlersVariableAssignmentNodeImpl extends ASTWrapperPsiElement implements AntlersVariableAssignmentNode {

  public AntlersVariableAssignmentNodeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitVariableAssignmentNode(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersArray getArray() {
    return findChildByClass(AntlersArray.class);
  }

  @Override
  @Nullable
  public AntlersBooleanLiteral getBooleanLiteral() {
    return findChildByClass(AntlersBooleanLiteral.class);
  }

  @Override
  @Nullable
  public AntlersExpr getExpr() {
    return findChildByClass(AntlersExpr.class);
  }

  @Override
  @Nullable
  public AntlersNumberLiteral getNumberLiteral() {
    return findChildByClass(AntlersNumberLiteral.class);
  }

  @Override
  @NotNull
  public List<AntlersSingleAdvancedOperator> getSingleAdvancedOperatorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersSingleAdvancedOperator.class);
  }

  @Override
  @Nullable
  public AntlersStringLiteral getStringLiteral() {
    return findChildByClass(AntlersStringLiteral.class);
  }

  @Override
  @NotNull
  public List<AntlersVariable> getVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersVariable.class);
  }

}
