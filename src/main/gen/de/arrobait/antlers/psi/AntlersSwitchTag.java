// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntlersSwitchTag extends PsiElement {

  @Nullable
  AntlersDefaultCase getDefaultCase();

  @NotNull
  List<AntlersSwitchCase> getSwitchCaseList();

}
