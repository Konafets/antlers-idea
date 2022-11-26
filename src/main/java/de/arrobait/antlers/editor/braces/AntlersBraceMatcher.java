package de.arrobait.antlers.editor.braces;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.psi.AntlersTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = new BracePair[] {
            new BracePair(AntlersTypes.T_LD, AntlersTypes.T_RD, false),
            new BracePair(AntlersTypes.T_COMMENT_OPEN, AntlersTypes.T_COMMENT_CLOSE, false),
            new BracePair(AntlersTypes.T_PHP_ECHO_OPEN, AntlersTypes.T_PHP_ECHO_CLOSE, false),
            new BracePair(AntlersTypes.T_PHP_RAW_OPEN, AntlersTypes.T_PHP_RAW_CLOSE, false),
            new BracePair(AntlersTypes.T_LEFT_BRACE, AntlersTypes.T_RIGHT_BRACE, false),
            new BracePair(AntlersTypes.T_LEFT_BRACKET, AntlersTypes.T_RIGHT_BRACKET, false),
            new BracePair(AntlersTypes.T_LP, AntlersTypes.T_RP, false),
    };

    @Override
    public BracePair @NotNull [] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return false;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
