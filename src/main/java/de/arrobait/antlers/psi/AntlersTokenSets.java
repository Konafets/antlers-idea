package de.arrobait.antlers.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;

public class AntlersTokenSets {
    public static final TokenSet WHITE_SPACE;
    public static final TokenSet COMMENTS;

    private AntlersTokenSets() {}

    static {
        WHITE_SPACE = TokenSet.create(
                TokenType.WHITE_SPACE);
        COMMENTS = TokenSet.create(
                AntlersTypes.T_COMMENT_OPEN,
                AntlersTypes.T_COMMENT_CLOSE,
                AntlersTypes.T_COMMENT_TEXT);

    }
}
