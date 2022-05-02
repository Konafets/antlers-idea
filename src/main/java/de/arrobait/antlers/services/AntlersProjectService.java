package de.arrobait.antlers.services;

import com.intellij.openapi.project.Project;
import de.arrobait.antlers.AntlersBundle;

public final class AntlersProjectService {
    public AntlersProjectService(Project project) {
        System.out.println(AntlersBundle.message("projectService", project.getName()));
    }
}
