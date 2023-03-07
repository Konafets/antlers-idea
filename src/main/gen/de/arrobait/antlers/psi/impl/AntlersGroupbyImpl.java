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

public class AntlersGroupbyImpl extends ASTWrapperPsiElement implements AntlersGroupby {

  public AntlersGroupbyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitGroupby(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AntlersGroupbyArg> getGroupbyArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersGroupbyArg.class);
  }

  @Override
  @Nullable
  public AntlersGroupbyArgsList getGroupbyArgsList() {
    return findChildByClass(AntlersGroupbyArgsList.class);
  }

  @Override
  @Nullable
  public AntlersStringLiteral getStringLiteral() {
    return findChildByClass(AntlersStringLiteral.class);
  }

  @Override
  @Nullable
  public PsiElement getTIdentifier() {
    return findChildByType(T_IDENTIFIER);
  }

}
