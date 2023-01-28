// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.psi.AntlersModifierParam;
import de.arrobait.antlers.psi.AntlersModifierParamsList;
import de.arrobait.antlers.psi.AntlersStringLiteral;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersModifierParamsListImpl extends ASTWrapperPsiElement implements AntlersModifierParamsList {

  public AntlersModifierParamsListImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitModifierParamsList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AntlersModifierParam> getModifierParamList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersModifierParam.class);
  }

  @Override
  @Nullable
  public AntlersStringLiteral getStringLiteral() {
    return findChildByClass(AntlersStringLiteral.class);
  }

}
