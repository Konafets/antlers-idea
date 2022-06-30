package de.arrobait.antlers.parser;

import com.intellij.html.embedding.HtmlEmbeddedContentSupport;
import com.intellij.lang.LanguageASTFactory;
import com.intellij.lang.html.HTMLParserDefinition;
import com.intellij.lang.xml.XMLLanguage;
import com.intellij.lang.xml.XmlASTFactory;
import com.intellij.lexer.EmbeddedTokenTypesProvider;
import com.intellij.psi.LanguageFileViewProviders;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.file.AntlersFileViewProviderFactory;

public class AntlersHtmlParserTest extends AntlersParsingTest {

    public AntlersHtmlParserTest() {
        super(new HTMLParserDefinition());
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();

        addExplicitExtension(LanguageFileViewProviders.INSTANCE, AntlersLanguage.INSTANCE, new AntlersFileViewProviderFactory());
        addExplicitExtension(LanguageASTFactory.INSTANCE, AntlersLanguage.INSTANCE, new AntlersAstFactory());
        addExplicitExtension(LanguageASTFactory.INSTANCE, XMLLanguage.INSTANCE, new XmlASTFactory());

        registerExtensionPoint(EmbeddedTokenTypesProvider.EXTENSION_POINT_NAME, EmbeddedTokenTypesProvider.class);
        HtmlEmbeddedContentSupport.register(getApplication(), getTestRootDisposable());
    }

    @Override
    protected boolean checkAllPsiRoots() {
        return true;
    }

    public void testUnclosedDiv() {
      doTest(true);
    }
}
