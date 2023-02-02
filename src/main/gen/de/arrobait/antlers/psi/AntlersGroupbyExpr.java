// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersGroupbyExpr extends AntlersExpr {

  @NotNull
  List<AntlersExpr> getExprList();

  @NotNull
  List<AntlersGroupbyArg> getGroupbyArgList();

  @Nullable
  AntlersGroupbyArgsList getGroupbyArgsList();

  @Nullable
  AntlersStringLiteral getStringLiteral();

}
