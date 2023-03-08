// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.Nullable;

public interface AntlersBlockWrapper extends AntlersPsiElement {

  @Nullable
  AntlersIfStatement getIfStatement();

  @Nullable
  AntlersTagPair getTagPair();

  @Nullable
  AntlersUnlessStatement getUnlessStatement();

  ItemPresentation getPresentation();

}
