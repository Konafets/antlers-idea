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

public class AntlersConditionalImpl extends ASTWrapperPsiElement implements AntlersConditional {

  public AntlersConditionalImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitConditional(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public AntlersConditionalElse getConditionalElse() {
    return findChildByClass(AntlersConditionalElse.class);
  }

  @Override
  @NotNull
  public List<AntlersConditionalElseif> getConditionalElseifList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersConditionalElseif.class);
  }

  @Override
  @Nullable
  public AntlersConditionalEnd getConditionalEnd() {
    return findChildByClass(AntlersConditionalEnd.class);
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

  @Override
  @NotNull
  public List<AntlersTines> getTinesList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersTines.class);
  }

}
