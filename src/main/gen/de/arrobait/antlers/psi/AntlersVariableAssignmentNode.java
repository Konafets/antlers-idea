// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersVariableAssignmentNode extends PsiElement {

  @Nullable
  AntlersArray getArray();

  @Nullable
  AntlersBooleanLiteral getBooleanLiteral();

  @Nullable
  AntlersExpr getExpr();

  @Nullable
  AntlersNodeCloser getNodeCloser();

  @NotNull
  AntlersNodeOpener getNodeOpener();

  @Nullable
  AntlersNumberLiteral getNumberLiteral();

  @NotNull
  List<AntlersSingleAdvancedOperator> getSingleAdvancedOperatorList();

  @Nullable
  AntlersStringLiteral getStringLiteral();

  @NotNull
  List<AntlersVariable> getVariableList();

}
