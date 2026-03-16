package de.arrobait.antlers.parser;

import com.intellij.lang.ASTFactory;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.templateLanguages.OuterLanguageElementImpl;
import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.psi.AntlersCustomElementTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersAstFactory extends ASTFactory {
    @Override
    public @Nullable LeafElement createLeaf(@NotNull IElementType type, @NotNull CharSequence text) {
        return super.createLeaf(type, text);
    }
}
