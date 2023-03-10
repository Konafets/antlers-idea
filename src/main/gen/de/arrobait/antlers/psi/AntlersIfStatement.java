// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersIfStatement extends AntlersPsiElement {

  @Nullable
  AntlersElseNode getElseNode();

  @NotNull
  List<AntlersElseifNode> getElseifNodeList();

  @Nullable
  AntlersIfCloseNode getIfCloseNode();

  @NotNull
  AntlersIfOpenNode getIfOpenNode();

  @NotNull
  List<AntlersTines> getTinesList();

  @Nullable
  PsiElement getNameIdentifier();

  @NotNull
  String getName();

  @NotNull
  ItemPresentation getPresentation();

}
