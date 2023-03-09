package de.arrobait.antlers.psi.impl;

import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.util.PlatformIcons;
import de.arrobait.antlers.file.AntlersIcons;
import de.arrobait.antlers.psi.*;
import icons.PhpIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public final class AntlersPsiImplUtil {
    public static String getName(PsiElement element) {
        String name = "Not yet implemented";
        if (element instanceof AntlersSwitchNode) {
            name = "{{ " + ((AntlersSwitchNode) element).getNameIdentifier().getText() + " }}";
        } else if (element instanceof AntlersVariableAssignmentNode) {
            name = element.getText();
        } else if (element instanceof AntlersPhpEchoNode || element instanceof AntlersPhpRawNode) {
            name = element.getText();
        } else if (element instanceof AntlersIfStatement) {
            name = ((AntlersIfStatement) element).getNameIdentifier().getText();
        } else if (element instanceof AntlersUnlessStatement) {
            name = ((AntlersUnlessStatement) element).getNameIdentifier().getText();
        } else if (element instanceof AntlersTagPair) {
            name = "{{ " + ((AntlersTagPair) element).getNameIdentifier().getText() + " }}";
        } else if (element instanceof AntlersNoparseRegion) {
            name = ((AntlersNoparseRegion) element).getNameIdentifier().getText();
        }

        return name;
    }

    public static PsiElement getNameIdentifier(PsiElement element) {
        ASTNode keyNode = element.getNode().findChildByType(AntlersTypes.TINE);

        return keyNode == null ? null : keyNode.getPsi();
    }

    public static PsiElement getNameIdentifier(AntlersIfStatement element) {
        ASTNode keyNode = element.getNode().getFirstChildNode().findChildByType(AntlersTypes.IF_STATEMENT);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement getNameIdentifier(AntlersUnlessStatement element) {
        ASTNode keyNode = element.getNode().getFirstChildNode().findChildByType(AntlersTypes.UNLESS_STATEMENT);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static PsiElement getNameIdentifier(AntlersSwitchNode element) {
        ASTNode keyNode = element.getSwitchTag().getFirstChild().getNode();

        return keyNode == null ? null : keyNode.getPsi();
    }

    public static PsiElement getNameIdentifier(AntlersTagPair element) {
        ASTNode keyNode = element.getNode().getLastChildNode().findChildByType(AntlersTypes.TAG);

        return keyNode == null ? null : keyNode.getPsi();
    }

    public static PsiElement getNameIdentifier(AntlersNoparseRegion element) {
        ASTNode keyNode = element.getNode().getFirstChildNode();

        return keyNode == null ? null : keyNode.getPsi();
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersTine tine) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return tine.getText();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = tine.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            @Nullable
            public Icon getIcon(boolean unused) {
                return PlatformIcons.VARIABLE_ICON;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersCommentBlock commentBlock) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return commentBlock.getText();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = commentBlock.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return AntlersIcons.COMMENT;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersTagSingle tagSingle) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return tagSingle.getText();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = tagSingle.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return AllIcons.Nodes.Type;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersTagPair tagPair) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return tagPair.getName();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = tagPair.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return AllIcons.Nodes.Type;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersBlockWrapper blockWrapper) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return blockWrapper.getText();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = blockWrapper.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return PlatformIcons.XML_TAG_ICON;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersIfStatement ifStatement) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return ifStatement.getName();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = ifStatement.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return AllIcons.Vcs.Branch;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersUnlessStatement unlessStatement) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return unlessStatement.getName();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = unlessStatement.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return PlatformIcons.XML_TAG_ICON;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersSwitchNode switchNode) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return switchNode.getName();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = switchNode.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return PlatformIcons.XML_TAG_ICON;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersVariableAssignmentNode variableAssignmentNode) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return variableAssignmentNode.getText();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = variableAssignmentNode.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return PlatformIcons.VARIABLE_ICON;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersNoparseRegion noparseRegion) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return noparseRegion.getName();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = noparseRegion.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return PlatformIcons.VARIABLE_ICON;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersRecursiveChildrenNode recursiveChildrenNode) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return recursiveChildrenNode.getText();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = recursiveChildrenNode.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return PlatformIcons.VARIABLE_ICON;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersPhpEchoNode phpEchoNode) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return phpEchoNode.getText();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = phpEchoNode.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return PhpIcons.PhpIcon;
            }
        };
    }

    public static ItemPresentation getPresentation(@NotNull final AntlersPhpRawNode rawNode) {
        return new ItemPresentation() {
            @Override
            public String getPresentableText() {
                return rawNode.getText();
            }

            @Override
            @Nullable
            public String getLocationString() {
                PsiFile containingFile = rawNode.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return PhpIcons.PhpIcon;
            }
        };
    }
}
