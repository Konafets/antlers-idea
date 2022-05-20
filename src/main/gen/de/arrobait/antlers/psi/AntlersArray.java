// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntlersArray extends PsiElement {

  @NotNull
  List<AntlersArray> getArrayList();

  @NotNull
  List<AntlersNumberLiteral> getNumberLiteralList();

  @NotNull
  List<AntlersStringLiteral> getStringLiteralList();

  @NotNull
  List<AntlersVariable> getVariableList();

}
