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

public class AntlersArrayImpl extends ASTWrapperPsiElement implements AntlersArray {

  public AntlersArrayImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull AntlersVisitor visitor) {
    visitor.visitArray(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof AntlersVisitor) accept((AntlersVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<AntlersArray> getArrayList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersArray.class);
  }

  @Override
  @NotNull
  public List<AntlersNumberLiteral> getNumberLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersNumberLiteral.class);
  }

  @Override
  @NotNull
  public List<AntlersStringLiteral> getStringLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersStringLiteral.class);
  }

  @Override
  @NotNull
  public List<AntlersVariable> getVariableList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, AntlersVariable.class);
  }

}
