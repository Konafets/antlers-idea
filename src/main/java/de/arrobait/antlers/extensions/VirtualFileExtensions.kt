package de.arrobait.antlers.extensions

import com.intellij.openapi.fileTypes.FileTypeRegistry
import com.intellij.openapi.vfs.VirtualFile
import de.arrobait.antlers.file.AntlersFileType

fun VirtualFile.isAntlersFile() = FileTypeRegistry.getInstance().isFileOfType(this, AntlersFileType.INSTANCE)
