package de.arrobait.antlers.editor.actions;

import org.junit.Test;

public class AntlersTypedHandlerTest extends AntlersActionHandlerTest {
    @Test
    public void testFirstCharTyped() {
        doCharTest('{', "<caret>", "{<caret>}");
    }

    @Test
    public void testSecondCharTyped() {
        // When typing anything but {, do to auto-complete
        doCharTest('x', "{<caret>}", "{x<caret>}");

        doCharTest('{', "{<caret>}", "{{ <caret> }}");
    }

    @Test
    public void testParenthesis() {
        doCharTest('(', "{{ <caret> }}", "{{ (<caret>) }}");
    }

    @Test
    public void testSingleCurlyBraces() {
        doCharTest('{', "{{ foo = <caret> }}", "{{ foo = {<caret>} }}");
    }

    @Test
    public void testBrackets() {
        doCharTest('[', "{{ foo = sports<caret> }}", "{{ foo = sports[<caret>] }}");
    }
}
