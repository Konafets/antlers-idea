// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersTenaryExpr extends AntlersExpr {

  @NotNull
  List<AntlersExpr> getExprList();

  @Nullable
  AntlersTenaryBranchOp getTenaryBranchOp();

}
