# Antlers Language Support

![Build](https://github.com/Konafets/antlers-idea/workflows/Build/badge.svg)
[![Version][plugin-version-svg]][plugin-repo]
[![Downloads][plugin-downloads-svg]][plugin-repo]

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [x] Get familiar with the [template documentation][template].
- [x] Verify the [pluginGroup](/gradle.properties), [plugin ID](/src/main/resources/META-INF/plugin.xml) and [sources package](/src/main/kotlin).
- [x] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html).
- [x] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [x] Set the Plugin ID in the above README badges.
- [x] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html).
- [x] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
**This plugin is still alpha. New features will be added in future versions.**

This plugin adds support for Antlers, the templating language of [Statamic](https://statamic.com/), to IDEs based on the Intellij IDEA platform (IntelliJ IDEA and PhpStorm).
New features are regularly announced in changelogs.

It supports:

- Syntax highlighting and customizing the colors via settings
- Creating of `.antlers.html` files via the new file action

<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "antlers-idea"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/Konafets/antlers-idea/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Credits

- Mr. Antlers [John Koster](https://github.com/JohnathonKoster) who got not tired to answer my questions
- The awesome [Jetbrains Slack community](https://plugins.jetbrains.com/slack) for helping me with my first steps with plugin development
- [Marco](https://github.com/marcorieser) for being my very first sponsor

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template

<!-- Badges -->
[plugin-repo]: https://plugins.jetbrains.com/plugin/19203-antlers-idea
[plugin-version-svg]: https://img.shields.io/jetbrains/plugin/v/19203-antlers-idea.svg
[plugin-downloads-svg]: https://img.shields.io/jetbrains/plugin/d/19203-antlers-idea.svg
