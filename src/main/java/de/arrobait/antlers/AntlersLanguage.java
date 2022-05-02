package de.arrobait.antlers;

import com.intellij.ide.highlighter.HtmlFileType;
import com.intellij.lang.InjectableLanguage;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.psi.templateLanguages.TemplateLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersLanguage extends Language implements TemplateLanguage, InjectableLanguage {
  public static final AntlersLanguage INSTANCE = new AntlersLanguage();

  @SuppressWarnings("SameReturnValue") // ideally this would be public static, but the static inits in the tests get cranky when we do that
  public static LanguageFileType getDefaultTemplateLang() {
    return HtmlFileType.INSTANCE;
  }

  public AntlersLanguage() {
    super("Antlers", "text/x-antlers-template", "text/x-antlers");
  }

  public AntlersLanguage(@Nullable Language baseLanguage, @NotNull @NonNls final String ID, @NonNls final String @NotNull ... mimeTypes) {
    super(baseLanguage, ID, mimeTypes);
  }
}
