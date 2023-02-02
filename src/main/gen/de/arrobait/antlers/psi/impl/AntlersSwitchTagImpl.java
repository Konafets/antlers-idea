// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.psi.AntlersDefaultCase;
import de.arrobait.antlers.psi.AntlersSwitchCase;
import de.arrobait.antlers.psi.AntlersSwitchTag;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersSwitchTagImpl extends ASTWrapperPsiElement implements AntlersSwitchTag {

  public AntlersSwitchTagImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitSwitchTag(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersDefaultCase getDefaultCase() {
    return findChildByClass(AntlersDefaultCase.class);
  }

  @Override
  @NotNull
  public List<AntlersSwitchCase> getSwitchCaseList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersSwitchCase.class);
  }

}
