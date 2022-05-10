// This is a generated file. Not intended for manual editing.
package de.arrobait.antlers.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface AntlersConditional extends PsiElement {

  @NotNull
  List<AntlersAntlersCloseNode> getAntlersCloseNodeList();

  @NotNull
  List<AntlersAntlersNode> getAntlersNodeList();

  @NotNull
  List<AntlersCommentBlock> getCommentBlockList();

  @NotNull
  List<AntlersConditional> getConditionalList();

  @Nullable
  AntlersConditionalElse getConditionalElse();

  @NotNull
  List<AntlersConditionalElseif> getConditionalElseifList();

  @Nullable
  AntlersConditionalEnd getConditionalEnd();

  @Nullable
  AntlersConditionalIf getConditionalIf();

  @Nullable
  AntlersConditionalUnless getConditionalUnless();

  @NotNull
  List<AntlersPhpEchoNode> getPhpEchoNodeList();

  @NotNull
  List<AntlersPhpRawNode> getPhpRawNodeList();

  @NotNull
  List<AntlersSwitchNode> getSwitchNodeList();

  @NotNull
  List<AntlersVariableAssignmentNode> getVariableAssignmentNodeList();

}