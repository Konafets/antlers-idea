package de.arrobait.antlers.highlighter;

import com.intellij.codeHighlighting.RainbowHighlighter;
import com.intellij.openapi.editor.XmlHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.file.AntlersIcons;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class AntlersColorSettingsPage implements ColorSettingsPage {
    private static final SyntaxHighlighter SYNTAX_HIGHLIGHTER;
    private static final AttributesDescriptor[] DESCRIPTORS;

    @Override
    public @Nullable Icon getIcon() {
        return AntlersIcons.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return SYNTAX_HIGHLIGHTER;
    }

    @Override
    public @NonNls @NotNull String getDemoText() {
        String NL = "\n";

        return "{{# This is a comment #}}" + NL +
                NL +
                "{{# Boolean #}}" + NL +
                "{{ true }}" + NL +
                "{{ false }}" + NL +
                NL +
                "{{# Numbers #}}" + NL +
                "{{ 10 }}" + NL +
                "{{ 42 }}" + NL +
                "{{ 10003 }}" + NL +
                "{{ .42 }}" + NL +
                "{{ 0.42 }}" + NL +
                "{{ 10.42 }}" + NL +
                NL +
                "{{# Strings #}}" + NL +
                "{{ 'Welcome to Statamic' }}" + NL +
                "{{ \"We hope you enjoy it so much as we do.\" }}" + NL +
                NL +
                "{{# Variables #}}" + NL +
                "{{ foo }}" + NL +
                "{{ $foo }}" + NL +
                "{{ $foo = true }}" + NL +
                "{{ $foo = ['bar', 10, [2.4]] }}" + NL +
                NL +
                "{{# Sub-Expressions #}}" + NL +
                "{{ (foo) }}" + NL +
                "{{ ($foo) }}" + NL +
                "{{ (10) }}" + NL +
                "{{ ('string') }}" + NL +
                NL +
                "{{# Interpolated statements #}}" + NL +
                "{{ {10} }}" + NL +
                "{{ items = {10} }}" + NL +
                NL +
                "{{# Property Access #}}" + NL +
                "{{ complex_data[3][field]['title'] }}" + NL +
                "{{ sizes[size.label] }}" + NL +
                "{{ sizes[size_two.label] }}" + NL +
                "{{ view:sizes[size:label] }}" + NL +
                NL;
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return ourTags;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull String getDisplayName() {
        return "Antlers";
    }

    @NonNls private static final Map<String, TextAttributesKey> ourTags = RainbowHighlighter.createRainbowHLM();

    static {
        SYNTAX_HIGHLIGHTER = SyntaxHighlighterFactory.getSyntaxHighlighter(AntlersLanguage.INSTANCE, null, null);
        DESCRIPTORS = new AttributesDescriptor[] {
                new AttributesDescriptor("Boolean", AntlersHighlighter.BOOLEAN),
                new AttributesDescriptor("Braces", AntlersHighlighter.BRACES),
                new AttributesDescriptor("Brackets", AntlersHighlighter.BRACKETS),
                new AttributesDescriptor("Comma", AntlersHighlighter.COMMA),
                new AttributesDescriptor("Comment", AntlersHighlighter.COMMENT),
                new AttributesDescriptor("Identifier", AntlersHighlighter.IDENTIFIER),
                new AttributesDescriptor("Number", AntlersHighlighter.NUMBER),
                new AttributesDescriptor("Operator", AntlersHighlighter.OPERATOR),
                new AttributesDescriptor("Parentheses", AntlersHighlighter.PARENTHESES),
                new AttributesDescriptor("String", AntlersHighlighter.STRING),
        };

        ourTags.put("outer_language", XmlHighlighterColors.HTML_TAG);
    }
}
