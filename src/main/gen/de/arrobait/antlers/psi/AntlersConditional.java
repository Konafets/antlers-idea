// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersConditional extends PsiElement {

  @Nullable
  AntlersBlockCloseNode getBlockCloseNode();

  @NotNull
  AntlersBlockOpenNode getBlockOpenNode();

  @Nullable
  AntlersConditionalElse getConditionalElse();

  @NotNull
  List<AntlersConditionalElseif> getConditionalElseifList();

  @NotNull
  List<AntlersTines> getTinesList();

}
