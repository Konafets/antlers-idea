// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface AntlersVariable extends PsiElement {

  @NotNull
  List<AntlersBracketPropertyAccess> getBracketPropertyAccessList();

  @NotNull
  List<AntlersColonPropertyAccess> getColonPropertyAccessList();

  @NotNull
  List<AntlersDotPropertyAccess> getDotPropertyAccessList();

}
