package de.arrobait.antlers.file;

import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.psi.AntlersTypes;
import com.intellij.lang.Language;
import com.intellij.lang.LanguageParserDefinitions;
import com.intellij.lang.ParserDefinition;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.LanguageSubstitutors;
import com.intellij.psi.MultiplePsiFilesPerDocumentFileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.source.PsiFileImpl;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.psi.templateLanguages.TemplateLanguageFileViewProvider;
import com.intellij.psi.tree.OuterLanguageElementType;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Set;

public class AntlersFileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements TemplateLanguageFileViewProvider {
    private final Language myBaseLanguage;
    private final Language myTemplateLanguage;
    private static final TemplateDataElementType htmlTemplateDataType;

    public AntlersFileViewProvider(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage) {
        this(manager, file, eventSystemEnabled, baseLanguage, getTemplateDataLanguage(manager, file));
    }

    public AntlersFileViewProvider(PsiManager manager, VirtualFile file, boolean eventSystemEnabled, Language baseLanguage, Language templateLanguage) {
        super(manager, file, eventSystemEnabled);
        myBaseLanguage = baseLanguage;
        myTemplateLanguage = templateLanguage;
    }

    @NotNull
    @Override
    public Language getBaseLanguage() {
        return myBaseLanguage;
    }

    @NotNull
    @Override
    public Language getTemplateDataLanguage() {
        return myTemplateLanguage;
    }

    private static @NotNull Language getTemplateDataLanguage(PsiManager manager, VirtualFile file) {
        Language language = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(file);
        if (language == null) {
            language = AntlersLanguage.getDefaultTemplateLang().getLanguage();
        }

        Language substituteLanguage = LanguageSubstitutors.getInstance().substituteLanguage(language, file, manager.getProject());

        if (TemplateDataLanguageMappings.getTemplateableLanguages().contains(substituteLanguage)) {
            language = substituteLanguage;
        }

        return language;
    }

    @NotNull
    @Override
    public Set<Language> getLanguages() {
        return new THashSet<>(Arrays.asList(myBaseLanguage, getTemplateDataLanguage()));
    }

    @NotNull
    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(@NotNull VirtualFile fileCopy) {
        return new AntlersFileViewProvider(getManager(), fileCopy, false, myBaseLanguage, myTemplateLanguage);
    }

    @Nullable
    @Override
    protected PsiFile createFile(@NotNull Language language) {
        ParserDefinition parserDefinition = LanguageParserDefinitions.INSTANCE.forLanguage(language);

        if (parserDefinition == null) {
            return null;
        }

        if (language.is(getTemplateDataLanguage())) {
            PsiFileImpl file = (PsiFileImpl) parserDefinition.createFile(this);
            file.setContentElementType(htmlTemplateDataType);
            return file;
        } else if (language.isKindOf(getBaseLanguage())) {
            return parserDefinition.createFile(this);
        } else {
            return null;
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
