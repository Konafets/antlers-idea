package de.arrobait.antlers.format;

import com.intellij.application.options.CodeStyle;
import com.intellij.ide.highlighter.HtmlFileType;
import com.intellij.psi.formatter.xml.HtmlCodeStyleSettings;
import de.arrobait.antlers.file.AntlersFileType;
import org.jetbrains.annotations.NotNull;

public class AntlersFormatterIndentTest extends AntlersFormatterTestCase {

    /**
     * Sanity check that we respect non-default (i.e. 4) indent sizes
     */
    public void testNonDefaultIndentSize() {
        int previousHtmlIndent = CodeStyle.getSettings(getProject()).getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE;
        CodeStyle.getSettings(getProject()).getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE = 2;

        int previousAntlersIndent = CodeStyle.getSettings(getProject()).getIndentOptions(AntlersFileType.INSTANCE).INDENT_SIZE;
        CodeStyle.getSettings(getProject()).getIndentOptions(AntlersFileType.INSTANCE).INDENT_SIZE = 2;

        doStringBasedTest(
                "{{ if true }}\n" +
                        "    <div>\n" +
                        "{{ bar }}\n" +
                        "    </div>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "  <div>\n" +
                        "    {{ bar }}\n" +
                        "  </div>\n" +
                        "{{ /if }}"
        );

        CodeStyle.getSettings(getProject()).getIndentOptions(HtmlFileType.INSTANCE).INDENT_SIZE = previousHtmlIndent;
        CodeStyle.getSettings(getProject()).getIndentOptions(AntlersFileType.INSTANCE).INDENT_SIZE = previousAntlersIndent;
    }

