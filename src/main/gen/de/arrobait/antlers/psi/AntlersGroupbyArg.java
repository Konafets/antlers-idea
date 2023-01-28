// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersGroupbyArg extends PsiElement {

  @NotNull
  AntlersExpr getExpr();

  @Nullable
  AntlersGroupbyAlias getGroupbyAlias();

  @NotNull
  List<AntlersModifierList> getModifierListList();

}
