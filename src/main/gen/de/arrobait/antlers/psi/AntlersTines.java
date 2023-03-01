// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface AntlersTines extends PsiElement {

  @NotNull
  List<AntlersAntlersCloseNode> getAntlersCloseNodeList();

  @NotNull
  List<AntlersBlockWrapper> getBlockWrapperList();

  @NotNull
  List<AntlersCommentBlock> getCommentBlockList();

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
  List<AntlersTagSingle> getTagSingleList();

  @NotNull
  List<AntlersTine> getTineList();

  @NotNull
  List<AntlersVariableAssignmentNode> getVariableAssignmentNodeList();

  @NotNull
  List<AntlersYamlFrontmatter> getYamlFrontmatterList();

}
