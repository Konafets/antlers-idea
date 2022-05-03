package de.arrobait.antlers.highlighter;

import com.intellij.lang.html.HTMLLanguage;
import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.ex.util.LayerDescriptor;
import com.intellij.openapi.editor.ex.util.LayeredLexerEditorHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import de.arrobait.antlers.psi.AntlersTypes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersTemplateHighlighter extends LayeredLexerEditorHighlighter {
    public AntlersTemplateHighlighter(@Nullable Project project, @Nullable VirtualFile virtualFile, @NotNull EditorColorsScheme colors) {
        // create the main highlighter
        super(new AntlersSyntaxHighlighter(), colors);

        SyntaxHighlighter htmlHighlighter = SyntaxHighlighterFactory.getSyntaxHighlighter(HTMLLanguage.INSTANCE, project, virtualFile);
        LayerDescriptor htmlLayer = new LayerDescriptor(htmlHighlighter, "");
        registerLayer(AntlersTypes.OUTER_CONTENT, htmlLayer);
    }
}
