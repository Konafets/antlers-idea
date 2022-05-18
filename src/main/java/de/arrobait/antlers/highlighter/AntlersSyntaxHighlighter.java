package de.arrobait.antlers.highlighter;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.parser.AntlersLexerAdapter;
import de.arrobait.antlers.psi.AntlersTokenSets;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class AntlersSyntaxHighlighter extends SyntaxHighlighterBase {
    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<>();

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new AntlersLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        TextAttributesKey key = ATTRIBUTES.get(tokenType);

        return (key != null) ? pack(key) : new TextAttributesKey[0];
    }

    static {
        fillMap(ATTRIBUTES, AntlersTokenSets.ADVANCED_OPERATORS, AntlersHighlighter.ADVANCED_OPERATORS);
        fillMap(ATTRIBUTES, AntlersTokenSets.BOOLEANS, AntlersHighlighter.BOOLEAN);
        fillMap(ATTRIBUTES, AntlersTokenSets.BRACES, AntlersHighlighter.BRACES);
        fillMap(ATTRIBUTES, AntlersTokenSets.BRACKETS, AntlersHighlighter.BRACKETS);
        fillMap(ATTRIBUTES, AntlersTokenSets.COMMA, AntlersHighlighter.COMMA);
        fillMap(ATTRIBUTES, AntlersTokenSets.COMMENTS, AntlersHighlighter.COMMENT);
        fillMap(ATTRIBUTES, AntlersTokenSets.IDENTIFIER, AntlersHighlighter.IDENTIFIER);
        fillMap(ATTRIBUTES, AntlersTokenSets.KEYWORDS, AntlersHighlighter.KEYWORD);
        fillMap(ATTRIBUTES, AntlersTokenSets.MODIFIERS, AntlersHighlighter.MODIFIER);
        fillMap(ATTRIBUTES, AntlersTokenSets.NUMBERS, AntlersHighlighter.NUMBER);
        fillMap(ATTRIBUTES, AntlersTokenSets.OPERATORS, AntlersHighlighter.OPERATOR);
        fillMap(ATTRIBUTES, AntlersTokenSets.PARENTHESES, AntlersHighlighter.PARENTHESES);
        fillMap(ATTRIBUTES, AntlersTokenSets.STRINGS, AntlersHighlighter.STRING);
        fillMap(ATTRIBUTES, AntlersTokenSets.TAGS, AntlersHighlighter.TAG);
        fillMap(ATTRIBUTES, AntlersTokenSets.TAG_METHOD_NAMES, AntlersHighlighter.TAG_METHOD_NAME);
        fillMap(ATTRIBUTES, AntlersTokenSets.TAG_DISAMBIGUATION, AntlersHighlighter.TAG_DISAMBIGUATION);
        fillMap(ATTRIBUTES, AntlersTokenSets.TAG_SHORTHAND_SEPARATOR, AntlersHighlighter.TAG_SHORTHAND_SEPARATOR);
    }
}
