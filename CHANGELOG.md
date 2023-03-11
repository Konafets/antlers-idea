<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Antlers Language Support Changelog

## [Unreleased]

### Added
- Add support for LiveTemplates 
- Add default LiveTemplates for `switch`, `if`, `if else` and `if elseif`. 

### Changed
- Optimize the Lexer by removing duplicate actions and use multiple states.
- Update plugin org.jetbrains.intellij to v1.13.2 #115
- Update dependency gradle to v8.0.2

### Fixed
- When creating a new Antles file via _New File_-Dialog do not append `.antlers.html` when the user already provides the extension in the dialog.
- Plugin confuses regular .HTML files #113

## [0.0.5] - 2023-02-24

### Added
- Add formatting and formatting settings
- Add checkout action to `ReleaseDraft` step
- Add lexing and parsing for `{{ slot }}` and `{{ slot:name }}`
- Restrict the `as` operator to the `groupby` advanced operator, so that no error occurs for `{{ as or 'a' }}`.
- Add new modifier
- - `add_query_param`
  - `alias`
  - `antlers`
  - `bard_html`
  - `bard_items`
  - `bard_text`
  - `bools_string`
  - `dd`
  - `ddd`
  - `dump`
  - `diff_for_humans`
  - `diff_for_owls`
  - `extension`
  - `format_translated`
  - `is_alpha`
  - `is_array`
  - `is_iterable`
  - `joinplode`
  - `kebab`
  - `key_by`
  - `localize`
  - `mark`
  - `neatify`
  - `parse_url`
  - `pathinfo`
  - `pluck`
  - `random`
  - `regex_mark`
  - `remove_query_param`
  - `scope`
  - `set_query_param`
  - `shrug`
  - `split`
  - `str_pad`
  - `str_pad_both`
  - `str_pad_left`
  - `str_pad_right`
  - `studly`
  - `timestamp`
  - `to_bool`
  - `to_string`
  - `trackable_embed_url`
  - `type_of`

### Changed
- Upgrade Gradle Wrapper to `8.0`
- Upgrade Gradle IntelliJ Plugin to `1.13.0`
- A comment is now lexed complete as `PsiComment`
- Parse the default case of switch statement as own node
- Update Gradle plugin to `1.12.0`
- Update Kotlin to `1.8.10`
- Update Qodana to `v2022.3.4`
- Removed deprecated `::set-output` in GitHub workflows
- Update dependency `org.junit.vintage:junit-vintage-engine` to v5.9.2
- Moved the version of JUnit and JUnit Vintage Engine to `gradle.properties`

### Fixed
- Pass Plugin Signing secrets as environment variables in the Release workflow
- GitHub Actions - use `$BRANCH` for creating changelog pull request

## [0.0.4] - 2022-12-05

### Added
- Add basic formatting for HTML and CSS.
- Do not mark inline CSS in `<style>`-Tag as an error
- Better detection of Antlers and HTML/CSS/Javascript code.
- Added `nocache` tag

### Changed
- Use JVM toolchain for configuring source/target compilation compatibility
- Change the completion of Antlers delimiters. If you type the opening `{`, the closing `}` will be added automatically. When you type the second opening `{`, the matching `}` will be added and the spaces will be inserted as well. This means, just type `{{` will complete to `{{ <caret> }}`.
- Remove deprecated usage of `THashSet`

### Fixed
- Fixed the detection of strings and improve the handling. Single and double quotes will not marked as an error when they are escaped.
- Fixed detection of `switch` keyword for the control structure. The `switch` keyword for the control structure was only correctly detected when the opening parenthesis was immediately followed. If any whitespace or line break was in between, the term 
 `switch` was tokenized as a TAG.

## [0.0.3] - 2022-08-08

### Added
- New `mount_url` tag
- New `path_info` and `url_info` modifiers
- New `vite` tag
- Support PhpStorm 2022.2
- Make sure GitHub Actions release jobs have write permissions

### Changed
- Upgrade Gradle Wrapper to `7.5`
- Update `platformVersion` to `222.3345.118`
- Change since/until build to `212-222.*` (2021.2 - 2022.2)
- Dependencies - upgrade `org.jetbrains.intellij` to `1.8.0`
- Dependencies - upgrade `org.jetbrains.kotlin.jvm` to `1.7.10`
- Dependencies (GitHub Actions) - upgrade `JetBrains/qodana-action` to `v2022.2.1`

