package de.arrobait.antlers.file

import com.intellij.openapi.util.IconLoader

object AntlersIcons {
    @JvmField
    val FILE = IconLoader.getIcon("/icons/filetype.svg", AntlersIcons::class.java)

    @JvmField
    val DOUBLE_BRACES = IconLoader.getIcon("/icons/structuredView.svg", AntlersIcons::class.java)

    @JvmField
    val COMMENT = IconLoader.getIcon("/icons/comment.svg", AntlersIcons::class.java)
}
