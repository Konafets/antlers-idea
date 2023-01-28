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

import static de.arrobait.antlers.psi.AntlersTypes.T_FLOAT_NUMBER;
import static de.arrobait.antlers.psi.AntlersTypes.T_INTEGER_NUMBER;

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
  public PsiElement getTFloatNumber() {
    return findChildByType(T_FLOAT_NUMBER);
  }

  @Override
  @Nullable
  public PsiElement getTIntegerNumber() {
    return findChildByType(T_INTEGER_NUMBER);
  }

}
