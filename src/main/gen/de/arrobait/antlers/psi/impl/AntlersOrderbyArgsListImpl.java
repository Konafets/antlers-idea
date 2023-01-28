// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import de.arrobait.antlers.psi.AntlersOrderbyArg;
import de.arrobait.antlers.psi.AntlersOrderbyArgsList;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AntlersOrderbyArgsListImpl extends ASTWrapperPsiElement implements AntlersOrderbyArgsList {

  public AntlersOrderbyArgsListImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitOrderbyArgsList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AntlersOrderbyArg> getOrderbyArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersOrderbyArg.class);
  }

}
