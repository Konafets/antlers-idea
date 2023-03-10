// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AntlersNoparseRegion extends AntlersPsiElement {

  @Nullable
  AntlersNoparseRegionClose getNoparseRegionClose();

  @NotNull
  AntlersNoparseRegionOpen getNoparseRegionOpen();

  @Nullable
  AntlersTines getTines();

  @NotNull
  String getName();

  @Nullable
  PsiElement getNameIdentifier();

  @NotNull
  ItemPresentation getPresentation();

}
