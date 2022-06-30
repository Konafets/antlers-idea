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
import com.intellij.psi.templateLanguages.ConfigurableTemplateLanguageFileViewProvider;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.AntlersLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static de.arrobait.antlers.psi.AntlersTypes.OUTER_CONTENT;
import static de.arrobait.antlers.psi.AntlersCustomElementTypes.OUTER_ELEMENT_TYPE;

public class AntlersFileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements ConfigurableTemplateLanguageFileViewProvider {
    private final Language myBaseLanguage;

    private static final ConcurrentMap<String, TemplateDataElementType> TEMPLATE_DATA_TO_LANG = new ConcurrentHashMap<>();

    private final Language myTemplateLanguage;

    public AntlersFileViewProvider(PsiManager manager, VirtualFile file, boolean physical, Language baseLanguage) {
        this(manager, file, physical, baseLanguage, getTemplateDataLanguage(manager, file));
    }

    public AntlersFileViewProvider(PsiManager manager, VirtualFile file, boolean physical, Language baseLanguage, Language templateLanguage) {
        super(manager, file, physical);
        myBaseLanguage = baseLanguage;
        myTemplateLanguage = templateLanguage;
    }

    private static TemplateDataElementType getTemplateDataElementType(Language language) {
        TemplateDataElementType result = TEMPLATE_DATA_TO_LANG.get(language.getID());

        if (result != null) {
            return result;
        }

        TemplateDataElementType created = new TemplateDataElementType("ANTLERS_TEMPLATE_DATA", language, OUTER_CONTENT, OUTER_ELEMENT_TYPE);
        TemplateDataElementType prevValue = TEMPLATE_DATA_TO_LANG.putIfAbsent(language.getID(), created);

        return prevValue == null ? created : prevValue;
    }

    @Override
    public boolean supportsIncrementalReparse(@NotNull Language rootLanguage) {
        return false;
    }

    private static @NotNull Language getTemplateDataLanguage(PsiManager manager, VirtualFile file) {
        Language dataLanguage = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(file);
        if (dataLanguage == null) {
            dataLanguage = AntlersLanguage.getDefaultTemplateLang().getLanguage();
        }

        Language substituteLanguage = LanguageSubstitutors.getInstance().substituteLanguage(dataLanguage, file, manager.getProject());

        // only use a substituted language if its templatable
        if (TemplateDataLanguageMappings.getTemplateableLanguages().contains(substituteLanguage)) {
            dataLanguage = substituteLanguage;
        }

        return dataLanguage;
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
        ParserDefinition parserDefinition = getDefinition(language);
        if (parserDefinition == null) {
            return null;
        }

        if (language.is(getTemplateDataLanguage())) {
            PsiFile file = parserDefinition.createFile(this);
            IElementType type = getContentElementType(language);
            if (type != null) {
                ((PsiFileImpl) file).setContentElementType(type);
            }
            return file;
        } else if (language.isKindOf(getBaseLanguage())) {
            return parserDefinition.createFile(this);
        }

        return null;
    }

    @Override
    public @Nullable IElementType getContentElementType(@NotNull Language language) {
        if (language.is(getTemplateDataLanguage())) {
            return getTemplateDataElementType(getBaseLanguage());
        }

        return null;
    }

    private ParserDefinition getDefinition(Language language) {
        ParserDefinition parserDefinition;
        if (language.isKindOf(getBaseLanguage())) {
            parserDefinition = LanguageParserDefinitions.INSTANCE.forLanguage(language.is(getBaseLanguage()) ? language : getBaseLanguage());
        } else {
            parserDefinition = LanguageParserDefinitions.INSTANCE.forLanguage(language);
        }

        return parserDefinition;
    }
}
