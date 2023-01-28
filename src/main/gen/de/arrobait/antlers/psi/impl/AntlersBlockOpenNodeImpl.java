// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersBlockOpenNode;
import de.arrobait.antlers.psi.AntlersConditionalIf;
import de.arrobait.antlers.psi.AntlersConditionalUnless;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersBlockOpenNodeImpl extends ASTWrapperPsiElement implements AntlersBlockOpenNode {

  public AntlersBlockOpenNodeImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitBlockOpenNode(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersConditionalIf getConditionalIf() {
    return findChildByClass(AntlersConditionalIf.class);
  }

  @Override
  @Nullable
  public AntlersConditionalUnless getConditionalUnless() {
    return findChildByClass(AntlersConditionalUnless.class);
  }

}