## [0.0.2] - 2022-06-12

### Added
- - `Code | Comment with Line Comment`
  - `Code | Comment with Block Comment`
- Autocomplete and remove closing single and double quote
- Highlight all sort of brackets, parenthesis and braces as well Antlers' node delimiters
- Add autocompletion for Antlers delimiters. Type `{{` and the closing `}}` will be added automatically.
- Support for scopes in the grammar #2
- Autocomplete Antlers core modifiers
- Add support for modifiers in conditionals #3

### Changed
- Add support for older IDE versions down to 2021.2

## [0.0.1] - 2022-05-25

### Added
- - Initial scaffold created from [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)
  - Setup Changelog for Gradle
  - Rename the groupID and namespace
  - A rad plugin icon
  - Antlers file type and icons
  - Action to create new Antlers file in project view
  - JUnit 5 (with support for JUnit 4)
- - Add comments `{{# Comment #}}`
  - Add support for raw PHP tag `{{? $foo ?}}`
  - Add support for echo PHP tag `{{$ $foo $}}`
  - Add plain Antlers node `{{ }}`
  - Add close node `{{ /foo }}` or `{{ /foo:bar }} 
  - Add booleans `{{ true }}` and `{{ false }}`
  - Add single- and double-quoted strings `{{ 'Hello' }}` and `{{ "Hello" }}` 
  - Add integers and float numbers `{{ .42 }}`, `{{ 0.42 }}`, `{{ 42 }}` and `{{ -0.42 }}`, `{{ -42 }}`   
  - Add variables `{{ foo }}` and `{{ $foo }}`
    - - Add support for dynamic variable access via `{{ @foo }}`
  - Add sub-expressions `{{ (foo) }}`
  - Add variable assignment node `{{ $foo = 42 }}`
  - Add interpolated-statements `{{ foo = {10} }}`
    - Add support for tags
  - Add general array support and allow arrays to be assigned to variables
  - Add property access
    - Colon notation `{{ skaters:0:name }}` 
    - Dot notation `{{ skaters.1.name }}` 
    - Bracket notation `{{ skaters[2]['name'] }}` 
    - Add interpolated statements in variable array property access `{{ scope_name[{'alt_{locale}'}] }}` 
  - Add unary NOT boolean expression `!true` -> `false`
  - Add string concatenation and concatenation via self-assignment 
  - Add math expressions
    - Addition
    - Substraction
    - Multiply
    - Divide
    - Modulo
    - Power `10 ** 2`
    - Factorial `5!`
  - Add comparison expressions
    - Tenary expression
    - Equals `==`
    - Not equals `!=`
    - Identical `===` 
    - Not identical `!==`
    - Lower than `<`
    - Lower than equals `<=`
    - Greater than `>`
    - Greater than equals `>=`
    - Spaceship `<=>`
    - Null Coalescence `??`
    - Gatekeeper `?=`
  Add boolean expressions
    - And `&&` / `and`
    - Or `||` / `or`
    - Xor `xor`
- - if / elseif / else
  - unless
- Add switch structure
- - Supports new style for parameters `{{ foo | modifier(24) }}`
  - Supports legacy style for parameters `{{ foo | modifier:24 }}` and `{{ foo | modifier="24" }}`
- Add `noparse` region
- Add `@` ignore sign
- Add Tags
- - Collection
  - Taxonomy
  - Users
- Add Recursive Children node
- - groupby
  - merge
  - orderby
  - pluck
  - skip
  - take
  - where
- Add language support for HTML

[Unreleased]: https://github.com/Konafets/antlers-idea/compare/v0.0.5...HEAD
[0.0.5]: https://github.com/Konafets/antlers-idea/compare/v0.0.4...v0.0.5
[0.0.4]: https://github.com/Konafets/antlers-idea/compare/v0.0.3...v0.0.4
[0.0.3]: https://github.com/Konafets/antlers-idea/compare/v0.0.2...v0.0.3
[0.0.2]: https://github.com/Konafets/antlers-idea/compare/v0.0.1...v0.0.2
[0.0.1]: https://github.com/Konafets/antlers-idea/commits/v0.0.1
