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
                "{{ -.42 }}" + NL +
                "{{ -0.42 }}" + NL +
                "{{ -10.42 }}" + NL +
                "{{ -10 }}" + NL +
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
                "{{ $foo = favourite_articles merge not_favourite_articles }}" + NL +
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
                NL +
                "{{# Math #}}" + NL +
                "{{ 5! }}" + NL +
                "{{ (5)! }}" + NL +
                "{{ -(5)! }}" + NL +
                "{{ (-5)! }}" + NL +
                "{{ -(-5)! }}" + NL +
                "{{ 3 + 4 }}" + NL +
                "{{ 3 - 4 }}" + NL +
                "{{ 3 * 4 }}" + NL +
                "{{ 3 / 4 }}" + NL +
                "{{ 3 % 4 }}" + NL +
                "{{ 3 ** 4 }}" + NL +
                NL +
                "{{# Concat #}}" + NL +
                "<p>{{ $title + \" makes \" + $quality + \" donuts.\" }}</p>" + NL +
                "{{ string += \" World\"}}" + NL +
                NL +
                "{{# Comparison #}}" + NL +
                "{{ is_sold ? \"sold\" : (on_sale ? \"on sale\" : \"for sale\") }}" + NL +
                "{{ the_answer == 10 }}" + NL +
                "{{ the_answer != 10 }}" + NL +
                "{{ the_answer === 10 }}" + NL +
                "{{ the_answer !== 10 }}" + NL +
                "{{ the_answer > 10 }}" + NL +
                "{{ the_answer >= 10 }}" + NL +
                "{{ the_answer < 10 }}" + NL +
                "{{ the_answer <= 10 }}" + NL +
                "{{ foo <=> bar }}" + NL +
                "{{ meta_title ?? title ?? \"Someone Forgot the Title\" }}" + NL +
                "{{ show_bio ?= author:bio }}" + NL +
                "{{ 10 && 20 }}" + NL +
                "{{ 10 and 20 }}" + NL +
                "{{ 10 || 20 }}" + NL +
                "{{ 10 or 20 }}" + NL +
                "{{ foo xor 20 }}" + NL +
                NL +
                "{{# Control structures #}}" + NL +
                "{{ if something }}" + NL +
                "  {{ string += \" World\"}}" + NL +
                "{{ else }}" + NL +
                "  {{ string += \" Universe\" }}" + NL +
                "{{ /if }}" + NL +
                NL +
                "{{# Switch #}}" + NL +
                "{{ switch(" + NL +
                "        (size == 'sm') => '(min-width: 768px) 35vw, 90vw'," + NL +
                "        (size == 'md') => '(min-width: 768px) 55vw, 90vw'," + NL +
                "        (size == 'lg') => '(min-width: 768px) 75vw, 90vw'," + NL +
                "        (size == 'xl') => '90vw'" + NL +
                "         () => '100vw'" + NL +
                "     )" + NL +
                " }}" + NL +
                NL +
                "{{# Modifiers #}}" + NL +
                "{{ var | ensure_right('hi', ['pooh', 'pea'], true, 42, $favoriteVar['foo']) }}" + NL +
                NL +
                "{{# Tags #}}" + NL +
                "{{ collection }} {{ /collection }}" + NL +
                "{{ collection from=\"Foo\" }} {{ /collection }}" + NL +
                "{{ collection:blog }} {{ /collection:blog }}" + NL +
                "{{ %collection }} {{ /collection }}" + NL +
                "{{ nav:collection:pages }} {{ /nav:collection:pages }}" + NL +
                NL +
                "{{# Advanced operators #}}" + NL +
                "{{ items = foo groupby (FIELD 'KEY1') as 'things' }}" + NL +
                "{{ items = {collection:headlines} merge {collection:news limit=\"5\"} }}" + NL +
                "{{ people = people orderby (age 'desc', last_name true, first_name 'asc') }}" + NL +
                "{{ players = players pluck('name') }}" + NL +
                "  {{ value }}" + NL +
                "{{ /players }}" + NL +
                "{{ players = players skip (2) }}" + NL +
                "{{ articles = articles take (2) }}" + NL +
                "{{ bulls = players where (team == \"Chicago Bulls\") }}" + NL +
                "{{ afford = products where (x => x.price < budget) }}" + NL +
                NL +
                "{{# Tag Conditions #}}" + NL +
                "{{ collection:blog title:contains=\"awesome\" title:contains=\"thing\" author:is=\"joe\" }}" + NL +
                NL;
//                "{{# PHP #}}" + NL +
//                "{{? <php_keyword>echo</php_keyword> <php_string>\\\"Choose your own Statamic adventure!\\\"</php_string> ?}}" + NL +
//                "{{$ <php_keyword>echo</php_keyword> <php_string>\\\"Choose your own Statamic adventure!\\\"</php_string> $}}";
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
                new AttributesDescriptor("Braces and Operators//Advanced operators", AntlersHighlighter.ADVANCED_OPERATORS),
                new AttributesDescriptor("Braces and Operators//Braces", AntlersHighlighter.BRACES),
                new AttributesDescriptor("Braces and Operators//Brackets", AntlersHighlighter.BRACKETS),
                new AttributesDescriptor("Braces and Operators//Comma", AntlersHighlighter.COMMA),
                new AttributesDescriptor("Braces and Operators//Operator", AntlersHighlighter.OPERATOR),
                new AttributesDescriptor("Braces and Operators//Parentheses", AntlersHighlighter.PARENTHESES),
                new AttributesDescriptor("Comment", AntlersHighlighter.COMMENT),
                new AttributesDescriptor("Identifier", AntlersHighlighter.IDENTIFIER),
                new AttributesDescriptor("Keywords", AntlersHighlighter.KEYWORD),
                new AttributesDescriptor("Modifiers", AntlersHighlighter.MODIFIER),
                new AttributesDescriptor("Number", AntlersHighlighter.NUMBER),
                new AttributesDescriptor("String", AntlersHighlighter.STRING),
                new AttributesDescriptor("Tags//Tags", AntlersHighlighter.TAG),
                new AttributesDescriptor("Tags//Tag conditions", AntlersHighlighter.TAG_CONDITION),
                new AttributesDescriptor("Tags//Tag method name", AntlersHighlighter.TAG_METHOD_NAME),
                new AttributesDescriptor("Tags//Tag disambiguation", AntlersHighlighter.TAG_DISAMBIGUATION),
                new AttributesDescriptor("Tags//Tag shorthand separator", AntlersHighlighter.TAG_SHORTHAND_SEPARATOR),
        };

        ourTags.put("outer_language", XmlHighlighterColors.HTML_TAG);
    }
}
