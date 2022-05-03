package de.arrobait.antlers.grammar;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;

import java.util.Stack;

import static de.arrobait.antlers.psi.AntlersTypes.*;

%%

%{
    private final Stack<Integer> lexStateStack = new Stack<java.lang.Integer>();

    public AntlersLexer() {
        this((java.io.Reader)null);
    }

    private void pushState(int state) {
      lexStateStack.push(yystate());
      yybegin(state);
    }

    private void popState() {
      if (lexStateStack.empty()) {
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

COMMENT_OPEN="{{#"
COMMENT_CLOSE="#}}"

// States
%state IN_ANTLERS_COMMENT

%%
<YYINITIAL> {
    {COMMENT_OPEN}       { yypushback(yylength() - 3); pushState(IN_ANTLERS_COMMENT); return T_COMMENT_OPEN;}
    {WHITE_SPACE}        { return WHITE_SPACE; }

    !([^]*"{"[^]*)              { return OUTER_CONTENT; }
}

<IN_ANTLERS_COMMENT> {
    {COMMENT_CLOSE}             { popState(); return T_COMMENT_CLOSE; }
    ~{COMMENT_CLOSE}            { yypushback(3); return T_COMMENT_TEXT; }
}

[^] { yybegin(YYINITIAL); return OUTER_CONTENT; }
