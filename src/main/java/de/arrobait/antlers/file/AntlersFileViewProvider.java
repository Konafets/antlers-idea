package de.arrobait.antlers.file;

import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.psi.AntlersTypes;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.html.HTMLLanguage;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.LanguageSubstitutors;
import com.intellij.psi.MultiplePsiFilesPerDocumentFileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import com.intellij.psi.templateLanguages.TemplateLanguageFileViewProvider;
import com.intellij.psi.tree.OuterLanguageElementType;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Set;

public class AntlersFileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements TemplateLanguageFileViewProvider {
    private final Language templateDataLanguage;
    private static final TemplateDataElementType htmlTemplateDataType;

    public AntlersFileViewProvider(PsiManager manager, VirtualFile virtualFile, boolean eventSystemEnabled) {
        super(manager, virtualFile, eventSystemEnabled);

        Language language = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(virtualFile);
        if (language == null) {
            language = HTMLLanguage.INSTANCE;
        }

        if (language instanceof TemplateLanguage) {
            this.templateDataLanguage = language;
        } else {
            this.templateDataLanguage = LanguageSubstitutors.getInstance().substituteLanguage(language, virtualFile, manager.getProject());
        }
    }

    public AntlersFileViewProvider(PsiManager manager, VirtualFile virtualFile, boolean eventSystemEnabled, Language templateDataLanguage) {
        super(manager, virtualFile, eventSystemEnabled);
        this.templateDataLanguage = templateDataLanguage;
    }

    @NotNull
    @Override
    public Language getBaseLanguage() {
        return AntlersLanguage.INSTANCE;
    }

    @NotNull
    @Override
    public Language getTemplateDataLanguage() {
        return templateDataLanguage;
    }

    @NotNull
    @Override
    public Set<Language> getLanguages() {
        return new THashSet<>(Arrays.asList(new Language[]{AntlersLanguage.INSTANCE, this.getTemplateDataLanguage()}));
    }

    @NotNull
    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(@NotNull VirtualFile fileCopy) {
        return new AntlersFileViewProvider(getManager(), fileCopy, false, this.templateDataLanguage);
    }

    @Nullable
    @Override
    protected PsiFile createFile(@NotNull Language language) {
        ParserDefinition parser = LanguageParserDefinitions.INSTANCE.forLanguage(language);

        if (parser == null) {
            return null;
        } else {
            PsiFileImpl file;
            if (language == this.getTemplateDataLanguage()) {
                file = (PsiFileImpl) parser.createFile(this);
                file.setContentElementType(htmlTemplateDataType);
                return file;
            } else if (language == this.getBaseLanguage()) {
                return parser.createFile(this);
            } else {
                return null;
            }
        }
    }

    static {
        htmlTemplateDataType = new TemplateDataElementType(
                "HTML in Antlers",
                AntlersLanguage.INSTANCE,
                AntlersTypes.OUTER_CONTENT,
                new OuterLanguageElementType("OUTER_CONTENT", AntlersLanguage.INSTANCE)) {};
    }
}
