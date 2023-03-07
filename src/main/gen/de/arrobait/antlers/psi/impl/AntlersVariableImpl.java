// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static de.arrobait.antlers.psi.AntlersTypes.T_IDENTIFIER;

public class AntlersVariableImpl extends ASTWrapperPsiElement implements AntlersVariable {

  public AntlersVariableImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitVariable(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AntlersBracketPropertyAccess> getBracketPropertyAccessList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersBracketPropertyAccess.class);
  }

  @Override
  @NotNull
  public List<AntlersColonPropertyAccess> getColonPropertyAccessList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersColonPropertyAccess.class);
  }

  @Override
  @NotNull
  public List<AntlersDotPropertyAccess> getDotPropertyAccessList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersDotPropertyAccess.class);
  }

  @Override
  @Nullable
  public PsiElement getTIdentifier() {
    return findChildByType(T_IDENTIFIER);
  }

}
