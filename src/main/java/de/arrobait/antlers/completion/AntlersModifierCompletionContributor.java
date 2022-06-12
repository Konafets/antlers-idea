package de.arrobait.antlers.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import de.arrobait.antlers.CoreModifierProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AntlersModifierCompletionContributor extends CompletionContributor {
    public AntlersModifierCompletionContributor() {
        final List<LookupElementBuilder> modifiers = CoreModifierProvider.getModifiers();

        extend(CompletionType.BASIC, PlatformPatterns.psiElement().afterLeaf("|"),
                new CompletionProvider<>() {
                    @Override
                    public void addCompletions(@NotNull CompletionParameters parameters, @NotNull ProcessingContext context, @NotNull CompletionResultSet resultSet) {
                        resultSet.addAllElements(modifiers);
                    }
                }
        );
    }
}
