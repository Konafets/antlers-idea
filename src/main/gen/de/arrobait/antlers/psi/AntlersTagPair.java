// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.NotNull;

public interface AntlersTagPair extends AntlersPsiElement {

  @NotNull
  AntlersTagNodeClose getTagNodeClose();

  @NotNull
  AntlersTagNodeOpen getTagNodeOpen();

  @NotNull
  AntlersTines getTines();

  ItemPresentation getPresentation();

}
