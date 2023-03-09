package de.arrobait.antlers.psi.impl

import com.intellij.icons.AllIcons
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.util.PlatformIcons
import de.arrobait.antlers.file.AntlersIcons
import de.arrobait.antlers.psi.*
import icons.PhpIcons
import javax.swing.Icon

object AntlersPsiImplUtilKot {
    fun getName(element: PsiElement): String {
        var name = "Not yet implemented"

        when (element) {
            is AntlersSwitchNode -> {
                name = element.switchTag.firstChild.text
            }

            is AntlersVariableAssignmentNode, is AntlersPhpEchoNode, is AntlersPhpRawNode -> {
                name = element.text
            }

            is AntlersConditional -> {
                name = element.nameIdentifier.text
            }
        }

        return name
    }

    fun getNameIdentifier(element: PsiElement): PsiElement? {
        return element.node.findChildByType(AntlersTypes.TINE)?.psi
    }

    fun getNameIdentifier(element: AntlersConditional): PsiElement? {
        return element.node.firstChildNode.findChildByType(AntlersTypes.CONDITIONAL_IF)?.psi
    }

    fun getPresentation(node: AntlersTine): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.VARIABLE_ICON
            }
        }
    }

    fun getPresentation(node: AntlersCommentBlock): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return AntlersIcons.COMMENT
            }
        }
    }

    fun getPresentation(node: AntlersTagSingle): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return AllIcons.Nodes.Type
            }
        }
    }

    fun getPresentation(node: AntlersTagPair): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return AllIcons.Nodes.Type
            }
        }
    }

    fun getPresentation(node: AntlersBlockWrapper): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.XML_TAG_ICON
            }
        }
    }

    fun getPresentation(node: AntlersConditional): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.name
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.XML_TAG_ICON
            }
        }
    }

    fun getPresentation(node: AntlersSwitchNode): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return AntlersPsiImplUtil.getName(node)
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.XML_TAG_ICON
            }
        }
    }

    fun getPresentation(node: AntlersVariableAssignmentNode): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.VARIABLE_ICON
            }
        }
    }

    fun getPresentation(node: AntlersNoparseRegion): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.VARIABLE_ICON
            }
        }
    }

    fun getPresentation(node: AntlersRecursiveChildrenNode): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.VARIABLE_ICON
            }
        }
    }

    fun getPresentation(node: AntlersPhpEchoNode): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PhpIcons.PhpIcon
            }
        }
    }

    fun getPresentation(node: AntlersPhpRawNode): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getLocationString(): String? {
                return node.containingFile?.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PhpIcons.PhpIcon
            }
        }
    }
}
