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
import com.intellij.psi.tree.OuterLanguageElementType;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.psi.AntlersTypes;
import gnu.trove.THashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Set;

public class AntlersFileViewProvider extends MultiplePsiFilesPerDocumentFileViewProvider implements TemplateLanguageFileViewProvider {
    private final Language myBaseLanguage;
    private final Language myTemplateLanguage;
    private static final TemplateDataElementType htmlTemplateDataType;

    public AntlersFileViewProvider(PsiManager manager, VirtualFile virtualFile, boolean eventSystemEnabled, Language baseLanguage) {
        this(manager, virtualFile, eventSystemEnabled, baseLanguage, getTemplateDataLanguage(manager, virtualFile));
    }

    public AntlersFileViewProvider(PsiManager manager, VirtualFile virtualFile, boolean eventSystemEnabled, Language baseLanguage, Language templateDataLanguage) {
        super(manager, virtualFile, eventSystemEnabled);
        this.myBaseLanguage = baseLanguage;
        this.myTemplateLanguage = templateDataLanguage;
    }

    private static @NotNull Language getTemplateDataLanguage(PsiManager manager, VirtualFile file) {
        Language dataLang = null;
        TemplateDataLanguageMappings templateDataLanguageMappings = TemplateDataLanguageMappings.getInstance(manager.getProject());
        if (templateDataLanguageMappings != null) {
            dataLang = TemplateDataLanguageMappings.getInstance(manager.getProject()).getMapping(file);
        }
        if (dataLang == null) {
            dataLang = AntlersLanguage.getDefaultTemplateLang().getLanguage();
        }

        Language substituteLang = LanguageSubstitutors.getInstance().substituteLanguage(dataLang, file, manager.getProject());

        // only use a substituted lang if its template-able
        if (TemplateDataLanguageMappings.getTemplateableLanguages().contains(substituteLang)) {
            dataLang = substituteLang;
        }

        return dataLang;
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
        return new THashSet<>(Arrays.asList(AntlersLanguage.INSTANCE, this.getTemplateDataLanguage()));
    }

    @NotNull
    @Override
    protected MultiplePsiFilesPerDocumentFileViewProvider cloneInner(@NotNull VirtualFile fileCopy) {
        return new AntlersFileViewProvider(getManager(), fileCopy, false, this.myTemplateLanguage);
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
                ((PsiFileImpl)file).setContentElementType(type);
            }

            return file;
        } else if (language.isKindOf(getBaseLanguage())) {
            return parserDefinition.createFile(this);
        }

        return null;

//        ParserDefinition parser = LanguageParserDefinitions.INSTANCE.forLanguage(language);
//
//        if (parser == null) {
//            return null;
//        } else {
//            PsiFileImpl file;
//            if (language == this.getTemplateDataLanguage()) {
//                file = (PsiFileImpl) parser.createFile(this);
//                file.setContentElementType(htmlTemplateDataType);
//                return file;
//            } else if (language == this.getBaseLanguage()) {
//                return parser.createFile(this);
//            } else {
//                return null;
//            }
//        }
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

    @Override
    public @Nullable IElementType getContentElementType(@NotNull Language language) {
        if (language.is(getTemplateDataLanguage())) {
            return htmlTemplateDataType;
        }

        return null;
    }

    static {
        htmlTemplateDataType = new TemplateDataElementType(
                "HTML in Antlers",
                AntlersLanguage.INSTANCE,
                AntlersTypes.OUTER_CONTENT,
                new OuterLanguageElementType("OUTER_CONTENT", AntlersLanguage.INSTANCE)) {};
    }
}
