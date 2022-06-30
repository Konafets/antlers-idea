package de.arrobait.antlers.format;

import de.arrobait.antlers.editor.actions.AntlersActionHandlerTest;

public class AntlersFormatOnEnterTest extends AntlersActionHandlerTest implements AntlersFormattingModelBuilderTest {
    public void testSimpleAntlers() {
        doEnterTest(
                "{{ foo }}<caret>",

                "{{ foo }}\n" +
                        "<caret>"
        );
    }

    public void testConditionalBlock() {
        doEnterTest(
                "{{ if foo }}<caret>{{ /if }}",
                "{{ if foo }}\n" +
                        "    <caret>\n" +
                        "{{ /if }}"
        );
        doEnterTest(
                "{{ if foo }}<caret>",
                "{{ if foo }}\n" +
                        "    <caret>"
        );
        doEnterTest(
                "{{ unless foo }}<caret>",
                "{{ unless foo }}\n" +
                        "    <caret>"
        );
    }

    public void testSwitchBlock() {
        doEnterTest(
                "{{ switch(<caret>) }}",
                "{{ switch(\n" +
                        "    <caret>\n" +
                        ") }}"
        );
    }

    public void testSimpleBlock2() {
        doEnterTest(
                "{{ collection }}\n" +
                        "    {{ bar }}<caret>htmlPadding",

                "{{ collection }}\n" +
                        "    {{ bar }}\n" +
                        "    <caret>htmlPadding"
        );
    }

    public void testSimpleBlock3() {
        doEnterTest(
                "{{ collection:blog as=\"entries\" }}\n" +
                        "    There are {{ entries | count }} pogs in this site.<caret>\n" +
                        "{{ /collection:blog }}\n",

                "{{ collection:blog as=\"entries\" }}\n" +
                        "    There are {{ entries | count }} pogs in this site.\n" +
                        "    <caret>\n" +
                        "{{ /collection:blog }}\n"
        );
    }

    public void testSimpleAntlersInDiv1() {
        doEnterTest(
                "<div><caret>\n" +
                        "    {{ foo }}\n" +
                        "</div>",

                "<div>\n" +
                        "    <caret>\n" +
                        "    {{ foo }}\n" +
                        "</div>"
        );
    }

    public void testSimpleAntlersInDiv2() {
        doEnterTest(

                "<div>\n" +
                        "    {{ foo }}<caret>\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ foo }}\n" +
                        "    <caret>\n" +
                        "</div>"
        );
    }

    public void testSimpleAntlersInDiv3() {
        doEnterTest(

                "<div>\n" +
                        "    {{ foo }}<caret>",

                "<div>\n" +
                        "    {{ foo }}\n" +
                        "    <caret>"
        );
    }

    public void testMarkupInBlockAntlers1() {
        doEnterTest(
                "{{ search:results }}\n" +
                        "    <span></span><caret>\n" +
                        "{{ /search:results }}",

                "{{ search:results }}\n" +
                        "    <span></span>\n" +
                        "    <caret>\n" +
                        "{{ /search:results }}"
        );
    }

    public void testMarkupInBlockAntlers2() {
        doEnterTest(
                "{{ search:results }}<caret>\n" +
                        "    <span></span>\n" +
                        "{{ /search:results }}",

                "{{ search:results }}\n" +
                        "    <caret>\n" +
                        "    <span></span>\n" +
                        "{{ /search:results }}"
        );
    }

    public void testMarkupInBlockAntlers3() {
        doEnterTest(
                "{{ search:results }}\n" +
                        "    <span></span><caret>",

                "{{ search:results }}\n" +
                        "    <span></span>\n" +
                        "    <caret>"
        );
    }

    public void testEmptyBlockInDiv1() {
        doEnterTest(
                "<div>\n" +
                        "    {{ collection:blog }}<caret>\n" +
                        "    {{ /collection:blog }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ collection:blog }}\n" +
                        "        <caret>\n" +
                        "    {{ /collection:blog }}\n" +
                        "</div>"
        );
    }

    public void testEmptyBlockInDiv2() {
        doEnterTest(
                "<div>\n" +
                        "    {{ collection:blog }}<caret>{{ /collection:blog }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ collection:blog }}\n" +
                        "        <caret>\n" +
                        "    {{ /collection:blog }}\n" +
                        "</div>"
        );
    }

    public void testEmptyBlockInDiv3() {
        doEnterTest(
                "<div>\n" +
                        "    {{ collection:blog }}<caret>\n" +
                        "htmlPadding",

                "<div>\n" +
                        "    {{ collection:blog }}\n" +
                        "        <caret>\n" +
                        "htmlPadding"
        );
    }

    public void testEmptyBlockInDiv4() {
        doEnterTest(
                "<div>\n" +
                        "{{ collection:blog }}<caret>{{ /collection }}",

                "<div>\n" +
                        "{{ collection:blog }}\n" +
                        "    <caret>\n" +
                        "{{ /collection }}"
        );
    }

    public void testEmptyLinesAfterOpenBlock1() {
      doEnterTest(

        "{{ foo }}\n" +
        "    \n" +
        "    \n" +
        "    \n" +
        "    <caret>\n" +
        "    \n",

        "{{ foo }}\n" +
        "    \n" +
        "    \n" +
        "    \n" +
        "    \n" +
        "    <caret>\n" +
        "    \n"
      );
    }

    public void testEmptyLinesAfterOpenBlock2() {
      doEnterTest(

        "{{ if foo }}\n" +
        "    \n" +
        "    \n" +
        "{{ else }}\n" +
        "    \n" +
        "    \n" +
        "    <caret>\n" +
        "    \n" +
        "    \n",

        "{{ if foo }}\n" +
        "    \n" +
        "    \n" +
        "{{ else }}\n" +
        "    \n" +
        "    \n" +
        "    \n" +
        "    <caret>\n" +
        "    \n" +
        "    \n"
      );
    }
}
