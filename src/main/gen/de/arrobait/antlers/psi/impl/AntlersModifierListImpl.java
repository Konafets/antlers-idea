// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersModifierList;
import de.arrobait.antlers.psi.AntlersModifierParamsList;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static de.arrobait.antlers.psi.AntlersTypes.T_MODIFIER;

public class AntlersModifierListImpl extends ASTWrapperPsiElement implements AntlersModifierList {

  public AntlersModifierListImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitModifierList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersModifierParamsList getModifierParamsList() {
    return findChildByClass(AntlersModifierParamsList.class);
  }

  @Override
  @NotNull
  public PsiElement getTModifier() {
    return findNotNullChildByType(T_MODIFIER);
  }

}
