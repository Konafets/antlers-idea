package de.arrobait.antlers.parser;

import com.intellij.lang.ParserDefinition;
import com.intellij.mock.MockApplication;
import com.intellij.psi.templateLanguages.TemplateDataLanguageMappings;
import com.intellij.psi.templateLanguages.TemplateDataLanguagePatterns;
import com.intellij.testFramework.ParsingTestCase;
import com.intellij.util.ArrayUtil;
import de.arrobait.antlers.file.AntlersFileType;
import de.arrobait.antlers.util.AntlersTestUtils;
import org.jetbrains.annotations.NotNull;

public class AntlersParsingTest extends ParsingTestCase {
    public AntlersParsingTest(@NotNull String dataPath) {
        super(dataPath, AntlersFileType.DEFAULT_EXTENSION, new AntlersParserDefinition());
    }

    public AntlersParsingTest(ParserDefinition @NotNull ... additionalDefinitions) {
        super("parsing", AntlersFileType.DEFAULT_EXTENSION, ArrayUtil.prepend(new AntlersParserDefinition(), additionalDefinitions));
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        MockApplication app = getApplication();

        myProject.registerService(TemplateDataLanguageMappings.class, TemplateDataLanguageMappings.class);

        app.registerService(TemplateDataLanguagePatterns.class, new TemplateDataLanguagePatterns());
        registerParserDefinition(new AntlersParserDefinition());
    }

    @Override
    protected String getTestDataPath() {
        return AntlersTestUtils.BASE_TEST_DATA_PATH;
    }

    @Override
    protected boolean checkAllPsiRoots() {
        return false;
    }
}
