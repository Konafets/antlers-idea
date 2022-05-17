// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static de.arrobait.antlers.psi.AntlersTypes.*;
import de.arrobait.antlers.psi.*;

public class AntlersInterpolatedStatementImpl extends AntlersExprImpl implements AntlersInterpolatedStatement {

  public AntlersInterpolatedStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitInterpolatedStatement(this);
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
  public AntlersTag getTag() {
    return findChildByClass(AntlersTag.class);
  }

  @Override
  @NotNull
  public List<AntlersTagAttributeAssignment> getTagAttributeAssignmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersTagAttributeAssignment.class);
  }

}
