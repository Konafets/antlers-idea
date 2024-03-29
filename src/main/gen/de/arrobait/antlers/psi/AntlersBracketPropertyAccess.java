// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface AntlersBracketPropertyAccess extends AntlersPsiElement {

  @Nullable
  AntlersColonPropertyAccess getColonPropertyAccess();

  @Nullable
  AntlersDotPropertyAccess getDotPropertyAccess();

  @Nullable
  AntlersInterpolatedStatement getInterpolatedStatement();

  @Nullable
  AntlersStringLiteral getStringLiteral();

  @Nullable
  PsiElement getTIdentifier();

  @Nullable
  PsiElement getTInteger();

}
