// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public interface AntlersTagPair extends AntlersPsiElement {

  @NotNull
  AntlersTagNodeClose getTagNodeClose();

  @NotNull
  AntlersTagNodeOpen getTagNodeOpen();

  @NotNull
  AntlersTines getTines();

  String getName();

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
