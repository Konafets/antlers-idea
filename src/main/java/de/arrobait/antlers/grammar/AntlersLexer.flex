package de.arrobait.antlers.grammar;

import de.arrobait.antlers.psi.AntlersTokenType;
import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.WHITE_SPACE;

import java.util.ArrayDeque;
import java.util.Deque;

import static de.arrobait.antlers.psi.AntlersTypes.*;

%%

%{
    private final Deque<Integer> lexStateStack = new ArrayDeque<Integer>();

    public AntlersLexer() {
        this((java.io.Reader)null);
    }

    private void pushState(int state) {
      lexStateStack.push(yystate());
      yybegin(state);
    }

    private void popState() {
      if (lexStateStack.isEmpty()) {
          yybegin(YYINITIAL);
      } else {
          yybegin(lexStateStack.pop());
      }
    }
%}

%public
%class AntlersLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

LD="{{"
RD="}}"

SLASH="/"
SLASH_ASSIGN="/="

COMMENT_OPEN="{{#"
COMMENT_CLOSE="#}}"

SINGLE_QUOTE="\'"
DOUBLE_QUOTE="\""

MODIFIERS=add|add_slashes|ampersand_list|as|ascii|at|background_position|backspace|camelize|cdata|ceil|chunk|collapse|collapse_whitespace|compact|console_log|contains|contains_all|contains_any|count|count_substring|dashify|days_ago|decode|deslugify|divide|dl|dump|embed_url|ends_with|ensure_left|ensure_right|entities|excerpt|explode|favicon|first|flatten|flip|floor|format|format_localized|format_number|full_urls|get|gravatar|group_by|has_lower_case|has_upper_case|hours_ago|image|in_array|insert|is_after|is_alphanumeric|is_before|is_between|is_blank|is_email|is_embeddable|is_empty|is_future|is_json|is_leap_year|is_lowercase|is_numberwang|is_numeric|is_past|is_today|is_tomorrow|is_uppercase|is_url|is_weekday|is_weekend|is_yesterday|iso_format|join|last|lcfirst|length|limit|link|list|lower|macro|mailto|markdown|md5|merge|minutes_ago|mod|modify_date|months_ago|multiply|nl2br|obfuscate|obfuscate_email|offset|ol|option_list|output|pad|partial|piped|plural|raw|rawurlencode|ray|read_time|regex_replace|relative|remove_left|remove_right|repeat|replace|reverse|round|safe_truncate|sanitize|seconds_ago|segment|sentence_list|shuffle|singular|slugify|smartypants|sort|spaceless|starts_with|strip_tags|substr|subtract|sum|surround|swap_case|table|tidy|timezone|title|to_json|to_spaces|to_tabs|trans|trim|truncate|ucfirst|ul|underscored|unique|upper|url|urldecode|urlencode|weeks_ago|where|widont|word_count|wrap|years_ago
PIPE="|"
IDENTIFIER=[$_A-Za-z][-_0-9A-Za-z]*
IDENTIFIER_DOT={IDENTIFIER} "."
IDENTIFIER_COLON={IDENTIFIER} ":"
IDENTIFIER_BRACKET={IDENTIFIER} "["

UNLESS="unless"
IF="if"

INTEGER_NUMBER=0|[1-9]\d*
FLOAT_NUMBER=[0-9]*\.[0-9]+([eE][-+]?[0-9]+)?|[0-9]+[eE][-+]?[0-9]+

// States
%state ANTLERS_COMMENT
%state ANTLERS_NODE
%state PROPERTY_ACCESS
%state SINGLE_STRING
%state DOUBLE_STRING
%state PHP_ECHO
%state PHP_RAW
%state MODIFIER_LIST

%%
<YYINITIAL> {
    {WHITE_SPACE}        { return TokenType.WHITE_SPACE; }
    {COMMENT_OPEN}       { yypushback(yylength() - 3); pushState(ANTLERS_COMMENT); return T_COMMENT_OPEN;}

    // Antlers node
    {LD}                 { pushState(ANTLERS_NODE); return T_LD; }

    // PHP nodes
    "{{?"                { pushState(PHP_RAW); return T_PHP_RAW_OPEN; }
    "{{$"                { pushState(PHP_ECHO); return T_PHP_ECHO_OPEN; }

    // HTML content
    !([^]*"{"[^]*)       { return OUTER_CONTENT; }
}

