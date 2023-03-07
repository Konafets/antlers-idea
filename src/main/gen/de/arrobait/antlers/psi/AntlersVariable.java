// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersVariable extends AntlersPsiElement {

  @NotNull
  List<AntlersBracketPropertyAccess> getBracketPropertyAccessList();

  @NotNull
  List<AntlersColonPropertyAccess> getColonPropertyAccessList();

  @NotNull
  List<AntlersDotPropertyAccess> getDotPropertyAccessList();

  @Nullable
  PsiElement getTIdentifier();

}
