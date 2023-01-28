// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public interface AntlersSingleAdvancedOperator extends PsiElement {

  @Nullable
  AntlersGroupby getGroupby();

  @Nullable
  AntlersMerge getMerge();

  @Nullable
  AntlersOrderby getOrderby();

  @Nullable
  AntlersPluck getPluck();

  @Nullable
  AntlersSkip getSkip();

  @Nullable
  AntlersTake getTake();

  @Nullable
  AntlersWhere getWhere();

}
