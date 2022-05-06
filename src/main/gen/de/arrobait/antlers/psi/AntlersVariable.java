// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntlersVariable extends PsiElement {

  @NotNull
  List<AntlersBracketPropertyAccess> getBracketPropertyAccessList();

  @NotNull
  List<AntlersColonPropertyAccess> getColonPropertyAccessList();

  @NotNull
  List<AntlersDotPropertyAccess> getDotPropertyAccessList();

}
