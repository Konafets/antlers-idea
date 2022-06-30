package de.arrobait.antlers.psi;

import com.intellij.psi.tree.IElementType;

public interface AntlersCustomElementTypes {
    IElementType OUTER_ELEMENT_TYPE = new AntlersElementType("ANTLERS_FRAGMENT");
    IElementType UNCLOSED_COMMENT = new AntlersElementType("UNCLOSED_COMMENT");
}
