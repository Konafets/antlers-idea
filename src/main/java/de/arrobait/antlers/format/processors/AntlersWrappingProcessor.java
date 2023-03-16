package de.arrobait.antlers.format.processors;

import com.intellij.formatting.Wrap;
import com.intellij.formatting.WrapType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.psi.AntlersPsiUtil;

import static de.arrobait.antlers.psi.AntlersTypes.IF_STATEMENT;
import static de.arrobait.antlers.psi.AntlersTypes.UNLESS_STATEMENT;

public class AntlersWrappingProcessor {
    private final ASTNode myNode;

    public AntlersWrappingProcessor(ASTNode node) {
        myNode = node;
    }

    public Wrap createChildWrap(ASTNode child, Wrap defaultWrap) {
        final IElementType childType = child.getElementType();
        final IElementType elementType = myNode.getElementType();

        if (AntlersPsiUtil.hasElementType(myNode, IF_STATEMENT) || AntlersPsiUtil.hasElementType(myNode, UNLESS_STATEMENT)) {
            return Wrap.createWrap(WrapType.ALWAYS, false);
        }
//        if (isAttribute(child)) {
//            return Wrap.createWrap(getWrapType(myHtmlPolicy.getAttributesWrap()), false);
//        }

        return defaultWrap;
    }
}
