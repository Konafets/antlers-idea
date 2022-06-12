package de.arrobait.antlers.editor.actions;

public class AntlersTypedHandlerTest extends AntlersActionHandlerTest {
    public void testFirstCharTyped() {
        doCharTest('{', "<caret>", "{<caret>");
    }

    public void testSecondCharTyped() {
        // When typing anything but {, do to auto-complete
        doCharTest('x', "{<caret>", "{x<caret>");

        doCharTest('{', "{<caret>", "{{ <caret> }}");
    }

    public void testParenthesis() {
        doCharTest('(', "{{ <caret> }}", "{{ (<caret>) }}");
    }

    public void testSingleCurlyBraces() {
        doCharTest('{', "{{ foo = <caret> }}", "{{ foo = {<caret>} }}");
    }

    public void testBrackets() {
        doCharTest('[', "{{ foo = sports<caret> }}", "{{ foo = sports[<caret>] }}");
    }
}
