package de.arrobait.antlers.psi;

import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.parser.AntlersOuterElementType;

public interface AntlersCustomElementTypes {
    AntlersOuterElementType OUTER_ANTLERS = new AntlersOuterElementType("ANTLERS_FRAGMENT");

    IElementType UNCLOSED_COMMENT = new AntlersElementType("UNCLOSED_COMMENT");
}
