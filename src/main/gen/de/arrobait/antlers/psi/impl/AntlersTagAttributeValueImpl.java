// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersStringLiteral;
import de.arrobait.antlers.psi.AntlersTagAttributeValue;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;

public class AntlersTagAttributeValueImpl extends ASTWrapperPsiElement implements AntlersTagAttributeValue {

  public AntlersTagAttributeValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitTagAttributeValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AntlersStringLiteral getStringLiteral() {
    return findNotNullChildByClass(AntlersStringLiteral.class);
  }

}
