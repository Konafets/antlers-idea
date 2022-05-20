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

public class AntlersSingleAdvancedOperatorImpl extends ASTWrapperPsiElement implements AntlersSingleAdvancedOperator {

  public AntlersSingleAdvancedOperatorImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitSingleAdvancedOperator(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersGroupby getGroupby() {
    return findChildByClass(AntlersGroupby.class);
  }

  @Override
  @Nullable
  public AntlersMerge getMerge() {
    return findChildByClass(AntlersMerge.class);
  }

  @Override
  @Nullable
  public AntlersOrderby getOrderby() {
    return findChildByClass(AntlersOrderby.class);
  }

  @Override
  @Nullable
  public AntlersPluck getPluck() {
    return findChildByClass(AntlersPluck.class);
  }

  @Override
  @Nullable
  public AntlersSkip getSkip() {
    return findChildByClass(AntlersSkip.class);
  }

  @Override
  @Nullable
  public AntlersTake getTake() {
    return findChildByClass(AntlersTake.class);
  }

  @Override
  @Nullable
  public AntlersWhere getWhere() {
    return findChildByClass(AntlersWhere.class);
  }

}
