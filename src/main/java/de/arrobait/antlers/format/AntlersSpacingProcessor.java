package de.arrobait.antlers.format;

import com.intellij.formatting.Block;
import com.intellij.formatting.Spacing;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import de.arrobait.antlers.psi.AntlersTokenSets;
import org.jetbrains.annotations.NotNull;

import static de.arrobait.antlers.psi.AntlersTypes.*;

public class AntlersSpacingProcessor {
    private final ASTNode myNode;
    private final CommonCodeStyleSettings mySettings;

    private static final TokenSet TOKENS_WITH_SPACE_BEFORE = TokenSet.create(
            T_RD
    );
    private static final TokenSet TOKENS_WITH_SPACE_AFTER = TokenSet.create(
            T_COMMA,
            T_LD
    );

    public AntlersSpacingProcessor(@NotNull ASTNode node, CommonCodeStyleSettings settings) {
        this.myNode = node;
        this.mySettings = settings;
    }

    public Spacing getSpacing(final Block child1, final Block child2) {
        if (!(child1 instanceof AbstractBlock) || !(child2 instanceof AbstractBlock)) {
            return null;
        }

        final IElementType elementType = myNode.getElementType();
        final IElementType parentType = myNode.getTreeParent() == null ? null : myNode.getTreeParent().getElementType();
        final ASTNode node1 = ((AbstractBlock) child1).getNode();
        final IElementType type1 = node1.getElementType();
        final ASTNode node2 = ((AbstractBlock) child2).getNode();
        final IElementType type2 = node2.getElementType();

        // Here we add a single space around operators, except the colon in the property access
        if (elementType != COLON_PROPERTY_ACCESS) {
            if (AntlersTokenSets.OPERATORS.contains(type1) || AntlersTokenSets.OPERATORS.contains(type2)) {
                return addSingleSpace();
            }
        }

        // Handle spaces before a token: [foo,bar] -> [foo, bar]
        if (TOKENS_WITH_SPACE_BEFORE.contains(type2)) {
            return addSingleSpace();
        }

        // Handle spaces after a token: [foo,bar] -> [foo, bar]
        if (TOKENS_WITH_SPACE_AFTER.contains(type1)) {
            return addSingleSpace();
        }

        return Spacing.createSpacing(0, 1, 0, mySettings.KEEP_LINE_BREAKS, mySettings.KEEP_BLANK_LINES_IN_CODE);
    }

    private Spacing addSingleSpace() {
        return Spacing.createSpacing(1, 1, 0, false, mySettings.KEEP_BLANK_LINES_IN_CODE);
    }
}
