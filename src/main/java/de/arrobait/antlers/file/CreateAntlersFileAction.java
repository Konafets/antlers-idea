package de.arrobait.antlers.file;

import com.intellij.ide.actions.CreateFileFromTemplateAction;
import com.intellij.ide.actions.CreateFileFromTemplateDialog;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.NonEmptyInputValidator;
import com.intellij.psi.PsiDirectory;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class CreateAntlersFileAction extends CreateFileFromTemplateAction implements DumbAware {
    public CreateAntlersFileAction() {
        super("Antlers File", "Create a new Antlers file", AntlersIcons.FILE);
    }

    @Override
    protected String getDefaultTemplateProperty() {
        return "DefaultAntlersFileTemplate";
    }

    @Override
    protected void buildDialog(@NotNull Project project, @NotNull PsiDirectory directory, CreateFileFromTemplateDialog.@NotNull Builder builder) {
        builder
                .setTitle("New Antlers File")
                .addKind("Antlers", AntlersIcons.FILE, "new.antlers.html")
                .setValidator(new NonEmptyInputValidator());
    }

    @Override
    protected String getActionName(PsiDirectory directory, @NonNls @NotNull String newName, @NonNls String templateName) {
        return "Antlers File";
    }
}
