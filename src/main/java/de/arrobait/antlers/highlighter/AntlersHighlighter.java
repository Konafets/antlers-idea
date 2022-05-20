package de.arrobait.antlers.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class AntlersHighlighter {
    public static final TextAttributesKey ADVANCED_OPERATORS = createTextAttributesKey("ADVANCED_OPERATORS", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey BOOLEAN = createTextAttributesKey("BOOLEAN_LITERAL", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey BRACES = createTextAttributesKey("BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey BRACKETS = createTextAttributesKey("BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey COMMA = createTextAttributesKey("COMMA", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("ANTLERS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey MODIFIER = createTextAttributesKey("MODIFIER", DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey OPERATOR = createTextAttributesKey("OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey PARENTHESES = createTextAttributesKey("PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey SEMICOLON = createTextAttributesKey("SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON);
    public static final TextAttributesKey STRING = createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey TAG = createTextAttributesKey("TAG", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    public static final TextAttributesKey TAG_CONDITION = createTextAttributesKey("TAG_CONDITION", DefaultLanguageHighlighterColors.LABEL);
    public static final TextAttributesKey TAG_METHOD_NAME = createTextAttributesKey("TAG_METHOD_NAME", DefaultLanguageHighlighterColors.PARAMETER);
    public static final TextAttributesKey TAG_DISAMBIGUATION = createTextAttributesKey("TAG_DISAMBIGUATION", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey TAG_SHORTHAND_SEPARATOR = createTextAttributesKey("TAG_SHORTHAND_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
}
