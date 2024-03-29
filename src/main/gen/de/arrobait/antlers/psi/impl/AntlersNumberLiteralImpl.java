// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersNumberLiteral;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static de.arrobait.antlers.psi.AntlersTypes.T_FLOAT;
import static de.arrobait.antlers.psi.AntlersTypes.T_INTEGER;

public class AntlersNumberLiteralImpl extends ASTWrapperPsiElement implements AntlersNumberLiteral {

  public AntlersNumberLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitNumberLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getTFloat() {
    return findChildByType(T_FLOAT);
  }

  @Override
  @Nullable
  public PsiElement getTInteger() {
    return findChildByType(T_INTEGER);
  }

}
