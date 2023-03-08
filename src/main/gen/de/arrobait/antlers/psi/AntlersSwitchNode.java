// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface AntlersSwitchNode extends AntlersPsiElement {

  @Nullable
  AntlersNodeCloser getNodeCloser();

  @NotNull
  AntlersNodeOpener getNodeOpener();

  @NotNull
  AntlersSwitchTag getSwitchTag();

  String getName();

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
