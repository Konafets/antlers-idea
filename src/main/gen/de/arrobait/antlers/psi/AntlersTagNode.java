// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntlersTagNode extends PsiElement {

  @NotNull
  List<AntlersAntlersCloseNode> getAntlersCloseNodeList();

  @NotNull
  List<AntlersAntlersNode> getAntlersNodeList();

  @NotNull
  List<AntlersCommentBlock> getCommentBlockList();

  @NotNull
  List<AntlersConditional> getConditionalList();

  @NotNull
  List<AntlersNoparseRegion> getNoparseRegionList();

  @NotNull
  List<AntlersPhpEchoNode> getPhpEchoNodeList();

  @NotNull
  List<AntlersPhpRawNode> getPhpRawNodeList();

  @NotNull
  List<AntlersRecursiveChildrenNode> getRecursiveChildrenNodeList();

  @NotNull
  List<AntlersSwitchNode> getSwitchNodeList();

  @NotNull
  List<AntlersTagNode> getTagNodeList();

  @Nullable
  AntlersTagNodeClose getTagNodeClose();

  @NotNull
  AntlersTagNodeOpen getTagNodeOpen();

  @NotNull
  List<AntlersVariableAssignmentNode> getVariableAssignmentNodeList();

}
