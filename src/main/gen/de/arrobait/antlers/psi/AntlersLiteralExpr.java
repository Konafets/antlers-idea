// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersLiteralExpr extends AntlersExpr {

  @Nullable
  AntlersBooleanLiteral getBooleanLiteral();

  @Nullable
  AntlersNumberLiteral getNumberLiteral();

  @Nullable
  AntlersStringLiteral getStringLiteral();

  @Nullable
  AntlersVariable getVariable();

  @NotNull
  List<AntlersVariableAttributeAssignment> getVariableAttributeAssignmentList();

}
