// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntlersConditional extends PsiElement {

  @Nullable
  AntlersConditionalElse getConditionalElse();

  @NotNull
  List<AntlersConditionalElseif> getConditionalElseifList();

  @Nullable
  AntlersConditionalEnd getConditionalEnd();

  @NotNull
  AntlersConditionalStart getConditionalStart();

  @NotNull
  List<AntlersTines> getTinesList();

}
