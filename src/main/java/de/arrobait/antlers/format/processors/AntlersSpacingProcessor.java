package de.arrobait.antlers.format.processors;

import com.intellij.formatting.Block;
import com.intellij.formatting.Spacing;
import com.intellij.lang.ASTNode;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.codeStyle.AntlersCodeStyleSettings;
import org.jetbrains.annotations.NotNull;

import static de.arrobait.antlers.psi.AntlersPsiUtil.hasElementType;
import static de.arrobait.antlers.psi.AntlersPsiUtil.isAttributeElement;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class AntlersSpacingProcessor {
    private final ASTNode myNode;
    private final CodeStyleSettings settings;

    public static final TokenSet ASSIGN = TokenSet.create(
            T_OP_ASSIGN,
            T_OP_SELF_ASSIGN_ADD,
            T_OP_SELF_ASSIGN_SUB,
            T_OP_SELF_ASSIGN_MUL,
            T_OP_SELF_ASSIGN_DIV,
            T_OP_SELF_ASSIGN_MOD
    );

    public static final TokenSet OPERATORS = TokenSet.create(
            T_COLON,
            T_DOT,
            T_OP_EXCLAMATION_MARK,
            T_OP_QUESTIONMARK,
            T_OP_PLUS,
            T_OP_MINUS,
            T_OP_MUL,
            T_SLASH,
            T_OP_MOD,
            T_OP_POW,
            T_OP_EQ,
            T_OP_NEQ,
            T_OP_IDENT,
            T_OP_NOT_IDENT,
            T_OP_LT,
            T_OP_LTE,
            T_OP_GT,
            T_OP_GTE,
            T_OP_SPACESHIP,
            T_OP_NULL_COALESCENCE,
            T_OP_GATEKEEPER,
            T_OP_AND,
            T_OP_OR,
            T_OP_XOR,
            T_OP_ARROW
    );

    public AntlersSpacingProcessor(@NotNull ASTNode node, CodeStyleSettings settings) {
        this.myNode = node;
        this.settings = settings;
    }

    public Spacing getSpacing(final Block child1, final Block child2) {
        if (!(child1 instanceof AbstractBlock) || !(child2 instanceof AbstractBlock)) {
            return null;
        }

        final IElementType elementType = myNode.getElementType();
        final IElementType parentType = myNode.getTreeParent() == null ? null : myNode.getTreeParent().getElementType();
        final ASTNode node1 = ((AbstractBlock) child1).getNode();
        final ASTNode node2 = ((AbstractBlock) child2).getNode();

        // Here we add a single space around operators, except the colon in the property access
        if (elementType != COLON_PROPERTY_ACCESS) {
            if (hasElementType(node1, OPERATORS) || hasElementType(node2, OPERATORS)) {
                if (settings.getCustomSettings(AntlersCodeStyleSettings.class).SPACE_AROUND_OPERATORS) {
                    return addSingleSpace();
                }
            }
        }

        if (hasElementType(node1, ASSIGN) || hasElementType(node2, ASSIGN)) {
            if (isAttributeElement(elementType)) {
                return Spacing.createSpacing(0, 0, 0, false, 1);
            } else if (settings.getCommonSettings(AntlersLanguage.INSTANCE).SPACE_AROUND_ASSIGNMENT_OPERATORS) {
                return addSingleSpace();
            }
        }

        if (hasElementType(node1, T_PIPE) || hasElementType(node2, T_PIPE)) {
            if (settings.getCustomSettings(AntlersCodeStyleSettings.class).SPACE_AROUND_MODIFIER_PIPE) {
                return addSingleSpace();
            }
        }

        if (hasElementType(node1, NODE_OPENER) || hasElementType(node2, NODE_CLOSER)) {
            if (settings.getCustomSettings(AntlersCodeStyleSettings.class).SPACE_AFTER_AND_BEFORE_ANTLERS_DELIMITERS) {
                return addSingleSpace();
            }
        }

        if (hasElementType(node1, T_COMMA)) {
            if (settings.getCommonSettings(AntlersLanguage.INSTANCE).SPACE_AFTER_COMMA) {
                return addSingleSpace();
            }
        }

//        return Spacing.createSpacing(0, 1, 0, settings.KEEP_LINE_BREAKS, settings.KEEP_BLANK_LINES_IN_CODE);
        return Spacing.createSpacing(0, 1, 0, true, 1);
    }

    private Spacing addSingleSpace() {
//        return Spacing.createSpacing(1, 1, 0, false, settings.KEEP_BLANK_LINES_IN_CODE);
        return Spacing.createSpacing(1, 1, 0, false, 1);
    }
}
