// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersCommentBlock;
import de.arrobait.antlers.psi.AntlersVisitor;
import de.arrobait.antlers.psi.mixins.AntlersCommentMixin;
import org.jetbrains.annotations.NotNull;

public class AntlersCommentBlockImpl extends AntlersCommentMixin implements AntlersCommentBlock {

  public AntlersCommentBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitCommentBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

}
