package de.arrobait.antlers.frontmatter

import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.psi.PsiElement
import de.arrobait.antlers.psi.impl.AntlersYamlFrontmatterImpl
import org.jetbrains.yaml.YAMLLanguage

class YamlToAntlersInjector: MultiHostInjector {
    companion object {
        private val toInject = listOf(AntlersYamlFrontmatterImpl::class.java)
    }

    override fun elementsToInjectIn(): List<Class<out PsiElement>?> = toInject

    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        if (context !is AntlersYamlFrontmatterImpl || !context.isValidHost ) {
            return
        }

        val language: YAMLLanguage = YAMLLanguage.INSTANCE
        registrar.startInjecting(language)
        injectAsOnePlace(context, registrar)
        registrar.doneInjecting()
    }

    private fun injectAsOnePlace(context: AntlersYamlFrontmatterImpl, registrar: MultiHostRegistrar) {
//        val elements = AntlersYamlFrontmatterUtils.getContent(context, withWhitespaces = true) ?: return
//
//        val first = elements.first()
//        val last = elements.last()

        registrar.addPlace(null, null, context, context.textRange)
    }
}
