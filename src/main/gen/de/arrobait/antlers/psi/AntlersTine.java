// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.navigation.ItemPresentation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersTine extends AntlersNamedElement {

  @NotNull
  AntlersExpr getExpr();

  @NotNull
  List<AntlersModifierList> getModifierListList();

  @Nullable
  AntlersNodeCloser getNodeCloser();

  @NotNull
  AntlersNodeOpener getNodeOpener();

  ItemPresentation getPresentation();

}
