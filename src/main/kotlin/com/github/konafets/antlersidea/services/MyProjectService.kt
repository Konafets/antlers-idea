package com.github.konafets.antlersidea.services

import com.intellij.openapi.project.Project
import com.github.konafets.antlersidea.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
