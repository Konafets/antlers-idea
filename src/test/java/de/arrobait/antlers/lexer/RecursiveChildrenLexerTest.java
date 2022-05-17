package de.arrobait.antlers.lexer;

import de.arrobait.antlers.parser.AntlersLexerAdapter;
import org.junit.Test;

import static com.intellij.psi.TokenType.WHITE_SPACE;
import static de.arrobait.antlers.psi.AntlersTypes.*;

public class RecursiveChildrenLexerTest extends LexerTest {
    public RecursiveChildrenLexerTest() {
        super(new AntlersLexerAdapter());
    }

    @Test
    public void it_lexes_recursive_children_tag() {
        givenInput("{{ *recursive children* }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_STAR, "*",
                T_RECURSIVE_CHILDREN, "recursive children",
                T_STAR, "*",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }

    @Test
    public void it_lexes_recursive_children_tag_with_scoped_variable() {
        givenInput("{{ *recursive children:my_scoped_variable* }}");
        thenTokensAre(
                T_LD, "{{",
                WHITE_SPACE, " ",
                T_STAR, "*",
                T_RECURSIVE_CHILDREN, "recursive children",
                T_COLON, ":",
                T_IDENTIFIER, "my_scoped_variable",
                T_STAR, "*",
                WHITE_SPACE, " ",
                T_RD, "}}"
        );
    }
}
