package de.arrobait.antlers.editor.actions;

import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.TypedAction;
import com.intellij.openapi.editor.ex.EditorEx;
import com.intellij.openapi.project.Project;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import de.arrobait.antlers.file.AntlersFileType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public abstract class AntlersActionHandlerTest extends BasePlatformTestCase {
    private void performWriteAction(final Project project, final Runnable action) {
        ApplicationManager.getApplication().runWriteAction(() -> CommandProcessor.getInstance().executeCommand(project, action, "test command", null));
    }

    private void validateTestStrings(@NotNull String before, @NotNull String expected) {
        if (!before.contains("<caret>") || !expected.contains("<caret>")) {
            throw new IllegalArgumentException("Test strings must contain \"<caret>\" to indicate caret position");
        }
    }

    void doCharTest(final char charToType, @NotNull String before, @NotNull String expected) {
        EditorActionManager.getInstance();
        final TypedAction typedAction = TypedAction.getInstance();
        doExecuteActionTest(before, expected, () -> typedAction.actionPerformed(myFixture.getEditor(), charToType, ((EditorEx) myFixture.getEditor()).getDataContext()));
    }

    protected void doEnterTest(@NotNull String before, @NotNull String expected) {
        final EditorActionHandler enterActionHandler = EditorActionManager.getInstance().getActionHandler(IdeActions.ACTION_EDITOR_ENTER);
        doExecuteActionTest(before, expected,
                () -> enterActionHandler.execute(myFixture.getEditor(), null, ((EditorEx) myFixture.getEditor()).getDataContext()));
    }

    private void doExecuteActionTest(@NotNull String before, @NotNull String expected, @NotNull Runnable action) {
        validateTestStrings(before, expected);

        myFixture.configureByText(AntlersFileType.INSTANCE, before);
        performWriteAction(myFixture.getProject(), action);
        myFixture.checkResult(expected);
    }
}
