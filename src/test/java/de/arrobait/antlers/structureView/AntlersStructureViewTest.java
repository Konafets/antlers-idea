package de.arrobait.antlers.structureView;

import com.intellij.ide.structureView.StructureView;
import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.impl.StructureViewComposite;
import com.intellij.ide.structureView.newStructureView.StructureViewComponent;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.lang.LanguageStructureViewBuilder;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.io.FileUtil;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import com.intellij.util.Consumer;
import com.intellij.util.PlatformIcons;
import de.arrobait.antlers.file.AntlersFileType;
import de.arrobait.antlers.file.AntlersIcons;
import de.arrobait.antlers.util.AntlersTestUtils;
import org.jetbrains.annotations.NotNull;

import java.io.File;

import static com.intellij.testFramework.PlatformTestUtil.assertTreeEqual;
import static com.intellij.testFramework.PlatformTestUtil.expandAll;

public class AntlersStructureViewTest extends BasePlatformTestCase {
    private static final String TEST_DATA_PATH = new File(AntlersTestUtils.BASE_TEST_DATA_PATH, "structureView").getAbsolutePath();

    public void testSimpleAntlers() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(1, children.length);
            assertEquals("{{ identifier }}", children[0].getPresentation().getPresentableText());
            assertEquals(PlatformIcons.VARIABLE_ICON, children[0].getPresentation().getIcon(false));
        });
    }

    public void testConditionalAntlers() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(1, children.length);
            assertEquals("{{ if 10 > 11 }}", children[0].getPresentation().getPresentableText());
            assertEquals(PlatformIcons.XML_TAG_ICON, children[0].getPresentation().getIcon(false));
        });
    }

    private String loadFile(String name) throws Exception {
        String fullName = new File(TEST_DATA_PATH, name).getAbsolutePath();
        String text = FileUtil.loadFile(new File(fullName));
        text = StringUtil.convertLineSeparators(text);

        return text;
    }

    protected String getFileExtension() {
        return AntlersFileType.DOT_DEFAULT_EXTENSION;
    }

    private void doTest(final String expected) {
        myFixture.configureByFile(getTestName(false) + getFileExtension());
        myFixture.testStructureView(svc -> {
            expandAll(svc.getTree());
            assertTreeEqual(svc.getTree(), expected);
        });
    }

    private void doTestTreeStructure(@NotNull Consumer<StructureViewModel> consumer) throws Exception {
        myFixture.configureByText(AntlersFileType.INSTANCE, loadFile(getTestName(false) + getFileExtension()));
        final StructureViewBuilder builder = LanguageStructureViewBuilder.INSTANCE.getStructureViewBuilder(myFixture.getFile());
        assertNotNull(builder);
        StructureViewComponent component = null;

        try {
            final FileEditor editor = FileEditorManager.getInstance(getProject()).getSelectedEditor(myFixture.getFile().getVirtualFile());
            StructureViewComposite structureView = (StructureViewComposite) builder.createStructureView(editor, myFixture.getProject());
            component = (StructureViewComponent) structureView.getSelectedStructureView();
            assert component != null;
            final StructureViewModel model = component.getTreeModel();
            consumer.consume(model);
        }
        finally {
            if (component != null) {
                Disposer.dispose(component);
            }
        }
    }
}
