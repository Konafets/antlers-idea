// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersVariableAssignmentNode extends AntlersPsiElement {

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

  @NotNull
  ItemPresentation getPresentation();

}
