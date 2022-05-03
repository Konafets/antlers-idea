package de.arrobait.antlers.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class AntlersHighlighter {
    public static final TextAttributesKey COMMENT = createTextAttributesKey("ANTLERS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
}
