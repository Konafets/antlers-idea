package de.arrobait.antlers.highlighting;

import com.intellij.lang.Language;
import com.intellij.mock.MockProjectEx;
import com.intellij.mock.MockPsiManager;
import com.intellij.openapi.application.ex.PathManagerEx;
import com.intellij.openapi.fileEditor.impl.LoadTextUtil;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.vfs.CharsetToolkit;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.PsiFileFactoryImpl;
import com.intellij.testFramework.EditorTestUtil;
import com.intellij.testFramework.LightVirtualFile;
import com.intellij.testFramework.TestDataFile;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import de.arrobait.antlers.AntlersLanguage;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public abstract class HighlightTestCase extends BasePlatformTestCase {
    protected Language language = AntlersLanguage.INSTANCE;

    protected MockProjectEx myProject;

    private PsiFileFactoryImpl myFileFactory;

    protected PsiFile myFile;

    private final String myFileExt;

    protected final String myFullDataPath;

    private final boolean myLowercaseFirstLetter;

    protected HighlightTestCase(@NotNull String dataPath, @NotNull String fileExt) {
      this(dataPath, fileExt, false);
    }

    protected HighlightTestCase(@NotNull String dataPath, @NotNull String fileExt, boolean lowercaseFirstLetter) {
        myFullDataPath = getTestDataPath() + "/" + dataPath;
        myFileExt = fileExt;
        myLowercaseFirstLetter = lowercaseFirstLetter;
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();

        myProject = new MockProjectEx(getTestRootDisposable());
        MockPsiManager myPsiManager = new MockPsiManager(myProject);
        myFileFactory = new PsiFileFactoryImpl(myPsiManager);
    }

    protected String getTestDataPath() {
      return PathManagerEx.getTestDataPath();
    }

    protected void doTest() {
      String name = getTestName();
      try {
        PsiFile testFile = parseFile(name, loadFile(name + "." + myFileExt));
        EditorTestUtil.testFileSyntaxHighlighting(testFile, myFullDataPath + '/' + name + ".txt", false);
      }
      catch (IOException e) {
        throw new RuntimeException(e);
      }
    }

    @NotNull
    public final String getTestName() {
      return getTestName(myLowercaseFirstLetter);
    }

    protected String loadFile(@NotNull @TestDataFile String name) throws IOException {
        return loadFileDefault(myFullDataPath, name);
    }

    public static String loadFileDefault(@NotNull String dir, @NotNull String name) throws IOException {
      return FileUtil.loadFile(new File(dir, name), CharsetToolkit.UTF8, true).trim();
    }

    protected PsiFile parseFile(String name, String text) {
        myFile = createPsiFile(name, text);
        assertEquals("light virtual file text mismatch", text, ((LightVirtualFile) myFile.getVirtualFile()).getContent().toString());
        assertEquals("virtual file text mismatch", text, LoadTextUtil.loadText(myFile.getVirtualFile()));
        return myFile;
    }

    protected PsiFile createPsiFile(@NotNull String name, @NotNull String text) {
        return createFile(name + "." + myFileExt, text);
    }

    protected PsiFile createFile(@NotNull String name, @NotNull String text) {
      LightVirtualFile virtualFile = new LightVirtualFile(name, language, text);
      virtualFile.setCharset(StandardCharsets.UTF_8);
      return createFile(virtualFile);
    }

    protected PsiFile createFile(@NotNull LightVirtualFile virtualFile) {
      return myFileFactory.trySetupPsiForFile(virtualFile, language, true, false);
    }
}
