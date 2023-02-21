package de.arrobait.antlers.format;

import com.intellij.formatting.Alignment;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Wrap;
import com.intellij.formatting.templateLanguages.DataLanguageBlockWrapper;
import com.intellij.formatting.templateLanguages.TemplateLanguageBlockFactory;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.xml.HtmlPolicy;
import de.arrobait.antlers.psi.AntlersFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AntlersCommentBlock extends AntlersAbstractBlock {

    public AntlersCommentBlock(@NotNull ASTNode node,
                               @Nullable Wrap wrap,
                               @Nullable Alignment alignment,
                               @NotNull TemplateLanguageBlockFactory blockFactory,
                               @NotNull CodeStyleSettings customSettings,
                               @Nullable List<DataLanguageBlockWrapper> foreignChildren,
                               @NotNull HtmlPolicy policy) {
        super(node, wrap, alignment, blockFactory, customSettings, foreignChildren, policy);
    }

    /**
     * Only indent comment when they are not on the root level
     * aka a direct child of the root node (file).
     */
    @Override
    public Indent getIndent() {
        PsiElement parent = myNode.getTreeParent().getPsi();
        if (!(parent instanceof AntlersFile)) {
            return Indent.getNormalIndent();
        }

        return Indent.getNoneIndent();
    }
}
