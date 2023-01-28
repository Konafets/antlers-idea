package de.arrobait.antlers.highlighter;

import com.intellij.openapi.fileTypes.SingleLazyInstanceSyntaxHighlighterFactory;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import org.jetbrains.annotations.NotNull;

public class AntlersSyntaxHighlighterFactory extends SingleLazyInstanceSyntaxHighlighterFactory {
    @Override
    @NotNull
    public SyntaxHighlighter createHighlighter() {
        return new AntlersSyntaxHighlighter();
    }
}
