// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersTagNodeOpen extends AntlersPsiElement {

  @Nullable
  AntlersNodeCloser getNodeCloser();

  @NotNull
  AntlersNodeOpener getNodeOpener();

  @NotNull
  AntlersTag getTag();

  @NotNull
  List<AntlersTagAttributeAssignment> getTagAttributeAssignmentList();

  @NotNull
  List<AntlersTagTaxonomyCondition> getTagTaxonomyConditionList();

}
