package de.arrobait.antlers.parser;

import com.intellij.lexer.MergeFunction;
import com.intellij.lexer.MergingLexerAdapterBase;
import de.arrobait.antlers.psi.AntlersTypes;

public class AntlersCustomLexer extends MergingLexerAdapterBase {
    private static final MergeFunction MERGE_FUNCTION = (type, originalLexer) -> {
        if (type != AntlersTypes.T_COMMENT_OPEN) {
            return type;
        }

        if (originalLexer.getTokenType() == AntlersTypes.T_COMMENT_TEXT) {
            originalLexer.advance();
        }

        if (originalLexer.getTokenType() == AntlersTypes.T_COMMENT_CLOSE) {
            originalLexer.advance();
            return AntlersTypes.COMMENT_BLOCK;
        }
//
//        if (originalLexer.getTokenType() == null) {
//            return AntlersTypes.UNCLOSED_COMMENT;
//        }
//
//        if (originalLexer.getTokenType() == AntlersTypes.UNCLOSED_COMMENT) {
//            originalLexer.advance();
//            return AntlersTypes.UNCLOSED_COMMENT;
//        }

        return type;
    };

    public AntlersCustomLexer() {
        super(new AntlersLexerAdapter());
    }

    @Override
    public MergeFunction getMergeFunction() {
        return MERGE_FUNCTION;
    }
}