<ANTLERS_NODE> {
    {RD}                 { popState(); return T_RD; }
    {WHITE_SPACE}        { return WHITE_SPACE; }

    // Control
    {IF}                 { return T_IF; }
    "elseif"             { return T_ELSE_IF; }
    "else"               { return T_ELSE; }
    "endif"              { return T_END_IF; }
    {SLASH} {IF}         { return T_END_IF; }
    "unless"             { return T_UNLESS; }
    "endunless"          { return T_END_UNLESS; }
    {SLASH} {UNLESS}     { return T_END_UNLESS; }
    "switch"             { return T_SWITCH; }

    // Boolean
    "true"               { return T_TRUE; }
    "false"              { return T_FALSE; }

    // Logical - Must come before {IDENTIFIER}
    "&&"|"and"           { return T_OP_AND; }
    "||"|"or"            { return T_OP_OR; }
    "xor"                { return T_OP_XOR; }

    {SINGLE_QUOTE}       { pushState(SINGLE_STRING); return T_STRING_START; }
    {DOUBLE_QUOTE}       { pushState(DOUBLE_STRING); return T_STRING_START; }

    {IDENTIFIER}         { return T_IDENTIFIER; }
    {IDENTIFIER_DOT}     { yypushback(yylength()); pushState(PROPERTY_ACCESS); }
    {IDENTIFIER_COLON}   { yypushback(yylength()); pushState(PROPERTY_ACCESS); }
    {IDENTIFIER_BRACKET} { yypushback(yylength()); pushState(PROPERTY_ACCESS); }

    {INTEGER_NUMBER}     { return T_INTEGER_NUMBER; }
    {FLOAT_NUMBER}       { return T_FLOAT_NUMBER; }
    {PIPE}               { pushState(MODIFIER_LIST); return T_PIPE; }

    {SLASH_ASSIGN}       { return T_OP_SELF_ASSIGN_DIV; }
    {SLASH}              { return T_SLASH; }

    ","                  { return T_COMMA; }
    ":"                  { return T_COLON; }
    "=>"                 { return T_OP_ARROW; }

    // Math
    "+"                  { return T_OP_PLUS; }
    "-"                  { return T_OP_MINUS; }
    "*"                  { return T_OP_MUL; }
    "%"                  { return T_OP_MOD; }
    "**"                 { return T_OP_POW; }
    "!"                  { return T_OP_EXCLAMATION_MARK; }
    "?"                  { return T_OP_QUESTIONMARK; }
    "="                  { return T_OP_ASSIGN; }
    "+="                 { return T_OP_SELF_ASSIGN_ADD; }
    "-="                 { return T_OP_SELF_ASSIGN_SUB; }
    "*="                 { return T_OP_SELF_ASSIGN_MUL; }
    "%="                 { return T_OP_SELF_ASSIGN_MOD; }

    // Parens, Brackets and Braces
    "("                  { return T_LP; }
    ")"                  { return T_RP; }
    "{"                  { return T_LEFT_BRACE; }
    "}"                  { return T_RIGHT_BRACE; }
    "["                  { return T_LEFT_BRACKET; }
    "]"                  { return T_RIGHT_BRACKET; }

    // Comparison
    "=="                 { return T_OP_EQ; }
    "==="                { return T_OP_IDENT; }
    ">"                  { return T_OP_GT; }
    ">="                 { return T_OP_GTE; }
    "<"                  { return T_OP_LT; }
    "<="                 { return T_OP_LTE; }
    "!="                 { return T_OP_NEQ; }
    "!=="                { return T_OP_NOT_IDENT; }
    "<=>"                { return T_OP_SPACESHIP; }
    "??"                 { return T_OP_NULL_COALESCENCE; }
    "?="                 { return T_OP_GATEKEEPER; }
}

// State to avoid ambiguity between float values (.0) with object access (person.name)
<PROPERTY_ACCESS> {
    ":"                         { return T_COLON; }
    "."                         { return T_DOT; }
    "["                         { return T_LEFT_BRACKET; }
    "]"                         { return T_RIGHT_BRACKET; }
    {INTEGER_NUMBER}            { return T_INTEGER_NUMBER; }
    {SINGLE_QUOTE}              { pushState(SINGLE_STRING); return T_STRING_START; }
    {DOUBLE_QUOTE}              { pushState(DOUBLE_STRING); return T_STRING_START; }
    {IDENTIFIER}                { return T_IDENTIFIER; }
    [^]                         {
                                  yypushback(1);  // cancel unexpected char
                                  popState();     // and try to parse it again in <IN_ANTLERS>
                                }
}

// State to avoid ambiguity between core modifiers and custom variables like: {{ title | title }}
<MODIFIER_LIST> {
    {RD}                 { yybegin(YYINITIAL); return T_RD; }
    {MODIFIERS}          { return T_MODIFIER; }
    {PIPE}               { return T_PIPE; }
    {WHITE_SPACE}        { return TokenType.WHITE_SPACE; }

    // Boolean
    "true"               { return T_TRUE; }
    "false"              { return T_FALSE; }
    ","                  { return T_COMMA; }
    "("                  { return T_LP; }
    ")"                  { return T_RP; }
    "["                  { return T_LEFT_BRACKET; }
    "]"                  { return T_RIGHT_BRACKET; }
    {SINGLE_QUOTE}       { pushState(SINGLE_STRING); return T_STRING_START; }
    {DOUBLE_QUOTE}       { pushState(DOUBLE_STRING); return T_STRING_START; }
    {IDENTIFIER}         { return T_IDENTIFIER; }
    {INTEGER_NUMBER}     { return T_INTEGER_NUMBER; }
    {FLOAT_NUMBER}       { return T_FLOAT_NUMBER; }
    [^]                  {
                           yypushback(1);  // cancel unexpected char
                           popState();     // and try to parse it again in <IN_ANTLERS>
                         }
}

<ANTLERS_COMMENT> {
    {COMMENT_CLOSE}             { popState(); return T_COMMENT_CLOSE; }
    ~{COMMENT_CLOSE}            { yypushback(3); return T_COMMENT_TEXT; }
}

<SINGLE_STRING> {
    {SINGLE_QUOTE}  { popState(); return T_STRING_END; }
    ~{SINGLE_QUOTE} { yypushback(1); return T_STRING_CONTENT; }
}

<DOUBLE_STRING> {
    {DOUBLE_QUOTE}  { popState(); return T_STRING_END; }
    ~{DOUBLE_QUOTE} { yypushback(1); return T_STRING_CONTENT; }
}

<PHP_ECHO> {
    "$}}"                       { popState(); return T_PHP_ECHO_CLOSE;}
    ~"$}}"                      { yypushback(3); return T_PHP_CONTENT;}
}

<PHP_RAW> {
    "?}}"                       { popState(); return T_PHP_RAW_CLOSE;}
    ~"?}}"                      { yypushback(3); return T_PHP_CONTENT;}
}

[^] { yybegin(YYINITIAL); return OUTER_CONTENT; }
