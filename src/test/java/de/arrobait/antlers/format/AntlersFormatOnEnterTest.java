package de.arrobait.antlers.format;

import de.arrobait.antlers.editor.actions.AntlersActionHandlerTest;

public class AntlersFormatOnEnterTest extends AntlersActionHandlerTest implements AntlersFormattingModelBuilderTest {
    /**
     * Before:
     * <pre>
     * {{ foo }}<caret>
     * </pre>
     * After:
     * <pre>
     * {{ foo }}
     *     <caret>
     * </pre>
     */
    public void testSimpleAntlers() {
        doEnterTest(
                "{{ foo }}<caret>",
                "{{ foo }}\n" +
                        "<caret>"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}<caret>
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <caret>
     * </pre>
     */
    public void testSimpleBlock1() {
        doEnterTest(
                "{{ if true }}<caret>",
                "{{ if true }}\n" +
                        "    <caret>"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     {{ bar }}<caret>htmlPadding
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     {{ bar }}
     *     <caret>htmlPadding
     * </pre>
     */
    public void testSimpleBlock2() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    {{ bar }}<caret>htmlPadding",

                "{{ if true }}\n" +
                        "    {{ bar }}\n" +
                        "    <caret>htmlPadding"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     {{ bar }}<caret>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     {{ bar }}
     *     <caret>
     * {{ /if }}
     * </pre>
     */
    public void testSimpleBlock3() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    {{ bar }}<caret>\n" +
                        "{{ /if }}\n",

                "{{ if true }}\n" +
                        "    {{ bar }}\n" +
                        "    <caret>\n" +
                        "{{ /if }}\n"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     * {{ if true }}
     * {{ if true }}<caret>
     * {{ bar }}
     * {{ /if }}
     * {{ /if }}
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     * {{ if true }}
     * {{ if true }}
     *     <caret>
     * {{ bar }}
     * {{ /if }}
     * {{ /if }}
     * {{ /if }}
     * </pre>
     */
    public void testNestedBlocks1() {
        doEnterTest(
                "{{ if true }}\n" +
                        "{{ if true }}\n" +
                        "{{ if true }}<caret>\n" +
                        "{{ baz }}\n" +
                        "{{ /if }}\n" +
                        "{{ /if }}\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "{{ if true }}\n" +
                        "{{ if true }}\n" +
                        "    <caret>\n" +
                        "{{ baz }}\n" +
                        "{{ /if }}\n" +
                        "{{ /if }}\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     {{ if true }}
     *         {{ if true }}<caret>
     *             {{ bar }}
     *         {{ /if }}
     *     {{ /if }}
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     {{ if true }}
     *         {{ if true }}
     *             <caret>
     *             {{ bar }}
     *         {{ /if }}
     *     {{ /if }}
     * {{ /if }}
     * </pre>
     */
    public void testNestedBlocks2() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    {{ if true }}\n" +
                        "        {{ if true }}<caret>\n" +
                        "            {{ bar }}\n" +
                        "        {{ /if }}\n" +
                        "    {{ /if }}\n" +
                        "{{ /if }}\n",
                "{{ if true }}\n" +
                        "    {{ if true }}\n" +
                        "        {{ if true }}\n" +
                        "            <caret>\n" +
                        "            {{ bar }}\n" +
                        "        {{ /if }}\n" +
                        "    {{ /if }}\n" +
                        "{{ /if }}\n"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     {{ if true }}
     *         {{ if true }}
     *             {{ bar }}<caret>
     *         {{ /if }}
     *     {{ /if }}
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     {{ if true }}
     *         {{ if true }}
     *             {{ bar }}
     *             <caret>
     *         {{ /if }}
     *     {{ /if }}
     * {{ /if }}
     * </pre>
     */
    public void testNestedBlocks3() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    {{ if true }}\n" +
                        "        {{ if true }}\n" +
                        "            {{ bar }}<caret>\n" +
                        "        {{ /if }}\n" +
                        "    {{ /if }}\n" +
                        "{{ /if }}\n",
                "{{ if true }}\n" +
                        "    {{ if true }}\n" +
                        "        {{ if true }}\n" +
                        "            {{ bar }}\n" +
                        "            <caret>\n" +
                        "        {{ /if }}\n" +
                        "    {{ /if }}\n" +
                        "{{ /if }}\n"
        );
    }

    /**
     * Before:
     * <pre>
     * <div><caret>
     *     {{ foo }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     <caret>
     *     {{ foo }}
     * </div>
     * </pre
     */
    public void testSimpleNodeInDiv1() {
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

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ foo }}<caret>
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ foo }}
     *     <caret>
     * </div>
     * </pre
     */
    public void testSimpleNodeInDiv2() {
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

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ foo }}<caret>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ foo }}
     *     <caret>
     * </pre
     */
    public void testSimpleNodeInDiv3() {
        doEnterTest(
                "<div>\n" +
                        "    {{ foo }}<caret>",

                "<div>\n" +
                        "    {{ foo }}\n" +
                        "    <caret>"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     <span></span><caret>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <span></span>
     *     <caret>
     * {{ /if }}
     * </pre
     */
    public void testMarkupInBlockNodes1() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    <span></span><caret>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <span></span>\n" +
                        "    <caret>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}<caret>
     *     <span></span>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <caret>
     *     <span></span>
     * {{ /if }}
     * </pre
     */
    public void testMarkupInBlockNodes2() {
        doEnterTest(
                "{{ if true }}<caret>\n" +
                        "    <span></span>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <caret>\n" +
                        "    <span></span>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     <span></span><caret>
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <span></span>
     *     <caret>
     * </pre
     */
    public void testMarkupInBlockNodes3() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    <span></span><caret>",

                "{{ if true }}\n" +
                        "    <span></span>\n" +
                        "    <caret>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}<caret>
     *     {{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <caret>
     *     {{ /if }}
     * </div>
     * </pre
     */
    public void testEmptyBlockInDiv1() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}<caret>\n" +
                        "    {{ /if }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <caret>\n" +
                        "    {{ /if }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}<caret>{{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <caret>
     *     {{ /if }}
     * </div>
     * </pre
     */
    public void testEmptyBlockInDiv2() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}<caret>{{ /if }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <caret>\n" +
                        "    {{ /if }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}<caret>
     * htmlPadding
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <caret>
     * htmlPadding
     * </pre
     */
    public void testEmptyBlockInDiv3() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}<caret>\n" +
                        "htmlPadding",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <caret>\n" +
                        "htmlPadding"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     * {{ if true }}<caret>{{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     * {{ if true }}
     *     <caret>
     * {{ /if }}
     * </div>
     * </pre
     */
    public void testEmptyBlockInDiv4() {
        doEnterTest(
                "<div>\n" +
                        "{{ if true }}<caret>{{ /if }}",

                "<div>\n" +
                        "{{ if true }}\n" +
                        "    <caret>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     * {{ if true }}
     * {{ bar }}<caret>
     * {{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     * {{ if true }}
     * {{ bar }}
     *     <caret>
     * {{ /if }}
     * </div>
     * </pre
     */
    public void testSimpleBlockInDiv1() {
        doEnterTest(
                "<div>\n" +
                        "{{ if true }}\n" +
                        "{{ bar }}<caret>\n" +
                        "{{ /if }}\n" +
                        "</div>",

                "<div>\n" +
                        "{{ if true }}\n" +
                        "{{ bar }}\n" +
                        "    <caret>\n" +
                        "{{ /if }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}
     *         {{ bar }}<caret>
     *     {{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         {{ bar }}
     *         <caret>
     *     {{ /if }}
     * </div>
     * </pre
     */
    public void testSimpleBlockInDiv2() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        {{ bar }}<caret>\n" +
                        "    {{ /if }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        {{ bar }}\n" +
                        "        <caret>\n" +
                        "    {{ /if }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}
     *         {{ bar }}
     *     {{ /if }}<caret>
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         {{ bar }}
     *     {{ /if }}
     *     <caret>
     * </div>
     * </pre
     */
    public void testSimpleBlockInDiv3() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        {{ bar }}\n" +
                        "    {{ /if }}<caret>\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        {{ bar }}\n" +
                        "    {{ /if }}\n" +
                        "    <caret>\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     * {{ if true }}
     * {{ bar }}<caret>
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     * {{ if true }}
     * {{ bar }}
     *     <caret>
     * </div>
     * </pre
     */
    public void testSimpleBlockInDiv4() {
        doEnterTest(
                "<div>\n" +
                        "{{ if true }}\n" +
                        "{{ bar }}<caret>",

                "<div>\n" +
                        "{{ if true }}\n" +
                        "{{ bar }}\n" +
                        "    <caret>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}
     *         {{ bar }}<caret>
     * htmlPadding
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         {{ bar }}
     *         <caret>
     * htmlPadding
     * </pre
     */
    public void testSimpleBlockInDiv5() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        {{ bar }}<caret>\n" +
                        "htmlPadding",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        {{ bar }}\n" +
                        "        <caret>\n" +
                        "htmlPadding"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}
     *         {{ bar }}
     *     {{ /if }}<caret>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         {{ bar }}
     *     {{ /if }}
     *     <caret>
     * </pre
     */
    public void testSimpleBlockInDiv6() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        {{ bar }}\n" +
                        "    {{ /if }}<caret>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        {{ bar }}\n" +
                        "    {{ /if }}\n" +
                        "    <caret>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}<caret>
     *         {{ bar }}
     *     {{ /if }}
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *     <caret>
     *         {{ bar }}
     *     {{ /if }}
     * </pre
     */
    public void testSimpleBlockInDiv7() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}<caret>\n" +
                        "        {{ bar }}\n" +
                        "    {{ /if }}",
                "<div>\n" +
                        "    {{ if true }}\n" +
                        "    <caret>\n" + // NOTE: this is not ideal, but it's tough to get the formatting right when there's unclosed html elements
                        "        {{ bar }}\n" +
                        "    {{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}<caret>
     *         {{ bar }}
     *     {{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <caret>
     *         {{ bar }}
     *     {{ /if }}
     * </div>
     * </pre
     */
    public void testSimpleBlockInDiv8() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}<caret>\n" +
                        "        {{ bar }}\n" +
                        "    {{ /if }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <caret>\n" +
                        "        {{ bar }}\n" +
                        "    {{ /if }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div {{ foo }}><caret>
     *     <div class="{{ bar }}">
     *         sweet
     *     </div>
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div {{ foo }}>
     *     <caret>
     *     <div class="{{ bar }}">
     *         sweet
     *     </div>
     * </div>
     * </pre
     */
    public void testAttributeNodes1() {
        doEnterTest(
                "<div {{ foo }}><caret>\n" +
                        "    <div class=\"{{ bar }}\">\n" +
                        "        sweeet\n" +
                        "    </div>\n" +
                        "</div>",

                "<div {{ foo }}>\n" +
                        "    <caret>\n" +
                        "    <div class=\"{{ bar }}\">\n" +
                        "        sweeet\n" +
                        "    </div>\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div {{ foo }}>
     *     <div class="{{ bar }}"><caret>
     *         sweet
     *     </div>
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div {{ foo }}>
     *     <div class="{{ bar }}">
     *         <caret>
     *         sweet
     *     </div>
     * </div>
     * </pre
     */
    public void testAttributeNodes2() {
        doEnterTest(
                "<div {{ foo }}>\n" +
                        "    <div class=\"{{ bar }}\"><caret>\n" +
                        "        sweeet\n" +
                        "    </div>\n" +
                        "</div>",

                "<div {{ foo }}>\n" +
                        "    <div class=\"{{ bar }}\">\n" +
                        "        <caret>\n" +
                        "        sweeet\n" +
                        "    </div>\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div {{ foo }}>
     *     <div class="{{ bar }}">
     *         sweet<caret>
     *     </div>
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div {{ foo }}>
     *     <div class="{{ bar }}">
     *         sweet
     *         <caret>
     *     </div>
     * </div>
     * </pre
     */
    public void testAttributeNodes3() {
        doEnterTest(
                "<div {{ foo }}>\n" +
                        "    <div class=\"{{ bar }}\">\n" +
                        "        sweeet<caret>\n" +
                        "    </div>\n" +
                        "</div>",

                "<div {{ foo }}>\n" +
                        "    <div class=\"{{ bar }}\">\n" +
                        "        sweeet\n" +
                        "        <caret>\n" +
                        "    </div>\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div {{ foo }}><caret>
     * </pre>
     * After:
     * <pre>
     * <div {{ foo }}>
     * </pre
     */
    public void testAttributeNodes4() {
        doEnterTest(
                "<div {{ foo }}><caret>",

                "<div {{ foo }}>\n" +
                        "    <caret>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div {{ foo }}>
     *     <div class="{{ bar }}"><caret>
     * </pre>
     * After:
     * <pre>
     * <div {{ foo }}>
     *     <div class="{{ bar }}">
     *         <caret>
     * </pre
     */
    public void testAttributeNodes5() {
        doEnterTest(
                "<div {{ foo }}>\n" +
                        "    <div class=\"{{ bar }}\"><caret>",

                "<div {{ foo }}>\n" +
                        "    <div class=\"{{ bar }}\">\n" +
                        "        <caret>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div {{ foo }}>
     *     <div class="{{ bar }}">
     *         sweet<caret>
     * </pre>
     * After:
     * <pre>
     * <div {{ foo }}>
     *     <div class="{{ bar }}">
     *         sweet
     *         <caret>
     * </pre
     */
    public void testAttributeNodes6() {
        doEnterTest(
                "<div {{ foo }}>\n" +
                        "    <div class=\"{{ bar }}\">\n" +
                        "        sweeet<caret>",

                "<div {{ foo }}>\n" +
                        "    <div class=\"{{ bar }}\">\n" +
                        "        sweeet\n" +
                        "        <caret>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span><caret>
     *     {{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span>
     *         <caret>
     *     {{ /if }}
     * </div>
     * </pre
     */
    public void testMixedContentInDiv1() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span><caret>\n" +
                        "    {{ /if }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>\n" +
                        "        <caret>\n" +
                        "    {{ /if }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}<caret>
     *         <span class="{{ bat }}">{{ bar }}</span>
     *     {{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <caret>
     *         <span class="{{ bat }}">{{ bar }}</span>
     *     {{ /if }}
     * </div>
     * </pre
     */
    public void testMixedContentInDiv2() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}<caret>\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>\n" +
                        "    {{ /if }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <caret>\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>\n" +
                        "    {{ /if }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span><caret>
     *     {{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span>
     *         <caret>
     *     {{ /if }}
     * </div>
     * </pre
     */
    public void testMixedContentInDiv3() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span><caret>\n" +
                        "    {{ /if }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>\n" +
                        "        <caret>\n" +
                        "    {{ /if }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span>
     *     {{ /if }}<caret>
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span>
     *     {{ /if }}
     *     <caret>
     * </div>
     * </pre
     */
    public void testMixedContentInDiv4() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>\n" +
                        "    {{ /if }}<caret>\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>\n" +
                        "    {{ /if }}\n" +
                        "    <caret>\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div><caret>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     <caret>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span>
     * </pre
     */
    public void testMixedContentInDiv5() {
        doEnterTest(
                "<div><caret>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>",

                "<div>\n" +
                        "    <caret>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}<caret>
     *         <span class="{{ bat }}">{{ bar }}</span>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <caret>
     *         <span class="{{ bat }}">{{ bar }}</span>
     * </pre
     */
    public void testMixedContentInDiv6() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}<caret>\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <caret>\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span><caret>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span>
     *         <caret>
     * </pre
     */
    public void testMixedContentInDiv7() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span><caret>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>\n" +
                        "        <caret>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span>
     *     {{ /if }}<caret>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         <span class="{{ bat }}">{{ bar }}</span>
     *     {{ /if }}
     *     <caret>
     * </pre
     */
    public void testMixedContentInDiv8() {
        doEnterTest(
                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>\n" +
                        "    {{ /if }}<caret>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>\n" +
                        "    {{ /if }}\n" +
                        "    <caret>"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *
     *
     *
     *     <caret>
     *
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *
     *
     *
     *
     *     <caret>
     *
     * </pre>
     */
    public void testEmptyLinesAfterOpenBlock1() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    \n" +
                        "    \n" +
                        "    \n" +
                        "    <caret>\n" +
                        "    \n",

                "{{ if true }}\n" +
                        "    \n" +
                        "    \n" +
                        "    \n" +
                        "    \n" +
                        "    <caret>\n" +
                        "    \n"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *
     *
     * {{ else }}
     *
     *
     *     <caret>
     *
     *
     * </pre>
     * <p>
     * After:
     * <pre>
     * {{ if true }}
     *
     *
     * {{ else }}
     *
     *
     *
     *     <caret>
     *
     *
     * </pre>
     */
    public void testEmptyLinesAfterOpenBlock2() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    \n" +
                        "    \n" +
                        "{{ else }}\n" +
                        "    \n" +
                        "    \n" +
                        "    <caret>\n" +
                        "    \n" +
                        "    \n",

                "{{ if true }}\n" +
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

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     <div><caret>
     *         {{ bar }}
     *     </div>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <div>
     *         <caret>
     *         {{ bar }}
     *     </div>
     * {{ /if }}
     * </pre>
     */
    public void testSimpleNodeInNestedDiv1() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    <div><caret>\n" +
                        "        {{ bar }}\n" +
                        "    </div>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        <caret>\n" +
                        "        {{ bar }}\n" +
                        "    </div>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     <div>
     *         {{ bar }}<caret>
     *     </div>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <div>
     *         {{ bar }}
     *         <caret>
     *     </div>
     * {{ /if }}
     * </pre>
     */
    public void testSimpleNodeInNestedDiv2() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        {{ bar }}<caret>\n" +
                        "    </div>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        {{ bar }}\n" +
                        "        <caret>\n" +
                        "    </div>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     <div><caret>
     *         {{ if true }}
     *             stuff
     *         {{ /if }}
     *     </div>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <div>
     *         <caret>
     *         {{ if true }}
     *             stuff
     *         {{ /if }}
     *     </div>
     * {{ /if }}
     * </pre>
     */
    public void testBlockNodeInNestedDiv1() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    <div><caret>\n" +
                        "        {{ if true }}\n" +
                        "            stuff\n" +
                        "        {{ /if }}\n" +
                        "    </div>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        <caret>\n" +
                        "        {{ if true }}\n" +
                        "            stuff\n" +
                        "        {{ /if }}\n" +
                        "    </div>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     <div>
     *         {{ if true }}<caret>
     *             stuff
     *         {{ /if }}
     *     </div>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <div>
     *         {{ if true }}
     *             <caret>
     *             stuff
     *         {{ /if }}
     *     </div>
     * {{ /if }}
     * </pre>
     */
    public void testBlockNodeInNestedDiv2() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        {{ if true }}<caret>\n" +
                        "            stuff\n" +
                        "        {{ /if }}\n" +
                        "    </div>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        {{ if true }}\n" +
                        "            <caret>\n" +
                        "            stuff\n" +
                        "        {{ /if }}\n" +
                        "    </div>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     <div>
     *         {{ if true }}
     *             stuff<caret>
     *         {{ /if }}
     *     </div>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <div>
     *         {{ if true }}
     *             stuff
     *             <caret>
     *         {{ /if }}
     *     </div>
     * {{ /if }}
     * </pre>
     */
    public void testBlockNodeInNestedDiv3() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        {{ if true }}\n" +
                        "            stuff<caret>\n" +
                        "        {{ /if }}\n" +
                        "    </div>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        {{ if true }}\n" +
                        "            stuff\n" +
                        "            <caret>\n" +
                        "        {{ /if }}\n" +
                        "    </div>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     <div>
     *         {{ if true }}
     *             stuff
     *         {{ /if }}<caret>
     *     </div>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <div>
     *         {{ if true }}
     *             stuff
     *         {{ /if }}
     *         <caret>
     *     </div>
     * {{ /if }}
     * </pre>
     */
    public void testBlockNodeInNestedDiv4() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        {{ if true }}\n" +
                        "            stuff\n" +
                        "        {{ /if }}<caret>\n" +
                        "    </div>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        {{ if true }}\n" +
                        "            stuff\n" +
                        "        {{ /if }}\n" +
                        "        <caret>\n" +
                        "    </div>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if }}<caret>{{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <caret>
     * {{ /if }}
     * </pre>
     */
    public void testSimpleAntlersBetweenEmptyNodes() {
        doEnterTest(
                "{{ if }}<caret>{{ /if }}",
                "{{ if }}\n" +
                        "    <caret>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if }}
     *     {{ bar }}<caret>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if }}
     *     {{ bar }}
     *     <caret>
     * {{ /if }}
     * </pre>
     */
    public void testSimpleAntlersBetweenNodesWithAntlerNode() {
        doEnterTest(
                "{{ if }}\n" +
                        "    {{ bar }}<caret>\n" +
                        "{{ /if }}",
                "{{ if }}\n" +
                        "    {{ bar }}\n" +
                        "    <caret>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if }}
     *     bar<caret>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if }}
     *     bar
     *     <caret>
     * {{ /if }}
     * </pre>
     */
    public void testSimpleAntlersBetweenNodesWithString() {
        doEnterTest(
                "{{ if }}\n" +
                        "    bar<caret>\n" +
                        "{{ /if }}",
                "{{ if }}\n" +
                        "    bar\n" +
                        "    <caret>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     bar<caret>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     bar
     *     <caret>
     * {{ /if }}
     * </pre>
     */
    public void testSimpleAntlersBetweenNodesWithStringAndAntlersNode() {
        doEnterTest(
                "{{ if true }}\n" +
                        "    {{ foo }}\n" +
                        "    bar<caret>\n" +
                        "{{ /if }}",
                "{{ if true }}\n" +
                        "    {{ foo }}\n" +
                        "    bar\n" +
                        "    <caret>\n" +
                        "{{ /if }}"
        );
        doEnterTest(
                "{{ if true }}\n" +
                        "    {{ foo }}\n" +
                        "    {{ foo }}\n" +
                        "    bar<caret>\n" +
                        "{{ /if }}",
                "{{ if true }}\n" +
                        "    {{ foo }}\n" +
                        "    {{ foo }}\n" +
                        "    bar\n" +
                        "    <caret>\n" +
                        "{{ /if }}"
        );
        doEnterTest(
                "{{ if true }}\n" +
                        "    bar\n" +
                        "    {{ foo }}\n" +
                        "    {{ foo }}<caret>\n" +
                        "{{ /if }}",
                "{{ if true }}\n" +
                        "    bar\n" +
                        "    {{ foo }}\n" +
                        "    {{ foo }}\n" +
                        "    <caret>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * <body>
     * {{ partial:foo }}<caret>
     * {{ collection:blog }}
     * {{ /collection:blog }}
     * {{ partial:foo }}
     * </body>
     * </pre>
     * After:
     * <pre>
     * <body>
     * {{ partial:foo }}
     * <caret>
     * {{ collection:blog }}
     * {{ /collection:blog }}
     * {{ partial:foo }}
     * <div></div>
     * </body>
     * </pre>
     */
    public void _testFormattingInsideBody1() {
        doEnterTest(
                "<body>\n" +
                        "{{ partial:foo }}<caret>\n" +
                        "{{ collection:blog }}\n" +
                        "{{ /collection:blog }}\n" +
                        "{{ partial:foo }}\n" +
                        "</body>",

                "<body>\n" +
                        "{{ partial:foo }}\n" +
                        "<caret>\n" +
                        "{{ collection:blog }}\n" +
                        "{{ /collection:blog }}\n" +
                        "{{ partial:foo }}\n" +
                        "</body>"
        );
    }

    /**
     * Before:
     * <pre>
     * <body>
     * {{ partial:foo }}
     * {{ collection:blog }}<caret>
     * {{ /collection:blog }}
     * {{ partial:foo }}
     * </body>
     * </pre>
     * After:
     * <pre>
     * <body>
     * {{ partial:foo }}
     * {{ collection:blog }}
     *     <caret>
     * {{ /collection:blog }}
     * {{ partial:foo }}
     * <div></div>
     * </body>
     * </pre>
     */
    public void testFormattingInsideBody2() {
        doEnterTest(
                "<body>\n" +
                        "{{ partial:foo }}\n" +
                        "{{ collection:blog }}<caret>\n" +
                        "{{ /collection:blog }}\n" +
                        "{{ partial:foo }}\n" +
                        "</body>",

                "<body>\n" +
                        "{{ partial:foo }}\n" +
                        "{{ collection:blog }}\n" +
                        "    <caret>\n" +
                        "{{ /collection:blog }}\n" +
                        "{{ partial:foo }}\n" +
                        "</body>"
        );
    }

    /**
     * Before:
     * <pre>
     * <body>
     * {{ partial:foo }}
     * {{ collection:blog }}
     * {{ /collection:blog }}
     * <caret>
     * {{ partial:foo }}
     * </body>
     * </pre>
     * After:
     * <pre>
     * <body>
     * {{ partial:foo }}
     * {{ collection:blog }}
     * {{ /collection:blog }}
     * <caret>
     * {{ partial:foo }}
     * <div></div>
     * </body>
     * </pre>
     */
    public void testFormattingInsideBody3() {
        doEnterTest(
                "<body>\n" +
                        "{{ partial:foo }}\n" +
                        "{{ collection:blog }}\n" +
                        "{{ /collection:blog }}<caret>\n" +
                        "{{ partial:foo }}\n" +
                        "</body>",

                "<body>\n" +
                        "{{ partial:foo }}\n" +
                        "{{ collection:blog }}\n" +
                        "{{ /collection:blog }}\n" +
                        "<caret>\n" +
                        "{{ partial:foo }}\n" +
                        "</body>"
        );
    }

    /**
     * Before:
     * <pre>
     * <body>
     * {{ partial:foo }}
     * {{ collection:blog }}
     * {{ /collection:blog }}
     * {{ partial:foo }}<caret>
     * </body>
     * </pre>
     * After:
     * <pre>
     * <body>
     * {{ partial:foo }}
     * {{ collection:blog }}
     * {{ /collection:blog }}
     * {{ partial:foo }}
     * <caret>
     * <div></div>
     * </body>
     * </pre>
     */
    public void testFormattingInsideBody4() {
        doEnterTest(
                "<body>\n" +
                        "{{ partial:foo }}\n" +
                        "{{ collection:blog }}\n" +
                        "{{ /collection:blog }}\n" +
                        "{{ partial:foo }}<caret>\n" +
                        "</body>",

                "<body>\n" +
                        "{{ partial:foo }}\n" +
                        "{{ collection:blog }}\n" +
                        "{{ /collection:blog }}\n" +
                        "{{ partial:foo }}\n" +
                        "<caret>\n" +
                        "</body>"
        );
    }

    public void testIssue74_1() {
        doEnterTest("<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\"><caret></ul>",

                "<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    <caret>\n" +
                        "</ul>"
        );
    }

    public void testIssue74_2() {
        doEnterTest("<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}<caret>{{ /nav:collection:pages }}\n" +
                        "</ul>",

                "<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <caret>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "</ul>"
                );
    }

    public void testIssue74_3() {
        doEnterTest("<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}<caret>\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\">\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a>\n" +
                        "        </li>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "</ul>",

                "<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <caret>\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\">\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a>\n" +
                        "        </li>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "</ul>"
                );
    }

    public void testIssue74_4() {
        doEnterTest("<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\"><caret>\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a>\n" +
                        "        </li>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "</ul>",

                "<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\">\n" +
                        "            <caret>\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a>\n" +
                        "        </li>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "</ul>"
                );
    }

    public void testIssue74_5() {
        doEnterTest("<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\">\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a><caret>\n" +
                        "        </li>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "</ul>",

                "<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\">\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a>\n" +
                        "            <caret>\n" +
                        "        </li>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "</ul>"
                );
    }

    public void testIssue74_6() {
        doEnterTest("<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\">\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a>\n" +
                        "        </li><caret>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "</ul>",

                "<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\">\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a>\n" +
                        "        </li>\n" +
                        "        <caret>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "</ul>"
                );
    }

    public void testIssue74_7() {
        doEnterTest("<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\">\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a>\n" +
                        "        </li>\n" +
                        "    {{ /nav:collection:pages }}<caret>\n" +
                        "</ul>",

                "<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\">\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a>\n" +
                        "        </li>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "    <caret>\n" +
                        "</ul>"
                );
    }

    public void testIssue74_8() {
        doEnterTest("<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\">\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a>\n" +
                        "        </li>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "</ul><caret>",

                "<ul class=\"uppercase text-md font-bold flex flex-col sm:flex-row justify-center items-center text-center\">\n" +
                        "    {{ nav:collection:pages }}\n" +
                        "        <li class=\"inline-block px-4 xl:px-8 pt-2 pb-3\">\n" +
                        "            <a href=\"{{ url }}\" class=\"hover:text-amblue\" {{ is_current != 'text-amblue' }}>{{ title }}</a>\n" +
                        "        </li>\n" +
                        "    {{ /nav:collection:pages }}\n" +
                        "</ul>\n" +
                        "<caret>"
        );
    }
}
