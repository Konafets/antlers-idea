// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import de.arrobait.antlers.psi.AntlersTag;
import de.arrobait.antlers.psi.AntlersTagMethodPart;
import de.arrobait.antlers.psi.AntlersTagName;
import de.arrobait.antlers.psi.AntlersVisitor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersTagImpl extends ASTWrapperPsiElement implements AntlersTag {

  public AntlersTagImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitTag(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersTagMethodPart getTagMethodPart() {
    return findChildByClass(AntlersTagMethodPart.class);
  }

  @Override
  @NotNull
  public AntlersTagName getTagName() {
    return findNotNullChildByClass(AntlersTagName.class);
  }

}
