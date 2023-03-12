package de.arrobait.antlers.structureView;

import com.intellij.icons.AllIcons;
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
import icons.PhpIcons;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;

import static com.intellij.testFramework.PlatformTestUtil.assertTreeEqual;
import static com.intellij.testFramework.PlatformTestUtil.expandAll;

@RunWith(JUnit4.class)
public class AntlersStructureViewTest extends BasePlatformTestCase {
    private static final String TEST_DATA_PATH = new File(AntlersTestUtils.BASE_TEST_DATA_PATH, "structureView").getAbsolutePath();

    @Test
    public void testEmptyFile() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(0, children.length);
        });
    }

    @Test
    public void testSimpleAntlers() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(1, children.length);

            TreeElement element = children[0];
            assertEquals("{{ identifier }}", element.getPresentation().getPresentableText());
            assertEquals(PlatformIcons.VARIABLE_ICON, element.getPresentation().getIcon(false));
        });
    }

    @Test
    public void testConditionals() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(2, children.length);

            TreeElement element = children[0];
            assertEquals("{{ if 10 > 11 }}", element.getPresentation().getPresentableText());
            assertEquals(PlatformIcons.XML_TAG_ICON, element.getPresentation().getIcon(false));

            assertEquals(1, children[0].getChildren().length);
            element = children[0].getChildren()[0];
            assertEquals("{{ \"yes\" }}", element.getPresentation().getPresentableText());
            assertEquals(PlatformIcons.VARIABLE_ICON, element.getPresentation().getIcon(false));
        });
    }

    @Test
    public void testSwitchNode() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(2, children.length);

            TreeElement element = children[0];
            assertEquals("{{ size = 'lg' }}", element.getPresentation().getPresentableText());
            assertEquals(PlatformIcons.VARIABLE_ICON, element.getPresentation().getIcon(false));

            element = children[1];
            assertEquals("{{ switch }}", element.getPresentation().getPresentableText());
            assertEquals(PlatformIcons.XML_TAG_ICON, element.getPresentation().getIcon(false));
        });
    }

    @Test
    public void testSingleTag() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(1, children.length);

            TreeElement element = children[0];
            assertEquals("{{ 404 }}", element.getPresentation().getPresentableText());
            assertEquals(AllIcons.Nodes.Type, element.getPresentation().getIcon(false));
        });
    }

    @Test
    public void testTagPair() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(1, children.length);

            TreeElement element = children[0];
            assertEquals("{{ collection }}", element.getPresentation().getPresentableText());
            assertEquals(AllIcons.Nodes.Type, element.getPresentation().getIcon(false));

            assertEquals(2, children[0].getChildren().length);

            element = children[0].getChildren()[0];
            assertEquals("{{ url }}", element.getPresentation().getPresentableText());
            assertEquals(PlatformIcons.VARIABLE_ICON, element.getPresentation().getIcon(false));

            element = children[0].getChildren()[1];
            assertEquals("{{ title }}", element.getPresentation().getPresentableText());
            assertEquals(PlatformIcons.VARIABLE_ICON, element.getPresentation().getIcon(false));
        });
    }

    @Test
    public void testVariableAssignmentNode() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(1, children.length);

            TreeElement element = children[0];
            assertEquals("{{ todo = ['Get haircut', 'Bake bread', 'Eat soup'] }}", element.getPresentation().getPresentableText());
            assertEquals(PlatformIcons.VARIABLE_ICON, element.getPresentation().getIcon(false));
        });
    }

    @Test
    public void testNoParseRegionNode() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(1, children.length);

            TreeElement element = children[0];
            assertEquals("{{ noparse }}", element.getPresentation().getPresentableText());
            assertEquals(PlatformIcons.VARIABLE_ICON, element.getPresentation().getIcon(false));
        });
    }

    @Test
    public void testRecursiveChildrenNode() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(1, children.length);

            TreeElement element = children[0];
            assertEquals("{{ nav }}", element.getPresentation().getPresentableText());
            assertEquals(AllIcons.Nodes.Type, element.getPresentation().getIcon(false));

            element = element.getChildren()[3].getChildren()[0].getChildren()[0];
            assertEquals("{{ *recursive children* }}", element.getPresentation().getPresentableText());
            assertEquals(PlatformIcons.VARIABLE_ICON, element.getPresentation().getIcon(false));
        });
    }

    @Test
    public void testPhpEchoNode() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(1, children.length);

            TreeElement element = children[0];
            assertEquals("{{$ \"Hello World\" $}}", element.getPresentation().getPresentableText());
            assertEquals(PhpIcons.PhpIcon, element.getPresentation().getIcon(false));
        });
    }

    @Test
    public void testPhpRawNode() throws Exception {
        doTestTreeStructure(model -> {
            TreeElement[] children = model.getRoot().getChildren();
            assertEquals("aaa.antlers.html", model.getRoot().getPresentation().getPresentableText());
            assertEquals(AntlersIcons.FILE, model.getRoot().getPresentation().getIcon(false));
            assertEquals(1, children.length);

            TreeElement element = children[0];
            assertEquals("{{? phpinfo() ?}}", element.getPresentation().getPresentableText());
            assertEquals(PhpIcons.PhpIcon, element.getPresentation().getIcon(false));
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
