// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntlersConcatExpr extends AntlersExpr {

  @Nullable
  AntlersNumberLiteral getNumberLiteral();

  @NotNull
  List<AntlersStringLiteral> getStringLiteralList();

  @Nullable
  AntlersVariable getVariable();

}
