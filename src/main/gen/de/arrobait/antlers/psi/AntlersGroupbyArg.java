// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersGroupbyArg extends AntlersPsiElement {

  @NotNull
  AntlersExpr getExpr();

  @Nullable
  AntlersGroupbyAlias getGroupbyAlias();

  @NotNull
  List<AntlersModifierList> getModifierListList();

}
