<!-- Keep a Changelog guide -> https://keepachangelog.com -->

# Antlers Language Support Changelog

## [Unreleased]
### Added
- New `mount_url` tag

### Changed

### Deprecated

### Removed

### Fixed

### Security

## [0.0.2] - 2022-06-12
### Added
- Support commenting code 
  - `Code | Comment with Line Comment`
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
- Infrastructure
  - Initial scaffold created from [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)
  - Setup Changelog for Gradle
  - Rename the groupID and namespace
  - A rad plugin icon
  - Antlers file type and icons
  - Action to create new Antlers file in project view
  - JUnit 5 (with support for JUnit 4)
- Antlers related
  - Add comments `{{# Comment #}}`
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
- Add control structures
  - if / elseif / else
  - unless
- Add switch structure
- Add modifiers
  - Supports new style for parameters `{{ foo | modifier(24) }}`
  - Supports legacy style for parameters `{{ foo | modifier:24 }}` and `{{ foo | modifier="24" }}`
- Add `noparse` region
- Add `@` ignore sign
- Add Tags
- Add Tag Conditions
  - Collection
  - Taxonomy
  - Users
- Add Recursive Children node
- Add Advanced Operators
  - groupby
  - merge
  - orderby
  - pluck
  - skip
  - take
  - where
- Add language support for HTML
