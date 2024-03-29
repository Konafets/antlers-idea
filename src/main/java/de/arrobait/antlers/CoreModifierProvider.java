package de.arrobait.antlers;

import com.intellij.codeInsight.lookup.LookupElementBuilder;

import java.util.ArrayList;
import java.util.List;

public class CoreModifierProvider {
    final static List<LookupElementBuilder> modifiers = new ArrayList<>();

    static public List<LookupElementBuilder> getModifiers() {
        modifiers.add(LookupElementBuilder.create("add"));
        modifiers.add(LookupElementBuilder.create("add_query_param"));
        modifiers.add(LookupElementBuilder.create("add_slashes"));
        modifiers.add(LookupElementBuilder.create("alias"));
        modifiers.add(LookupElementBuilder.create("ampersand_list"));
        modifiers.add(LookupElementBuilder.create("antlers"));
        modifiers.add(LookupElementBuilder.create("ascii"));
        modifiers.add(LookupElementBuilder.create("as"));
        modifiers.add(LookupElementBuilder.create("at"));
        modifiers.add(LookupElementBuilder.create("background_position"));
        modifiers.add(LookupElementBuilder.create("backspace"));
        modifiers.add(LookupElementBuilder.create("bard_html"));
        modifiers.add(LookupElementBuilder.create("bard_items"));
        modifiers.add(LookupElementBuilder.create("bard_text"));
        modifiers.add(LookupElementBuilder.create("bool_string"));
        modifiers.add(LookupElementBuilder.create("camelize"));
        modifiers.add(LookupElementBuilder.create("cdata"));
        modifiers.add(LookupElementBuilder.create("ceil"));
        modifiers.add(LookupElementBuilder.create("chunk"));
        modifiers.add(LookupElementBuilder.create("collapse"));
        modifiers.add(LookupElementBuilder.create("collapse_whitespace"));
        modifiers.add(LookupElementBuilder.create("compact"));
        modifiers.add(LookupElementBuilder.create("console_log"));
        modifiers.add(LookupElementBuilder.create("contains"));
        modifiers.add(LookupElementBuilder.create("contains_all"));
        modifiers.add(LookupElementBuilder.create("contains_any"));
        modifiers.add(LookupElementBuilder.create("count"));
        modifiers.add(LookupElementBuilder.create("count_substring"));
        modifiers.add(LookupElementBuilder.create("dashify"));
        modifiers.add(LookupElementBuilder.create("days_ago"));
        modifiers.add(LookupElementBuilder.create("dd"));
        modifiers.add(LookupElementBuilder.create("ddd"));
        modifiers.add(LookupElementBuilder.create("debug"));
        modifiers.add(LookupElementBuilder.create("decode"));
        modifiers.add(LookupElementBuilder.create("deslugify"));
        modifiers.add(LookupElementBuilder.create("diff_for_humans"));
        modifiers.add(LookupElementBuilder.create("diff_for_owls"));
        modifiers.add(LookupElementBuilder.create("divide"));
        modifiers.add(LookupElementBuilder.create("dl"));
        modifiers.add(LookupElementBuilder.create("dump"));
        modifiers.add(LookupElementBuilder.create("embed_url"));
        modifiers.add(LookupElementBuilder.create("ends_with"));
        modifiers.add(LookupElementBuilder.create("ensure_left"));
        modifiers.add(LookupElementBuilder.create("ensure_right"));
        modifiers.add(LookupElementBuilder.create("entities"));
        modifiers.add(LookupElementBuilder.create("excerpt"));
        modifiers.add(LookupElementBuilder.create("explode"));
        modifiers.add(LookupElementBuilder.create("extension"));
        modifiers.add(LookupElementBuilder.create("favicon"));
        modifiers.add(LookupElementBuilder.create("first"));
        modifiers.add(LookupElementBuilder.create("flatten"));
        modifiers.add(LookupElementBuilder.create("flip"));
        modifiers.add(LookupElementBuilder.create("floor"));
        modifiers.add(LookupElementBuilder.create("format"));
        modifiers.add(LookupElementBuilder.create("format_localized"));
        modifiers.add(LookupElementBuilder.create("format_number"));
        modifiers.add(LookupElementBuilder.create("format_translated"));
        modifiers.add(LookupElementBuilder.create("full_urls"));
        modifiers.add(LookupElementBuilder.create("get"));
        modifiers.add(LookupElementBuilder.create("gravatar"));
        modifiers.add(LookupElementBuilder.create("group_by"));
        modifiers.add(LookupElementBuilder.create("has_lower_case"));
        modifiers.add(LookupElementBuilder.create("has_upper_case"));
        modifiers.add(LookupElementBuilder.create("hours_ago"));
        modifiers.add(LookupElementBuilder.create("image"));
        modifiers.add(LookupElementBuilder.create("in_array"));
        modifiers.add(LookupElementBuilder.create("insert"));
        modifiers.add(LookupElementBuilder.create("is_after"));
        modifiers.add(LookupElementBuilder.create("is_alpha"));
        modifiers.add(LookupElementBuilder.create("is_alphanumeric"));
        modifiers.add(LookupElementBuilder.create("is_array"));
        modifiers.add(LookupElementBuilder.create("is_before"));
        modifiers.add(LookupElementBuilder.create("is_between"));
        modifiers.add(LookupElementBuilder.create("is_blank"));
        modifiers.add(LookupElementBuilder.create("is_email"));
        modifiers.add(LookupElementBuilder.create("is_embeddable"));
        modifiers.add(LookupElementBuilder.create("is_empty"));
        modifiers.add(LookupElementBuilder.create("is_future"));
        modifiers.add(LookupElementBuilder.create("is_iterable"));
        modifiers.add(LookupElementBuilder.create("is_json"));
        modifiers.add(LookupElementBuilder.create("is_leap_year"));
        modifiers.add(LookupElementBuilder.create("is_lowercase"));
        modifiers.add(LookupElementBuilder.create("is_numberwang"));
        modifiers.add(LookupElementBuilder.create("is_numeric"));
        modifiers.add(LookupElementBuilder.create("is_past"));
        modifiers.add(LookupElementBuilder.create("is_today"));
        modifiers.add(LookupElementBuilder.create("is_tomorrow"));
        modifiers.add(LookupElementBuilder.create("is_uppercase"));
        modifiers.add(LookupElementBuilder.create("is_url"));
        modifiers.add(LookupElementBuilder.create("is_weekday"));
        modifiers.add(LookupElementBuilder.create("is_weekend"));
        modifiers.add(LookupElementBuilder.create("is_yesterday"));
        modifiers.add(LookupElementBuilder.create("iso_format"));
        modifiers.add(LookupElementBuilder.create("join"));
        modifiers.add(LookupElementBuilder.create("joinplode"));
        modifiers.add(LookupElementBuilder.create("kebab"));
        modifiers.add(LookupElementBuilder.create("key_by"));
        modifiers.add(LookupElementBuilder.create("last"));
        modifiers.add(LookupElementBuilder.create("lcfirst"));
        modifiers.add(LookupElementBuilder.create("length"));
        modifiers.add(LookupElementBuilder.create("limit"));
        modifiers.add(LookupElementBuilder.create("link"));
        modifiers.add(LookupElementBuilder.create("list"));
        modifiers.add(LookupElementBuilder.create("localize"));
        modifiers.add(LookupElementBuilder.create("lower"));
        modifiers.add(LookupElementBuilder.create("macro"));
        modifiers.add(LookupElementBuilder.create("mailto"));
        modifiers.add(LookupElementBuilder.create("mark"));
        modifiers.add(LookupElementBuilder.create("markdown"));
        modifiers.add(LookupElementBuilder.create("md5"));
        modifiers.add(LookupElementBuilder.create("merge"));
        modifiers.add(LookupElementBuilder.create("minutes_ago"));
        modifiers.add(LookupElementBuilder.create("mod"));
        modifiers.add(LookupElementBuilder.create("modify_date"));
        modifiers.add(LookupElementBuilder.create("months_ago"));
        modifiers.add(LookupElementBuilder.create("multiply"));
        modifiers.add(LookupElementBuilder.create("neatify"));
        modifiers.add(LookupElementBuilder.create("nl2br"));
        modifiers.add(LookupElementBuilder.create("obfuscate"));
        modifiers.add(LookupElementBuilder.create("obfuscate_email"));
        modifiers.add(LookupElementBuilder.create("offset"));
        modifiers.add(LookupElementBuilder.create("ol"));
        modifiers.add(LookupElementBuilder.create("option_list"));
        modifiers.add(LookupElementBuilder.create("output"));
        modifiers.add(LookupElementBuilder.create("path_info"));
        modifiers.add(LookupElementBuilder.create("pad"));
        modifiers.add(LookupElementBuilder.create("parse_url"));
        modifiers.add(LookupElementBuilder.create("partial"));
        modifiers.add(LookupElementBuilder.create("pathinfo"));
        modifiers.add(LookupElementBuilder.create("pluck"));
        modifiers.add(LookupElementBuilder.create("piped"));
        modifiers.add(LookupElementBuilder.create("plural"));
        modifiers.add(LookupElementBuilder.create("random"));
        modifiers.add(LookupElementBuilder.create("raw"));
        modifiers.add(LookupElementBuilder.create("rawurlencode"));
        modifiers.add(LookupElementBuilder.create("ray"));
        modifiers.add(LookupElementBuilder.create("read_time"));
        modifiers.add(LookupElementBuilder.create("regex_mark"));
        modifiers.add(LookupElementBuilder.create("regex_replace"));
        modifiers.add(LookupElementBuilder.create("relative"));
        modifiers.add(LookupElementBuilder.create("remove_left"));
        modifiers.add(LookupElementBuilder.create("remove_query_param"));
        modifiers.add(LookupElementBuilder.create("remove_right"));
        modifiers.add(LookupElementBuilder.create("repeat"));
        modifiers.add(LookupElementBuilder.create("replace"));
        modifiers.add(LookupElementBuilder.create("reverse"));
        modifiers.add(LookupElementBuilder.create("round"));
        modifiers.add(LookupElementBuilder.create("scope"));
        modifiers.add(LookupElementBuilder.create("safe_truncate"));
        modifiers.add(LookupElementBuilder.create("sanitize"));
        modifiers.add(LookupElementBuilder.create("seconds_ago"));
        modifiers.add(LookupElementBuilder.create("segment"));
        modifiers.add(LookupElementBuilder.create("sentence_list"));
        modifiers.add(LookupElementBuilder.create("set_query_parm"));
        modifiers.add(LookupElementBuilder.create("shrug"));
        modifiers.add(LookupElementBuilder.create("shuffle"));
        modifiers.add(LookupElementBuilder.create("singular"));
        modifiers.add(LookupElementBuilder.create("slugify"));
        modifiers.add(LookupElementBuilder.create("smartypants"));
        modifiers.add(LookupElementBuilder.create("sort"));
        modifiers.add(LookupElementBuilder.create("spaceless"));
        modifiers.add(LookupElementBuilder.create("split"));
        modifiers.add(LookupElementBuilder.create("starts_with"));
        modifiers.add(LookupElementBuilder.create("strip_tags"));
        modifiers.add(LookupElementBuilder.create("str_pad"));
        modifiers.add(LookupElementBuilder.create("str_pad_both"));
        modifiers.add(LookupElementBuilder.create("str_pad_left"));
        modifiers.add(LookupElementBuilder.create("str_pad_right"));
        modifiers.add(LookupElementBuilder.create("studly"));
        modifiers.add(LookupElementBuilder.create("substr"));
        modifiers.add(LookupElementBuilder.create("subtract"));
        modifiers.add(LookupElementBuilder.create("sum"));
        modifiers.add(LookupElementBuilder.create("surround"));
        modifiers.add(LookupElementBuilder.create("swap_case"));
        modifiers.add(LookupElementBuilder.create("table"));
        modifiers.add(LookupElementBuilder.create("tidy"));
        modifiers.add(LookupElementBuilder.create("timestamp"));
        modifiers.add(LookupElementBuilder.create("timezone"));
        modifiers.add(LookupElementBuilder.create("title"));
        modifiers.add(LookupElementBuilder.create("to_bool"));
        modifiers.add(LookupElementBuilder.create("to_json"));
        modifiers.add(LookupElementBuilder.create("to_spaces"));
        modifiers.add(LookupElementBuilder.create("to_string"));
        modifiers.add(LookupElementBuilder.create("to_tabs"));
        modifiers.add(LookupElementBuilder.create("trackable_embed_url"));
        modifiers.add(LookupElementBuilder.create("trans"));
        modifiers.add(LookupElementBuilder.create("trans_choice"));
        modifiers.add(LookupElementBuilder.create("trim"));
        modifiers.add(LookupElementBuilder.create("truncate"));
        modifiers.add(LookupElementBuilder.create("type_of"));
        modifiers.add(LookupElementBuilder.create("ucfirst"));
        modifiers.add(LookupElementBuilder.create("ul"));
        modifiers.add(LookupElementBuilder.create("url_info"));
        modifiers.add(LookupElementBuilder.create("underscored"));
        modifiers.add(LookupElementBuilder.create("unique"));
        modifiers.add(LookupElementBuilder.create("upper"));
        modifiers.add(LookupElementBuilder.create("url"));
        modifiers.add(LookupElementBuilder.create("urldecode"));
        modifiers.add(LookupElementBuilder.create("urlencode"));
        modifiers.add(LookupElementBuilder.create("weeks_ago"));
        modifiers.add(LookupElementBuilder.create("where"));
        modifiers.add(LookupElementBuilder.create("widont"));
        modifiers.add(LookupElementBuilder.create("word_count"));
        modifiers.add(LookupElementBuilder.create("wrap"));
        modifiers.add(LookupElementBuilder.create("years_ago"));

        return modifiers;
    }
}
