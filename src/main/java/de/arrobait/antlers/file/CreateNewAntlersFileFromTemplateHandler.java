package de.arrobait.antlers.file;

import com.intellij.ide.fileTemplates.DefaultCreateFromTemplateHandler;
import com.intellij.ide.fileTemplates.FileTemplate;
import org.jetbrains.annotations.NotNull;

public class CreateNewAntlersFileFromTemplateHandler extends DefaultCreateFromTemplateHandler {
    @Override
    public boolean handlesTemplate(FileTemplate template) {
        return template.getName().equals("new.antlers");
    }

    @Override
    protected String checkAppendExtension(String fileName, @NotNull FileTemplate template) {
        final String suggestedFileNameEnd = "." + AntlersFileType.DEFAULT_EXTENSION;

        if (template.getName().endsWith("antlers")) {
            fileName += suggestedFileNameEnd;
        }
        return fileName;
    }
}
