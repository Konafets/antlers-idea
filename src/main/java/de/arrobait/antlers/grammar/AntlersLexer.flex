package de.arrobait.antlers.grammar;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
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

COMMENT_OPEN="{{#"
COMMENT_CLOSE="#}}"

SINGLE_QUOTE="\'"
DOUBLE_QUOTE="\""

// States
%state ANTLERS_COMMENT
%state ANTLERS_NODE
%state SINGLE_STRING
%state DOUBLE_STRING
%state PHP_ECHO
%state PHP_RAW

%%
<YYINITIAL> {
    {WHITE_SPACE}        { return WHITE_SPACE; }
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

    // Boolean
    "true"               { return T_TRUE; }
    "false"              { return T_FALSE; }

    {SINGLE_QUOTE}       { pushState(SINGLE_STRING); return T_STRING_START; }
    {DOUBLE_QUOTE}       { pushState(DOUBLE_STRING); return T_STRING_START; }
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
