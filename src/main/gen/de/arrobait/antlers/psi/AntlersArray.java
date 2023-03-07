// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface AntlersArray extends AntlersPsiElement {

  @NotNull
  List<AntlersArray> getArrayList();

  @NotNull
  List<AntlersNumberLiteral> getNumberLiteralList();

  @NotNull
  List<AntlersStringLiteral> getStringLiteralList();

  @NotNull
  List<AntlersVariable> getVariableList();

}
