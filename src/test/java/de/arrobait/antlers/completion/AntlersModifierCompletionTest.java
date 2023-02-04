package de.arrobait.antlers.completion;

import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import de.arrobait.antlers.file.AntlersFileType;

public class AntlersModifierCompletionTest extends BasePlatformTestCase {
    public void doBasicTest(String text, String... expected) {
        myFixture.configureByText(AntlersFileType.INSTANCE, text);
        myFixture.complete(CompletionType.BASIC);
        assertContainsElements(myFixture.getLookupElementStrings(), expected);
    }

    public void testSimple() {
        doBasicTest("{{ foo | <caret>", "add", "add_slashes", "explode", "is_email", "modify_date");
    }

    public void testCompleteModifiersWithA() {
        doBasicTest("{{ foo | a<caret>", "add", "add_query_param", "add_slashes", "alias", "ampersand_list", "antlers", "ascii", "as", "at");
    }

    public void testCompleteModifiersWithB() {
        doBasicTest("{{ foo | b<caret>", "background_position", "backspace", "bard_html", "bard_items", "bard_text", "bool_string");
    }

    public void testCompleteModifiersWithC() {
        doBasicTest("{{ foo | c<caret>", "camelize", "cdata", "ceil", "chunk", "collapse", "collapse_whitespace", "compact", "console_log", "contains", "contains_all", "contains_any", "count", "count_substring");
    }

    public void testCompleteModifiersWithD() {
        doBasicTest("{{ foo | d<caret>", "dashify", "days_ago", "dd", "ddd", "debug", "decode", "deslugify", "diff_for_humans", "diff_for_owls", "divide", "dl", "dump");
    }

    public void testCompleteModifiersWithE() {
        doBasicTest("{{ foo | e<caret>", "embed_url", "ends_with", "ensure_left", "ensure_right", "entities", "excerpt", "explode", "extension");
    }

    public void testCompleteModifiersWithF() {
        doBasicTest("{{ foo | f<caret>", "favicon", "first", "flatten", "flip", "floor", "format", "format_localized", "format_number", "format_translated", "full_urls");
    }

    public void testCompleteModifiersWithG() {
        doBasicTest("{{ foo | g<caret>", "get", "gravatar", "group_by");
    }

    public void testCompleteModifiersWithH() {
        doBasicTest("{{ foo | h<caret>", "has_lower_case", "has_upper_case", "hours_ago");
    }

    public void testCompleteModifiersWithI() {
        doBasicTest("{{ foo | i<caret>", "image", "in_array", "insert", "is_after", "is_alpha", "is_alphanumeric", "is_array", "is_before", "is_between", "is_blank", "is_email", "is_embeddable", "is_empty", "is_future", "is_iterable", "is_json", "is_leap_year", "is_lowercase", "is_numberwang", "is_numeric", "iso_format", "is_past", "is_today", "is_tomorrow", "is_uppercase", "is_url", "is_weekday", "is_weekend", "is_yesterday");
    }

    public void testCompleteModifiersWithJ() {
        doBasicTest("{{ foo | j<caret>", "join", "joinplode");
    }

    public void testCompleteModifiersWithK() {
        doBasicTest("{{ foo | k<caret>", "kebab", "key_by");
    }

    public void testCompleteModifiersWithL() {
        doBasicTest("{{ foo | l<caret>", "last", "lcfirst", "length", "limit", "link", "list", "localize", "lower");
    }

    public void testCompleteModifiersWithM() {
        doBasicTest("{{ foo | m<caret>", "macro", "mailto", "mark", "markdown", "md5", "merge", "minutes_ago", "mod", "modify_date", "months_ago", "multiply");
    }

    public void testCompleteModifiersWithN() {
        doBasicTest("{{ foo | n<caret>", "neatify", "nl2br");
    }

    public void testCompleteModifiersWithO() {
        doBasicTest("{{ foo | o<caret>", "obfuscate", "obfuscate_email", "offset", "ol", "option_list", "output");
    }

    public void testCompleteModifiersWithP() {
        doBasicTest("{{ foo | p<caret>", "pad", "parse_url", "partial", "pathinfo", "pluck", "piped", "plural");
    }

    public void testCompleteModifiersWithR() {
        doBasicTest("{{ foo | r<caret>", "random", "raw", "rawurlencode", "ray", "read_time", "regex_mark", "regex_replace", "relative", "remove_left", "remove_query_param", "remove_right", "repeat", "replace", "reverse", "round");
    }

    public void testCompleteModifiersWithS() {
        doBasicTest("{{ foo | s<caret>", "scope", "safe_truncate", "sanitize", "seconds_ago", "segment", "sentence_list", "set_query_parm", "shrug", "shuffle", "singular", "slugify", "smartypants", "sort", "spaceless", "split", "starts_with", "strip_tags", "str_pad", "str_pad_both", "str_pad_left", "str_pad_right", "studly", "substr", "subtract", "sum", "surround", "swap_case");
    }

    public void testCompleteModifiersWithT() {
        doBasicTest("{{ foo | t<caret>", "table", "tidy", "timestamp", "timezone", "title", "to_bool", "to_json", "to_spaces", "to_string", "to_tabs", "trackable_embed_url", "trans", "trans_choice", "trim", "truncate", "type_of");
    }

    public void testCompleteModifiersWithU() {
        doBasicTest("{{ foo | u<caret>", "ucfirst", "url_info", "ul", "underscored", "unique", "upper", "url", "urldecode", "urlencode");
    }

    public void testCompleteModifiersWithW() {
        doBasicTest("{{ foo | w<caret>", "weeks_ago", "where", "widont", "word_count", "wrap");
    }

    public void testCompleteModifiersWithY() {
        doBasicTest("{{ foo | y<caret>", "years_ago");
    }
}
