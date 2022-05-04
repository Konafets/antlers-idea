package de.arrobait.antlers.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.TokenSet;

public class AntlersTokenSets {
    public static final TokenSet BOOLEANS;
    public static final TokenSet BRACES;
    public static final TokenSet COMMENTS;
    public static final TokenSet WHITE_SPACE;

    private AntlersTokenSets() {}

    static {
        BOOLEANS = TokenSet.create(
                AntlersTypes.T_TRUE,
                AntlersTypes.T_FALSE);
        BRACES = TokenSet.create(
                AntlersTypes.T_LD,
                AntlersTypes.T_RD);
        COMMENTS = TokenSet.create(
                AntlersTypes.T_COMMENT_OPEN,
                AntlersTypes.T_COMMENT_CLOSE,
                AntlersTypes.T_COMMENT_TEXT);
        WHITE_SPACE = TokenSet.create(
                TokenType.WHITE_SPACE);

    }
}
