// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static de.arrobait.antlers.psi.AntlersTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import de.arrobait.antlers.psi.*;

public class AntlersAntlersCloseNodeImpl extends ASTWrapperPsiElement implements AntlersAntlersCloseNode {

  public AntlersAntlersCloseNodeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitAntlersCloseNode(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public AntlersVariable getVariable() {
    return findNotNullChildByClass(AntlersVariable.class);
  }

}
