package de.arrobait.antlers.editor.braces;

import com.intellij.codeInsight.highlighting.PairedBraceMatcherAdapter;
import de.arrobait.antlers.AntlersLanguage;

public class AntlersBraceMatcherAdapter extends PairedBraceMatcherAdapter {
    public AntlersBraceMatcherAdapter() {
        super(new AntlersBraceMatcher(), AntlersLanguage.INSTANCE);
    }
}
