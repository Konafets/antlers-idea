// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersInterpolatedStatement;
import de.arrobait.antlers.psi.AntlersMerge;
import de.arrobait.antlers.psi.AntlersVariable;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersMergeImpl extends ASTWrapperPsiElement implements AntlersMerge {

  public AntlersMergeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitMerge(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersInterpolatedStatement getInterpolatedStatement() {
    return findChildByClass(AntlersInterpolatedStatement.class);
  }

  @Override
  @Nullable
  public AntlersVariable getVariable() {
    return findChildByClass(AntlersVariable.class);
  }

}
