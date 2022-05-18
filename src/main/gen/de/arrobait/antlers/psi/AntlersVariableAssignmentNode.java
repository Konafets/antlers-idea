// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntlersVariableAssignmentNode extends PsiElement {

  @Nullable
  AntlersArray getArray();

  @Nullable
  AntlersBooleanLiteral getBooleanLiteral();

  @NotNull
  List<AntlersExpr> getExprList();

  @Nullable
  AntlersNumberLiteral getNumberLiteral();

  @Nullable
  AntlersStringLiteral getStringLiteral();

  @NotNull
  List<AntlersVariable> getVariableList();

}
