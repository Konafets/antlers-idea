package de.arrobait.antlers.format;

import com.intellij.application.options.CodeStyle;
import com.intellij.codeInsight.generation.AutoIndentLinesHandler;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.impl.DocumentImpl;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.TextRange;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.codeStyle.CodeStyleManager;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import com.intellij.util.IncorrectOperationException;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.file.AntlersFileType;
import de.arrobait.antlers.util.AntlersTestUtils;
import org.jetbrains.annotations.NonNls;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

@RunWith(JUnit4.class)
abstract class AntlersFormatterTestCase extends BasePlatformTestCase implements AntlersFormattingModelBuilderTest {
    private static final String TEST_DATA_PATH = new File(AntlersTestUtils.BASE_TEST_DATA_PATH, "formatter").getAbsolutePath();

    protected String getFileExtension() {
        return AntlersFileType.Companion.getDOT_DEFAULT_EXTENSION();
    }

    protected FormatterTestSettings formatterTestSettings;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        formatterTestSettings = new FormatterTestSettings(CodeStyle.getSettings(getProject()));
        formatterTestSettings.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        try {
            formatterTestSettings.tearDown();
        } catch (Throwable e) {
            addSuppressedException(e);
        } finally {
            super.tearDown();
        }
    }

    void doFileBasedTest() throws Exception {
        doFileBasedTest(getTestName(false) + getFileExtension());
    }

    void doFileBasedTest(@NonNls String fileNameBefore) throws Exception {
        doFileBasedTest(fileNameBefore, AntlersLanguage.getDefaultTemplateLang());
    }

    void doFileBasedTest(@NonNls String fileNameBefore, LanguageFileType templateDataLanguageType) throws Exception {
        String extension = getFileExtension();
        doTextTest(loadFile(fileNameBefore + extension),
                loadFile(fileNameBefore + "_expected" + extension),
                extension,
                templateDataLanguageType);
    }

    void doStringBasedTest(@NonNls final String text, @NonNls String textAfter) throws IncorrectOperationException {
        doTextTest(text, textAfter, AntlersFileType.Companion.getDOT_DEFAULT_EXTENSION(), AntlersLanguage.getDefaultTemplateLang());
    }

    void doTextTest(final String beforeText, String textAfter, String extension, LanguageFileType templateDataLanguageType) throws IncorrectOperationException {
        // define action to run "Reformat Code" on the whole "file" defined by beforeText
        Runnable fullFormatRunnableFactory = () -> {
            TextRange rangeToUse = myFixture.getFile().getTextRange();
            CodeStyleManager styleManager = CodeStyleManager.getInstance(getProject());
            styleManager.reformatText(myFixture.getFile(), rangeToUse.getStartOffset(), rangeToUse.getEndOffset());
        };

        // define action to run "Adjust line indent" on every line in the "file" defined by beforeText
        Runnable lineFormatRunnableFactory = () -> {
            Editor editor = myFixture.getEditor();
            editor.getSelectionModel().setSelection(0, editor.getDocument().getTextLength());
            new AutoIndentLinesHandler().invoke(myFixture.getProject(), editor, myFixture.getFile());
        };

        doFormatterActionTest(fullFormatRunnableFactory, beforeText, textAfter, extension, templateDataLanguageType);
        doFormatterActionTest(lineFormatRunnableFactory, beforeText, textAfter, extension, templateDataLanguageType);
    }

    private void doFormatterActionTest(final Runnable formatAction,
                                       final String beforeText,
                                       String textAfter,
                                       String extension,
                                       LanguageFileType templateDataLanguageType) {
        PsiFile baseFile = myFixture.configureByText("A" + extension, beforeText);

        VirtualFile virtualFile = baseFile.getVirtualFile();
        assert virtualFile != null;
        TemplateDataLanguageMappings.getInstance(getProject()).setMapping(virtualFile, templateDataLanguageType.getLanguage());

        // fetch a fresh instance of the file -- the template data mapping creates a new instance
        // which was causing problems in PsiFileImpl.isValid()
        final PsiFile file = PsiManager.getInstance(getProject()).findFile(virtualFile);
        assert file != null;

        WriteCommandAction.runWriteCommandAction(getProject(), formatAction);
        TemplateDataLanguageMappings.getInstance(getProject()).cleanupForNextTest();
        assertEquals("Reformat Code failed", prepareText(textAfter), prepareText(file.getText()));
    }

    private String prepareText(String actual) {
        actual = StringUtil.trimStart(actual, "\n");
        actual = StringUtil.trimStart(actual, "\n");

        // Strip trailing spaces
        final Document doc = EditorFactory.getInstance().createDocument(actual);
        CommandProcessor.getInstance().executeCommand(getProject(), () -> ApplicationManager.getApplication().runWriteAction(() -> {
            ((DocumentImpl) doc).stripTrailingSpaces(getProject());
        }), "Formatting", null);

        return doc.getText();
    }

    private String loadFile(String name) throws Exception {
        String fullName = new File(TEST_DATA_PATH, name).getAbsolutePath();
        String text = FileUtil.loadFile(new File(fullName));
        text = StringUtil.convertLineSeparators(text);

        return text;
    }
}
