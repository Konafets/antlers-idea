package de.arrobait.antlers.parser;

import com.intellij.lexer.Lexer;
import com.intellij.lexer.MergeFunction;
import com.intellij.lexer.MergingLexerAdapterBase;
import com.intellij.psi.tree.IElementType;

import static de.arrobait.antlers.psi.AntlersTypes.*;

public class AntlersLexer extends MergingLexerAdapterBase {
    private static final MergeFunction MERGE_FUNCTION = new MergeFunction() {
        @Override
        public IElementType merge(IElementType type, Lexer originalLexer) {
            if (type != T_COMMENT_OPEN) {
                return type;
            }

            if (originalLexer.getTokenType() == T_COMMENT_TEXT) {
                originalLexer.advance();
            }

            if (originalLexer.getTokenType() == T_COMMENT_CLOSE) {
                originalLexer.advance();
                return COMMENT_BLOCK;
            }

            if (originalLexer.getTokenType() == null) {
                return T_UNCLOSED_COMMENT;
            }

            if (originalLexer.getTokenType() == T_UNCLOSED_COMMENT) {
                originalLexer.advance();
                return T_UNCLOSED_COMMENT;
            }

            return type;
        }
    };

    public AntlersLexer() {
        super(new AntlersLexerAdapter());
    }

    @Override
    public MergeFunction getMergeFunction() {
        return MERGE_FUNCTION;
    }
}
