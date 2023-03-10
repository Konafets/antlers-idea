// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AntlersTagPair extends AntlersPsiElement {

  @NotNull
  AntlersTagNodeClose getTagNodeClose();

  @NotNull
  AntlersTagNodeOpen getTagNodeOpen();

  @NotNull
  AntlersTines getTines();

  @NotNull
  String getName();

  @Nullable
  PsiElement getNameIdentifier();

  @NotNull
  ItemPresentation getPresentation();

}
