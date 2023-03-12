package de.arrobait.antlers.psi.impl

import com.intellij.icons.AllIcons
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.util.PlatformIcons
import de.arrobait.antlers.file.AntlersIcons
import de.arrobait.antlers.psi.*
import icons.PhpIcons
import javax.swing.Icon

object AntlersPsiImplUtil {
    @JvmStatic
    fun getName(element: PsiElement): String {
        var name = "Not yet implemented"

        when (element) {
            is AntlersSwitchNode -> {
                name = "{{ " + element.nameIdentifier!!.text + " }}"
            }

            is AntlersVariableAssignmentNode, is AntlersPhpEchoNode, is AntlersPhpRawNode -> {
                name = element.text
            }

            is AntlersIfStatement -> {
                name = element.nameIdentifier?.text ?: name
            }

            is AntlersUnlessStatement -> {
                name = element.nameIdentifier?.text ?: name
            }

            is AntlersTagPair -> {
                name = "{{ " + (element).nameIdentifier!!.text + " }}"
            }

            is AntlersNoparseRegion -> {
                name = (element).nameIdentifier!!.text
            }
        }

        return name
    }

    @JvmStatic
    fun getNameIdentifier(element: PsiElement): PsiElement? {
        return element.node.findChildByType(AntlersTypes.TINE)?.psi
    }

    @JvmStatic
    fun getNameIdentifier(element: AntlersIfStatement): PsiElement? {
        val keyNode = element.node.firstChildNode

        return keyNode?.psi
    }

    @JvmStatic
    fun getNameIdentifier(element: AntlersUnlessStatement): PsiElement? {
        val keyNode = element.node.firstChildNode

        return keyNode?.psi
    }

    @JvmStatic
    fun getNameIdentifier(element: AntlersSwitchNode): PsiElement? {
        val keyNode = element.switchTag.firstChild.node

        return keyNode?.psi
    }

    @JvmStatic
    fun getNameIdentifier(element: AntlersTagPair): PsiElement? {
        val keyNode = element.node.lastChildNode.findChildByType(AntlersTypes.TAG)

        return keyNode?.psi
    }

    @JvmStatic
    fun getNameIdentifier(element: AntlersNoparseRegion): PsiElement? {
        val keyNode = element.node.firstChildNode

        return keyNode?.psi
    }

    @JvmStatic
    fun getPresentation(node: AntlersTine): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.VARIABLE_ICON
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersCommentBlock): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getIcon(unused: Boolean): Icon {
                return AntlersIcons.COMMENT
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersTagSingle): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getIcon(unused: Boolean): Icon {
                return AllIcons.Nodes.Type
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersTagPair): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String {
                return node.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return AllIcons.Nodes.Type
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersBlockWrapper): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.XML_TAG_ICON
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersIfStatement): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String {
                return node.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.XML_TAG_ICON
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersUnlessStatement): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String {
                return node.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.XML_TAG_ICON
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersSwitchNode): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String {
                return node.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.XML_TAG_ICON
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersVariableAssignmentNode): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.VARIABLE_ICON
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersNoparseRegion): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String {
                return node.name
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.VARIABLE_ICON
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersRecursiveChildrenNode): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getIcon(unused: Boolean): Icon {
                return PlatformIcons.VARIABLE_ICON
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersPhpEchoNode): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getIcon(unused: Boolean): Icon {
                return PhpIcons.PhpIcon
            }
        }
    }

    @JvmStatic
    fun getPresentation(node: AntlersPhpRawNode): ItemPresentation {
        return object : ItemPresentation {
            override fun getPresentableText(): String? {
                return node.text
            }

            override fun getIcon(unused: Boolean): Icon {
                return PhpIcons.PhpIcon
            }
        }
    }
}
