// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntlersLiteralExpr extends AntlersExpr {

  @Nullable
  AntlersBooleanLiteral getBooleanLiteral();

  @Nullable
  AntlersNumberLiteral getNumberLiteral();

  @Nullable
  AntlersStringLiteral getStringLiteral();

  @Nullable
  AntlersVariable getVariable();

}
