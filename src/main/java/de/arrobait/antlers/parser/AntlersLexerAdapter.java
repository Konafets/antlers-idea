package de.arrobait.antlers.parser;

import com.intellij.lexer.FlexAdapter;
import de.arrobait.antlers.grammar.AntlersLexer;

public class AntlersLexerAdapter extends FlexAdapter {
    public AntlersLexerAdapter() {
        super(new AntlersLexer(null));
    }
}