    /**
     * Before:
     * <pre>
     * {{ foo }}
     * </pre>
     * After:
     * <pre>
     * {{ foo }}
     * </pre>
     */
    public void testSimpleNode() {
        doStringBasedTest(
                "{{ foo }}",
                "{{ foo }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     * {{ bar }}
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     {{ bar }}
     * {{ /if }}
     * </pre>
     */
    public void testSimpleBlock() {
        doStringBasedTest(
                "{{ if true }}\n" +
                        "{{ bar }}\n" +
                        "{{ /if }}\n",

                "{{ if true }}\n" +
                        "    {{ bar }}\n" +
                        "{{ /if }}\n"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}{{ bar }}{{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     {{ bar }}
     * {{ /if }}
     * </pre>
     */
    public void _testSimpleBlock2() {
        doStringBasedTest(
                "hello world{{ if true }}{{ bar }}{{ else }} bar {{ /if }}hello_world\n",

                "hello world{{ if true }}\n" +
                        "    {{ if true }}\n" +
                        "    {{ bar }}\n" +
                        " {{ else }}\n" +
                        "    bar\n" +
                        "{{ /if }}\n" +
                        "hello_world\n"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     * {{ if true }}
     * {{ if true }}
     * {{ baz }}
     * {{ /if }}
     * {{ /if }}
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     {{ if true }}
     *         {{ if true }}
     *             {{ baz }}
     *         {{ /if }}
     *     {{ /if }}
     * {{ /if }}
     * </pre>
     */
    public void testNestedBlocks() {
        doStringBasedTest(
                "{{ if true }}\n" +
                        "{{ if true }}\n" +
                        "{{ if true }}\n" +
                        "{{ baz }}\n" +
                        "{{ /if }}\n" +
                        "{{ /if }}\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    {{ if true }}\n" +
                        "        {{ if true }}\n" +
                        "            {{ baz }}\n" +
                        "        {{ /if }}\n" +
                        "    {{ /if }}\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     * {{ foo }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ foo }}
     * </div>
     * </pre>
     */
    public void testSimpleNodeInDiv() {
        doStringBasedTest(
                "<div>\n" +
                        "{{ foo }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ foo }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     * <span></span>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <span></span>
     * {{ /if }}
     * </pre>
     */
    public void testMarkupInBlockNode() {
        doStringBasedTest(
                "{{ if true }}\n" +
                        "<span></span>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <span></span>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     * {{ if true }}
     * {{ bar }}
     * {{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         {{ bar }}
     *     {{ /if }}
     * </div>
     * </pre>
     */
    public void testSimpleBlockInDiv() {
        doStringBasedTest(
                "<div>\n" +
                        "{{ if true }}\n" +
                        "{{ bar }}\n" +
                        "{{ /if }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        {{ bar }}\n" +
                        "    {{ /if }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div {{ foo }}>
     * <div class="{{ bar }}">
     * sweet
     * </div>
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div {{ foo }}>
     *     <div class="{{ bar }}">
     *         sweet
     *     </div>
     * </div>
     * </pre>
     */
    public void testAttributeNodes() {
        doStringBasedTest(
                "<div {{ foo }}>\n" +
                        "<div class=\"{{ bar }}\">\n" +
                        "sweeet\n" +
                        "</div>\n" +
                        "</div>",

                "<div {{ foo }}>\n" +
                        "    <div class=\"{{ bar }}\">\n" +
                        "        sweeet\n" +
                        "    </div>\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     * {{ if true}}
     * <span class="{{ bat }}">{{ bar }}</span>
     * {{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true}}
     *         <span class="{{ bat }}">{{ bar }}</span>
     *     {{ /if }}
     * </div>
     * </pre>
     */
    public void testMixedContentInDiv1() {
        doStringBasedTest(
                "<div>\n" +
                        "{{ if true }}\n" +
                        "<span class=\"{{ bat }}\">{{ bar }}</span>\n" +
                        "{{ /if }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        <span class=\"{{ bat }}\">{{ bar }}</span>\n" +
                        "    {{ /if }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     * {{ if true }}
     * bar {{ baz }}
     * {{ /if }}
     * </div>
     * </pre>
     * After:
     * <pre>
     * <div>
     *     {{ if true }}
     *         bar {{ baz }}
     *     {{ /if }}
     * </div>
     * </pre>
     */
    public void testMixedContentInDiv2() {
        doStringBasedTest(
                "<div>\n" +
                        "{{ if true }}\n" +
                        "bar {{ baz }}\n" +
                        "{{ /if }}\n" +
                        "</div>",

                "<div>\n" +
                        "    {{ if true }}\n" +
                        "        bar {{ baz }}\n" +
                        "    {{ /if }}\n" +
                        "</div>"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     *     <div>
     * {{ bar }}
     *     </div>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <div>
     *         {{ bar }}
     *     </div>
     * {{ /if }}
     * </pre>
     */
    public void testSimpleNodeInNestedDiv() {
        doStringBasedTest(
                "{{ if true }}\n" +
                        "    <div>\n" +
                        "{{ bar }}\n" +
                        "    </div>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        {{ bar }}\n" +
                        "    </div>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     * <div>
     * {{ if true }}
     * stuff
     * {{ /if }}
     * </div>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <div>
     *         {{ if true }}
     *             stuff
     *         {{ /if }}
     *     </div>
     * {{ /if }}
     * </pre>
     */
    public void testBlockNodeInNestedDiv() {
        doStringBasedTest(
                "{{ if true }}\n" +
                        "<div>\n" +
                        "{{ if true }}\n" +
                        "stuff\n" +
                        "{{ /if }}\n" +
                        "</div>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <div>\n" +
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
     * <div>
     * <div>
     * <div>
     * {{ bar }}
     * {{ if true }}
     * {{ /if }}
     * </div>
     * </div>
     * </div>
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     <div>
     *         <div>
     *             <div>
     *                 {{ bar }}
     *                 {{ if true }}
     *                 {{ /if }}
     *             </div>
     *         </div>
     *     </div>
     * {{ /if }}
     * </pre>
     */
    public void testNestedDivsInBlock() {
        doStringBasedTest(
                "{{ if true }}\n" +
                        "<div>\n" +
                        "<div>\n" +
                        "<div>\n" +
                        "{{ bar }}\n" +
                        "{{ if true }}\n" +
                        "{{ /if }}\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "</div>\n" +
                        "{{ /if }}",

                "{{ if true }}\n" +
                        "    <div>\n" +
                        "        <div>\n" +
                        "            <div>\n" +
                        "                {{ bar }}\n" +
                        "                {{ if true }}\n" +
                        "                {{ /if }}\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "{{ /if }}"
        );
    }

    /**
     * Before:
     * <pre>
     * <div>
     * <body>
     * {{ if true }}
     * <div></div>
     * {{ /if }}
     * </body>
     * </pre>
     * After:
     * <pre>
     * <body>
     * {{ if true }}
     *     <div></div>
     * {{ /if }}
     * </body>
     * </pre>
     */
    public void testFormattingInsideDoNotIndentElems1() {
        HtmlCodeStyleSettings settings = getHtmlSettings();
        settings.HTML_DO_NOT_INDENT_CHILDREN_OF = "body";

        doStringBasedTest(
                "<body>\n" +
                        "{{ if true }}\n" +
                        "<div></div>\n" +
                        "{{ /if }}\n" +
                        "</body>",

                "<body>\n" +
                        "{{ if true }}\n" +
                        "    <div></div>\n" +
                        "{{ /if }}\n" +
                        "</body>"
        );
    }

    /**
     * Before:
     * <pre>
     * <body>
     * {{ foo }}
     * <div></div>
     * </body>
     * </pre>
     * After:
     * <pre>
     * <body>
     * {{ foo }}
     * <div></div>
     * </body>
     * </pre>
     */
    public void testFormattingInsideDoNotIndentElems2() {
        HtmlCodeStyleSettings settings = getHtmlSettings();
        settings.HTML_DO_NOT_INDENT_CHILDREN_OF = "body";

        doStringBasedTest(
                "<body>\n" +
                        "{{ foo }}\n" +
                        "<div></div>\n" +
                        "</body>",

                "<body>\n" +
                        "{{ foo }}\n" +
                        "<div></div>\n" +
                        "</body>"
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
     * {{ foo }}
     * <div></div>
     * </body>
     * </pre>
     */
    public void testFormattingInsideDoNotIndentElems3() {
        HtmlCodeStyleSettings settings = getHtmlSettings();
        settings.HTML_DO_NOT_INDENT_CHILDREN_OF = "body";

        doStringBasedTest(
                "<body>\n" +
                        "{{ foo }}\n" +
                        "<div></div>\n" +
                        "</body>",

                "<body>\n" +
                        "{{ foo }}\n" +
                        "<div></div>\n" +
                        "</body>"
        );
    }

    /**
     * Before:
     * <pre>
     * <span>
     * {{ if true }}
     * <span>
     * {{^bar}}
     * <span></span>
     * {{/bar}}
     * </span>
     * {{ /if }}
     * </span>
     * </pre>
     * After:
     * <pre>
     * <span>
     * {{ if true }}
     *     <span>
     *     {{ ^bar }}
     *     <span></span>
     *     {{ /bar }}
     *     </span>
     * {{ /if }}
     * </span>
     * </pre>
     */
    public void _testFormattingInsideNestedDoNotIndentElems() {
        HtmlCodeStyleSettings settings = getHtmlSettings();
        settings.HTML_DO_NOT_INDENT_CHILDREN_OF = "span";

        doStringBasedTest(
                "<span>\n" +
                        "{{ if true }}\n" +
                        "<span>\n" +
                        "{{^bar}}\n" +
                        "<span></span>\n" +
                        "{{/bar}}\n" +
                        "</span>\n" +
                        "{{ /if }}\n" +
                        "</span>",

                "<span>\n" +
                        "{{ if true }}\n" +
                        "    <span>\n" +
                        "    {{^bar}}\n" +
                        "        <span></span>\n" +
                        "    {{/bar}}\n" +
                        "    </span>\n" +
                        "{{ /if }}\n" +
                        "</span>"
        );
    }

    /**
     * Before:
     * <pre>
     * {{# FOO #}}
     * </pre>
     * After:
     * <pre>
     * {{# FOO #}}
     * </pre>
     */
    public void testSingleComment() {
        doStringBasedTest(
                        "{{# FOO #}}\n",
                        "{{# FOO #}}\n"
        );
    }

    /**
     * Before:
     * <pre>
     * {{ if true }}
     * {{# FOO #}}
     * {{ bar }}
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{ if true }}
     *     {{# FOO #}}
     *     {{ bar }}
     * {{ /if }}
     * </pre>
     */
    public void testCommentInsideBlock() {
        doStringBasedTest(
                "{{ if true }}\n" +
                        "{{# FOO #}}\n" +
                        "{{ bar }}\n" +
                        "{{ /if }}\n",

                "{{ if true }}\n" +
                        "    {{# FOO #}}\n" +
                        "    {{ bar }}\n" +
                        "{{ /if }}\n"
        );
    }

    /**
     * Before:
     * <pre>
     * {{# FOO #}}
     * {{ if true }}
     * {{ bar }}
     * {{ /if }}
     * </pre>
     * After:
     * <pre>
     * {{# FOO #}}
     * {{ if true }}
     *     {{ bar }}
     * {{ /if }}
     * </pre>
     */
    public void testCommentOutsideBlock() {
        doStringBasedTest(
                "{{# FOO #}}\n" +
                        "{{ if true }}\n" +
                        "{{ bar }}\n" +
                        "{{ /if }}\n",

                "{{# FOO #}}\n" +
                        "{{ if true }}\n" +
                        "    {{ bar }}\n" +
                        "{{ /if }}\n"
        );
    }

    @NotNull
    private HtmlCodeStyleSettings getHtmlSettings() {
        return CodeStyle.getSettings(getProject()).getCustomSettings(HtmlCodeStyleSettings.class);
    }
}
