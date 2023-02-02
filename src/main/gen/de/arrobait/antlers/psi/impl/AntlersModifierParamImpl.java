// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersArray;
import de.arrobait.antlers.psi.AntlersLiteralExpr;
import de.arrobait.antlers.psi.AntlersModifierParam;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersModifierParamImpl extends ASTWrapperPsiElement implements AntlersModifierParam {

  public AntlersModifierParamImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitModifierParam(this);
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
  public AntlersLiteralExpr getLiteralExpr() {
    return findChildByClass(AntlersLiteralExpr.class);
  }

}
