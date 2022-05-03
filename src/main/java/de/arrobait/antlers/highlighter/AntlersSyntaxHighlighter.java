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
        fillMap(ATTRIBUTES, AntlersTokenSets.COMMENTS, AntlersHighlighter.COMMENT);
    }
}
