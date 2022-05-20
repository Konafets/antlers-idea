// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntlersGroupby extends PsiElement {

  @NotNull
  List<AntlersGroupbyArg> getGroupbyArgList();

  @Nullable
  AntlersGroupbyArgsList getGroupbyArgsList();

  @Nullable
  AntlersStringLiteral getStringLiteral();

}
