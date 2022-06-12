package de.arrobait.antlers.editor.braces;

import com.intellij.codeInsight.highlighting.BraceMatchingUtil;
import com.intellij.lang.Language;
import com.intellij.psi.LanguageFileViewProviders;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.file.AntlersFileType;

public class AntlersBraceMatcherTest extends BasePlatformTestCase {
    private static final String ourBraceMatcherIndicator = "<brace_match>";

    @Override
    protected void tearDown() throws Exception {
        try {
            Language language = AntlersLanguage.INSTANCE;
            LanguageFileViewProviders myLanguageFileViewProvider = LanguageFileViewProviders.INSTANCE;

            myLanguageFileViewProvider.removeExplicitExtension(language, myLanguageFileViewProvider.forLanguage(language));
        }
        catch (Exception e) {
          addSuppressedException(e);
        }
        finally {
          super.tearDown();
        }
    }

    /**
     * Expects "fileText" to have two "<brace_match>" tokens, placed in front of two braces which are
     * expected to be matched by the built-in brace matching (i.e. when the caret is at one of the "<brace_match>"
     * tokens, the brace match subsystem highlights the brace at the other "<brace_match>")
     * <p>
     * NOTE: the <brace_match> before the close brace should have a bit of whitespace before it to make this
     * test work correctly. For example, have "{{ /foo <brace_match>}}" rather than "{{/foo<brace_match>}}"
     */
    private void doBraceTest(String fileText) {
        String textForTest = fileText;

        int firstBracePosition = textForTest.indexOf(ourBraceMatcherIndicator);
        textForTest = textForTest.replaceFirst(ourBraceMatcherIndicator, ""); // remove first brace indicator from input

        int secondBracePosition = textForTest.indexOf(ourBraceMatcherIndicator);
        textForTest = textForTest.replaceFirst(ourBraceMatcherIndicator, ""); // remove second brace indicator from input

        assertTrue("Should have two \"" + ourBraceMatcherIndicator + "\" tokens in fileText. Given fileText:\n"
                        + fileText,
                firstBracePosition > -1 && secondBracePosition > -1);

        String firstBraceResult = findMatchBraceForBraceAtCaret(textForTest, firstBracePosition, secondBracePosition);
        assertEquals("Result with caret at first <brace_match>", fileText, firstBraceResult);

        String secondBraceResult = findMatchBraceForBraceAtCaret(textForTest, secondBracePosition, firstBracePosition);
        assertEquals("Result with caret at second <brace_result>", fileText, secondBraceResult);
    }

    /**
     * Method to do the actual invocation of the brace match subsystem on a given file for a given caret position
     *
     * @param fileText The source to test brace matching on
     * @param caretPosition Caret position to compute a matched brace for
     * @param expectedMatchBracePosition The expected position of the brace which matches the brace at caretPosition
     * @return The given file text with the {link #ourBraceMatcherIndicator} tokens place where the brace matching subsystem dictated
     */
    private String findMatchBraceForBraceAtCaret(String fileText, int caretPosition, int expectedMatchBracePosition) {
        String caretIndicator = "<caret>";
        String textWithCaret = new StringBuilder(fileText).insert(caretPosition, caretIndicator).toString();

        myFixture.configureByText(AntlersFileType.INSTANCE, textWithCaret);

        boolean caretFirst = expectedMatchBracePosition > caretPosition;
        int actualBraceMatchPosition = BraceMatchingUtil.getMatchedBraceOffset(myFixture.getEditor(), caretFirst, myFixture.getFile());

        // we want to have an easy to read result, so we insert a <brace_match> where
        // BraceMatchUtil.getMatchedBraceOffset told us it should go.
        String result = new StringBuilder(textWithCaret)
                // not that we need to compensate for the length of the caretIndicator if it comes before ourBraceMatchIndicator
                .insert(actualBraceMatchPosition + (caretFirst ? caretIndicator.length() : 0), ourBraceMatcherIndicator)
                .toString();

        // replace the caret indicator with ourBraceMatcherIndicator so that our result format matches the input format
        result = result.replace(caretIndicator, ourBraceMatcherIndicator);

        return result;
    }

    /**
     * Convenience property for quickly setting up brace matching tests.
     *
     * Things to note about this text:
     * - The brace we want to match have some whitespace around them (this lets them match when the caret is before them)
     * - All ids are unique so that they can be easily targeted by string replace functions
     */
    private static final String ourTestSource =
            "{{ foo1 }}\n" +
            "    {{# comment #}}\n" +
            "    {{ foo2 }}\n" +
            "        <div>\n" +
            "            {{ foo3 }}\n" +
            "                Content\n" +
            "            {{ /foo3 }}\n" +
            "        </div>\n" +
            "        {{ baz }}\n" +
            "        {{ bat }}\n" +
            "    {{ /foo2 }}\n" +
            "{{ /foo1 }}\n" +
            "\n" +
            "{{$ phpecho $}}\n" +
            "{{? phpraw ?}}\n" +
            "{{ (10) }}\n" +
            "{{ sports[2] }}\n" +
            "{{ foo = {bar} merge {baz} }}\n";

    public void testSimpleAntlers() {
        doBraceTest(ourTestSource.replace("{{ foo1 }}", "<brace_match>{{ foo1 <brace_match>}}"));
        doBraceTest(ourTestSource.replace("{{ /foo1 }}", "<brace_match>{{ /foo1 <brace_match>}}"));
    }

    public void testComment() {
        doBraceTest(
                ourTestSource.replace("{{# comment #}}", "<brace_match>{{# comment <brace_match>#}}")
        );
    }

    public void testPhpInAntlers() {
        doBraceTest(
                ourTestSource.replace("{{$ phpecho $}}", "<brace_match>{{$ phpecho <brace_match>$}}")
        );
        doBraceTest(
                ourTestSource.replace("{{? phpraw ?}}", "<brace_match>{{? phpraw <brace_match>?}}")
        );
    }

    public void testParenthesis() {
        doBraceTest(
                ourTestSource.replace("{{ (10) }}", "{{ <brace_match>(10<brace_match>) }}")
        );
    }

    public void testInterpolation() {
        doBraceTest(
                ourTestSource.replace(
                        "{{ foo = {bar} merge {baz} }}",
                        "{{ foo = <brace_match>{bar<brace_match>} merge <brace_match>{baz<brace_match>} }}"
                )
        );
    }

    public void testArrayBrackets() {
        doBraceTest(
                ourTestSource.replace(
                        "{{ sports[2] }}",
                        "{{ sports<brace_match>[2<brace_match>] }}"
                )
        );
    }
}
