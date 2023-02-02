package de.arrobait.antlers.file;

import com.intellij.ide.highlighter.XmlLikeFileType;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.CharsetUtil;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.fileTypes.TemplateLanguageFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import de.arrobait.antlers.AntlersLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.nio.charset.Charset;

public class AntlersFileType extends XmlLikeFileType implements TemplateLanguageFileType {
    @NonNls
    public static final String DOT_DEFAULT_EXTENSION = ".antlers.html";

    public static final LanguageFileType INSTANCE = new AntlersFileType();

    @NonNls
    public static final String DEFAULT_EXTENSION = "antlers.html";

    private AntlersFileType() {
        super(AntlersLanguage.INSTANCE);
    }

    protected AntlersFileType(Language language) {
        super(language);
    }

    @NotNull
    @Override
    public String getName() {
      return "Antlers";
    }

    @NotNull
    @Override
    public String getDescription() {
      return "Antlers template file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
      return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
      return AntlersIcons.FILE;
    }

    @Override
    public Charset extractCharsetFromFileContent(@Nullable final Project project, @Nullable final VirtualFile file, @NotNull final CharSequence content) {
        LanguageFileType associatedFileType = getAssociatedFileType(file, project);

        if (associatedFileType == null) {
            return null;
        }

        return CharsetUtil.extractCharsetFromFileContent(project, file, associatedFileType, content);
    }

    private static LanguageFileType getAssociatedFileType(VirtualFile file, Project project) {
        if (project == null) {
            return null;
        }

        Language language = TemplateDataLanguageMappings.getInstance(project).getMapping(file);

        LanguageFileType associatedFileType = null;
        if (language != null) {
            associatedFileType = language.getAssociatedFileType();
        }

        if (language == null || associatedFileType == null) {
            associatedFileType = AntlersLanguage.getDefaultTemplateLang();
        }

        return associatedFileType;
    }
}
