// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersSwitchTag extends AntlersPsiElement {

  @Nullable
  AntlersDefaultCase getDefaultCase();

  @NotNull
  List<AntlersSwitchCase> getSwitchCaseList();

  @Nullable
  AntlersSwitchClose getSwitchClose();

  @NotNull
  AntlersSwitchOpen getSwitchOpen();

}
