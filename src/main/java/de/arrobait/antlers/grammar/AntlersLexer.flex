package de.arrobait.antlers.grammar;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.intellij.psi.TokenType.BAD_CHARACTER;

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

LINE_TERMINATOR = \r|\n|\r\n
WHITE_SPACE = {LINE_TERMINATOR} | [ \t\f]

LD="{{"
RD="}}"

SLASH="/"
SLASH_ASSIGN="/="

COMMENT_OPEN="{{#"
COMMENT_CLOSE="#}}"

SINGLE_QUOTE="\'"
DOUBLE_QUOTE="\""
SINGLE_QUOTED_STR_CONTENT = ([^\\']|\\([\\'\"/bfnrt]|u[a-fA-F0-9]{4}))+
DOUBLE_QUOTED_STR_CONTENT = ([^\\\"]|\\([\\'\"/bfnrt]|u[a-fA-F0-9]{4}))+

MODIFIERS=add|add_slashes|ampersand_list|as|ascii|at|background_position|backspace|camelize|cdata|ceil|chunk|collapse|collapse_whitespace|compact|console_log|contains|contains_all|contains_any|count|count_substring|dashify|days_ago|decode|deslugify|divide|dl|dump|embed_url|ends_with|ensure_left|ensure_right|entities|excerpt|explode|favicon|first|flatten|flip|floor|format|format_localized|format_number|full_urls|get|gravatar|group_by|has_lower_case|has_upper_case|hours_ago|image|in_array|insert|is_after|is_alphanumeric|is_before|is_between|is_blank|is_email|is_embeddable|is_empty|is_future|is_json|is_leap_year|is_lowercase|is_numberwang|is_numeric|is_past|is_today|is_tomorrow|is_uppercase|is_url|is_weekday|is_weekend|is_yesterday|iso_format|join|last|lcfirst|length|limit|link|list|lower|macro|mailto|markdown|md5|merge|minutes_ago|mod|modify_date|months_ago|multiply|nl2br|obfuscate|obfuscate_email|offset|ol|option_list|output|path_info|pad|partial|piped|plural|raw|rawurlencode|ray|read_time|regex_replace|relative|remove_left|remove_right|repeat|replace|reverse|round|safe_truncate|sanitize|seconds_ago|segment|sentence_list|shuffle|singular|slugify|smartypants|sort|spaceless|starts_with|strip_tags|substr|subtract|sum|surround|swap_case|table|tidy|timezone|title|to_json|to_spaces|to_tabs|trans|trim|truncate|ucfirst|ul|url_info|underscored|unique|upper|url|urldecode|urlencode|weeks_ago|where|widont|word_count|wrap|years_ago

TAG="%"?{TAG_NAMES}":"?
TAG_NAMES=404|asset|assets|cache|can|collection|dd|dump|foreach|form|get_content|get_error|get_errors|get_files|glide|in|increment|installed|is|link|locales|loop|markdown|mix|mount_url|nav|nocache|not_found|oauth|obfuscate|parent|partial|protect|path|query|range|redirect|relate|rotate|route|scope|search|section|session|set|structure|svg|switch|taxonomy|theme|trans|trans_choice|user|users|vite|widont|yield|yields
TAG_METHOD_NAME=[_A-Za-z][-_/0-9A-Za-z\.]*
TAG_STRING_CONDITIONS=:contains|:doesnt_contain|:doesnt_end_with|:doesnt_exist|:doesnt_match|:doesnt_start_with|:ends_with|:equals|:exists|:gt|:gte|:in|:is|:is_after|:is_alpha|:is_alpha_numeric|:is_before|:is_email|:is_embeddable|:is_empty|:is_numberwang|:is_numeric|:is_url|:isnt|:isset|:lt|:lte|:matches|:not|:not_in|:null|:regex|:starts_with

RECURSIVE_CHILDREN=\*recursive

PIPE="|"

IDENTIFIER=[$_A-Za-z][-_0-9A-Za-z]*[_A-Za-z0-9]?
IDENTIFIER_DOT={IDENTIFIER} "."
IDENTIFIER_COLON={IDENTIFIER} ":"
IDENTIFIER_BRACKET={IDENTIFIER} "["

UNLESS="unless"
IF="if"

INTEGER_NUMBER=0|[1-9]\d*
FLOAT_NUMBER=[0-9]*\.[0-9]+([eE][-+]?[0-9]+)?|[0-9]+[eE][-+]?[0-9]+

// States
%state ANTLERS_COMMENT
%state ANTLERS_ESCAPED
%state ANTLERS_NODE
%state PROPERTY_ACCESS
%state MODIFIER_LIST
%state TAG_EXPRESSION
%state TAG_SHORTHAND
%state TAG_EXPRESSION_ATTRIBUTE_LIST
%state RECURSIVE_CHILDREN
%state SINGLE_STRING
%state DOUBLE_STRING
%state PHP_ECHO
%state PHP_RAW

%%
<YYINITIAL> {
    ~"{{"  {
                // This matches any chars before the opening delimiters, including the `{{` itself.
                // We do this to catch the escape char `@` in front of the delimiters and to mark outer content like HTML, CSS and JS.

                // First we need to remove the matched `{{` characters from the match and put it back to the input string, so
                // that the lexer can lex it again in a dedicated state.
                while(yylength() > 0 && yytext().subSequence(yylength() - 1, yylength()).toString().equals("{")) {
                    yypushback(1);
                }

                // Here we check if the char right before the `{{` is a `@`. If so, this is an escaped node, otherwise a
                // regular Antlers node.
                if (yylength() > 0 && yytext().toString().charAt(yylength() - 1) == '@'){
                    yypushback(1);
                    pushState(ANTLERS_ESCAPED);
                } else {
                    pushState(ANTLERS_NODE);
                }

                // The content before an Antlers delimiter could be an empty whitespace or HTML aka outer content.
                // Here we disginguish between those to not create an extra token for empty strings. Those where
                // handled by the lexer, which will produce a PsiWhitespace element.
                if (!yytext().toString().equals("")) {
                    if (yytext().toString().trim().length() == 0) {
                        return WHITE_SPACE;
                    } else {
                        return OUTER_CONTENT;
                    }
                }
    }

    // Check for anything that is not a string containing "{{"; that's OUTER_CONTENT like HTML, CSS or JS.
    !([^]*"{{"[^]*)  { return OUTER_CONTENT; }
}

<ANTLERS_ESCAPED> {
    "@"       { return T_AT; }

    // grab everything up to the next open delimiters
    "{{"~"{{" {
                // backtrack over any tine or escape characters at the end of this string
                while (yylength() > 0
                        && (yytext().subSequence(yylength() - 1, yylength()).toString().equals("{")
                            || yytext().subSequence(yylength() - 1, yylength()).toString().equals("@"))) {
                    yypushback(1);
                }

                popState();
                return OUTER_CONTENT;
    }

    // otherwise, if the remaining text just contains the one escaped mustache, then its all other CONTENT like HTML, CSS or JS.
    "{{"!([^]*"{{"[^]*)  { return OUTER_CONTENT; }
}

<ANTLERS_NODE> {
    {COMMENT_OPEN}       { popState(); pushState(ANTLERS_COMMENT); return T_COMMENT_OPEN; }

    // PHP nodes
    "{{?"                { pushState(PHP_RAW); return T_PHP_RAW_OPEN; }
    "{{$"                { pushState(PHP_ECHO); return T_PHP_ECHO_OPEN; }

    {LD}                 { return T_LD; }
    {RD}                 { popState(); return T_RD; }
    {WHITE_SPACE}        { return WHITE_SPACE; }

    "@"                  { return T_AT; }

    // Control
    {IF}                 { return T_IF; }
    "elseif"             { return T_ELSE_IF; }
    "else"               { return T_ELSE; }
    "endif"              { return T_END_IF; }
    {SLASH} {IF}         { return T_END_IF; }
    "unless"             { return T_UNLESS; }
    "endunless"          { return T_END_UNLESS; }
    {SLASH} {UNLESS}     { return T_END_UNLESS; }

    // Antlers supports a switch construct and a switch Tag. We need to distinguish between those two. Considering that the
    // switch in the control structure is followed by an opening parenthesis, we can use the `/` lookahead of Flex.
    // If the lexer finds `switch (`, he will match up to the open parenthesis (including any whitespaces between `switch` and `(`, but
    // will throw away the whitespaces and parenthesis and return the `T_SWITCH` token to the parser. Those other characters will
    // be tokenized in other rules as `WHITE_SPACE` and `T_LP`.
    "switch" / {WHITE_SPACE}* "(" { return T_SWITCH; }

    "noparse"            { return T_NOPARSE;}

    // Advanced operators
    "as"                 { return T_AS; }
    "groupby"            { return T_GROUP_BY; }
    //"groupby"            { pushState(GROUP_BY); return T_GROUP_BY; }
    "merge"              { return T_MERGE; }
    "orderby"            { return T_ORDER_BY; }
    "pluck"              { return T_PLUCK; }
    "skip"               { return T_SKIP; }
    "take"               { return T_TAKE; }
    "where"              { return T_WHERE; }

    // Boolean
    "true"               { return T_TRUE; }
    "false"              { return T_FALSE; }

    // Logical - Must come before {IDENTIFIER}
    "&&"|"and"           { return T_OP_AND; }
    "||"|"or"            { return T_OP_OR; }
    "xor"                { return T_OP_XOR; }

    // Match Tags like "{{ svg }}" or "{{ collection }}" and switch to the decicated state
    // We match all mutations of a tag name including "%" and ":" and lex them in the state
    {TAG}                { yypushback(yylength()); pushState(TAG_EXPRESSION); }

    // Antlers allows attributes to arrays, consider `{{ page_builder scope="foo" }}`.
    // To make it work, we define a rule in grammar. But here, "scope" is also a Tag and Tags
    // are not allowed in that context. To make it work, we match
    // a Tag followed by an equal sign (the "/" is a positive lookahead in JFlex) and lex it as
    // IDENTIFIER.
    {TAG} / "="          { return T_IDENTIFIER; }

    {RECURSIVE_CHILDREN} { yypushback(yylength()); pushState(RECURSIVE_CHILDREN); }

    {SINGLE_QUOTE}       { pushState(SINGLE_STRING); return T_SINGLE_QUOTE; }
    {DOUBLE_QUOTE}       { pushState(DOUBLE_STRING); return T_DOUBLE_QUOTE; }

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
    ";"                  { return T_SEMICOLON; }
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
    ":"              { return T_COLON; }
    "."              { return T_DOT; }
    "["              { return T_LEFT_BRACKET; }
    "]"              { return T_RIGHT_BRACKET; }
    {INTEGER_NUMBER} { return T_INTEGER_NUMBER; }
    {SINGLE_QUOTE}   { pushState(SINGLE_STRING); return T_SINGLE_QUOTE; }
    {DOUBLE_QUOTE}   { pushState(DOUBLE_STRING); return T_DOUBLE_QUOTE; }
    {IDENTIFIER}     { return T_IDENTIFIER; }
    [^]              {
                       yypushback(1);  // cancel unexpected char
                       popState();     // and try to parse it again in <IN_ANTLERS>
                     }
}

// State to avoid ambiguity between core modifiers and custom variables like: {{ title | title }}
<MODIFIER_LIST> {
    {MODIFIERS}      { return T_MODIFIER; }
    {WHITE_SPACE}    { return TokenType.WHITE_SPACE; }

    // Boolean
    "true"           { return T_TRUE; }
    "false"          { return T_FALSE; }
    ","              { return T_COMMA; }
    "("              { return T_LP; }
    ")"              { popState(); return T_RP; }
    "["              { return T_LEFT_BRACKET; }
    "]"              { return T_RIGHT_BRACKET; }
    {SINGLE_QUOTE}   { pushState(SINGLE_STRING); return T_SINGLE_QUOTE; }
    {DOUBLE_QUOTE}   { pushState(DOUBLE_STRING); return T_DOUBLE_QUOTE; }
    {IDENTIFIER}     { return T_IDENTIFIER; }
    {INTEGER_NUMBER} { return T_INTEGER_NUMBER; }
    {FLOAT_NUMBER}   { return T_FLOAT_NUMBER; }
    [^]              {
                       yypushback(1);  // cancel unexpected char
                       popState();     // and try to parse it again in <IN_ANTLERS>
                     }
}

<TAG_EXPRESSION> {
    {WHITE_SPACE} { pushState(TAG_EXPRESSION_ATTRIBUTE_LIST); return TokenType.WHITE_SPACE; }
    "%"           { return T_DISAMBIGUATION; }
    ":"           { pushState(TAG_SHORTHAND); return T_SHORTHAND_SEPARATOR; }
    {SLASH}       { return T_SLASH; }
    {TAG_NAMES}   { return T_TAG; }
    {IDENTIFIER}  { return T_IDENTIFIER; }
    [^]           {
                    yypushback(1);  // cancel unexpected char
                    popState();     // and try to parse it again in <ANTLERS_NODE>
                  }
}

<TAG_SHORTHAND> {
    {TAG_METHOD_NAME} { return T_TAG_METHOD_NAME; }
    [^]               {
                        yypushback(1);  // cancel unexpected char
                        popState();     // and try to parse it again in <ANTLERS_NODE>
                      }
}

<TAG_EXPRESSION_ATTRIBUTE_LIST> {
    {RD}                    { yybegin(YYINITIAL); return T_RD; }
    {SLASH}                 { return T_SLASH; }
    {WHITE_SPACE}           { return TokenType.WHITE_SPACE; }
    {TAG_STRING_CONDITIONS} { return T_TAG_CONDITION; }
    "taxonomy:"             { return T_TAXONOMY; }
    "="                     { return T_OP_ASSIGN; }
    "{"                     { return T_LEFT_BRACE; }
    "}"                     { return T_RIGHT_BRACE; }
    ":"                     { return T_DYNAMIC_BINDING; }
    {SINGLE_QUOTE}          { pushState(SINGLE_STRING); return T_SINGLE_QUOTE; }
    {DOUBLE_QUOTE}          { pushState(DOUBLE_STRING); return T_DOUBLE_QUOTE; }
    {IDENTIFIER}            { return T_IDENTIFIER; }
    [^]                     {
                              yybegin(ANTLERS_NODE);  // cancel unexpected char
                              popState();     // and try to parse it again in <ANTLERS_NODE>
                            }
}

<RECURSIVE_CHILDREN> {
    {WHITE_SPACE}        { return TokenType.WHITE_SPACE; }
    "*"                  { return T_STAR; }
    ":"                  { return T_COLON; }
    "recursive children" { return T_RECURSIVE_CHILDREN; }
    {IDENTIFIER}         { return T_IDENTIFIER; }
    [^]                  {
                           yypushback(1);  // cancel unexpected char
                           popState();     // and try to parse it again in <ANTLERS_NODE>
                         }
}

<ANTLERS_COMMENT> {
    {COMMENT_CLOSE}  { popState(); return T_COMMENT_CLOSE; }
    ~{COMMENT_CLOSE} { yypushback(3); return T_COMMENT_TEXT; }

    // lex unclosed comments so that we can give better errors
    !([^]*"}}"[^]*)  {  return T_UNCLOSED_COMMENT; }
}

<SINGLE_STRING> {
    {SINGLE_QUOTE}              { popState(); return T_SINGLE_QUOTE; }
    {SINGLE_QUOTED_STR_CONTENT} { return T_STRING_CONTENT; }
    [^]                         {
                                  yypushback(1); // cancel unexpected char
                                  popState();    // and try to parse it again in <ANTLERS_NODE>
                                }
}

<DOUBLE_STRING> {
    {DOUBLE_QUOTE}              { popState(); return T_DOUBLE_QUOTE; }
    {DOUBLE_QUOTED_STR_CONTENT} { return T_STRING_CONTENT; }
    [^]                         {
                                  yypushback(1); // cancel unexpected char
                                  popState();    // and try to parse it again in <ANTLERS_NODE>
                                }
}

<PHP_ECHO> {
    "$}}"  { popState(); return T_PHP_ECHO_CLOSE;}
    ~"$}}" { yypushback(3); return T_PHP_CONTENT;}
}

<PHP_RAW> {
    "?}}"  { popState(); return T_PHP_RAW_CLOSE;}
    ~"?}}" { yypushback(3); return T_PHP_CONTENT;}
}

{WHITE_SPACE}+ { return TokenType.WHITE_SPACE; }
[^]            { return TokenType.BAD_CHARACTER; }
