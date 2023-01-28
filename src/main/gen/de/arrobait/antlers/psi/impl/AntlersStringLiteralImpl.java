// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersStringLiteral;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static de.arrobait.antlers.psi.AntlersTypes.T_STRING_CONTENT;

public class AntlersStringLiteralImpl extends ASTWrapperPsiElement implements AntlersStringLiteral {

  public AntlersStringLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitStringLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PsiElement getTStringContent() {
    return findChildByType(T_STRING_CONTENT);
  }

}
