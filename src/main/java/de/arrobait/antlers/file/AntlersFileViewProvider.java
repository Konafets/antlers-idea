package de.arrobait.antlers.file;

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
import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.AntlersLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

import static de.arrobait.antlers.psi.AntlersCustomElementTypes.OUTER_ANTLERS;
import static de.arrobait.antlers.psi.AntlersTypes.OUTER_CONTENT;

public class AntlersFileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements TemplateLanguageFileViewProvider {
    private final Language myBaseLanguage;

    private final Language myTemplateLanguage;

    public static IElementType templateDataElement = new TemplateDataElementType(
            "ANTLERS_TEMPLATE_DATA",
            AntlersLanguage.INSTANCE,
            OUTER_CONTENT,
            OUTER_ANTLERS
    );

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
        Language dataLanguage = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(file);
        if (dataLanguage == null) {
            dataLanguage = AntlersLanguage.getDefaultTemplateLang().getLanguage();
        }

        Language substituteLanguage = LanguageSubstitutors.getInstance().substituteLanguage(dataLanguage, file, manager.getProject());

        if (TemplateDataLanguageMappings.getTemplateableLanguages().contains(substituteLanguage)) {
            dataLanguage = substituteLanguage;
        }

        return dataLanguage;
    }

    @NotNull
    @Override
    public Set<Language> getLanguages() {
        return Set.of(myBaseLanguage, getTemplateDataLanguage());
    }

    @NotNull
    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(@NotNull VirtualFile fileCopy) {
        return new AntlersFileViewProvider(getManager(), fileCopy, false, myBaseLanguage, myTemplateLanguage);
    }

    @Nullable
    @Override
    protected PsiFile createFile(@NotNull Language language) {
        ParserDefinition parserDefinition = getParserDefinition(language);

        if (parserDefinition == null) {
            return null;
        }

        if (language.is(getTemplateDataLanguage())) {
            PsiFileImpl file = (PsiFileImpl) parserDefinition.createFile(this);
            file.setContentElementType(templateDataElement);
            return file;
        } else if (language.isKindOf(getBaseLanguage())) {
            return parserDefinition.createFile(this);
        } else {
            return null;
        }
    }

    private ParserDefinition getParserDefinition(Language language) {
        ParserDefinition parserDefinition;
        if (language.isKindOf(getBaseLanguage())) {
            parserDefinition = LanguageParserDefinitions.INSTANCE.forLanguage(language.is(getBaseLanguage()) ? language : getBaseLanguage());
        } else {
            parserDefinition = LanguageParserDefinitions.INSTANCE.forLanguage(language);
        }

        return parserDefinition;
    }
}
