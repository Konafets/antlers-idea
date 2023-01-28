// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersTagAttributeAssignment;
import de.arrobait.antlers.psi.AntlersTagAttributeKey;
import de.arrobait.antlers.psi.AntlersTagAttributeValue;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;

public class AntlersTagAttributeAssignmentImpl extends ASTWrapperPsiElement implements AntlersTagAttributeAssignment {

  public AntlersTagAttributeAssignmentImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitTagAttributeAssignment(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AntlersTagAttributeKey getTagAttributeKey() {
    return findNotNullChildByClass(AntlersTagAttributeKey.class);
  }

  @Override
  @NotNull
  public AntlersTagAttributeValue getTagAttributeValue() {
    return findNotNullChildByClass(AntlersTagAttributeValue.class);
  }

}
