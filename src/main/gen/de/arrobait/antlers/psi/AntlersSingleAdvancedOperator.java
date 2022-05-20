// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

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
