// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersUnlessStatement extends AntlersPsiElement {

  @Nullable
  AntlersElseNode getElseNode();

  @NotNull
  List<AntlersElseifNode> getElseifNodeList();

  @NotNull
  List<AntlersTines> getTinesList();

  @Nullable
  AntlersUnlessCloseNode getUnlessCloseNode();

  @NotNull
  AntlersUnlessOpenNode getUnlessOpenNode();

  ItemPresentation getPresentation();

}
