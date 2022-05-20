// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntlersBracketPropertyAccess extends PsiElement {

  @Nullable
  AntlersColonPropertyAccess getColonPropertyAccess();

  @Nullable
  AntlersDotPropertyAccess getDotPropertyAccess();

  @Nullable
  AntlersInterpolatedStatement getInterpolatedStatement();

  @Nullable
  AntlersStringLiteral getStringLiteral();

  @Nullable
  PsiElement getTIntegerNumber();

}
