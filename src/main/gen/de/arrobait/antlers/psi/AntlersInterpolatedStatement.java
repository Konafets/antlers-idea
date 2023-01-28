// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface AntlersInterpolatedStatement extends AntlersExpr {

  @Nullable
  AntlersExpr getExpr();

  @NotNull
  List<AntlersModifierList> getModifierListList();

  @Nullable
  AntlersTag getTag();

  @NotNull
  List<AntlersTagAttributeAssignment> getTagAttributeAssignmentList();

  @NotNull
  List<AntlersTagTaxonomyCondition> getTagTaxonomyConditionList();

}
