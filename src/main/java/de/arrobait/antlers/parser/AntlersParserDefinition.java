package de.arrobait.antlers.parser;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import de.arrobait.antlers.AntlersLanguage;
import de.arrobait.antlers.psi.AntlersFile;
import de.arrobait.antlers.psi.AntlersTokenSets;
import de.arrobait.antlers.psi.AntlersTypes;
import org.jetbrains.annotations.NotNull;

public class AntlersParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE = new IFileElementType(AntlersLanguage.INSTANCE);
    public static final TokenSet COMMENTS = TokenSet.create(AntlersTypes.COMMENT_BLOCK);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new AntlersLexerAdapter();
    }

    @Override
    public @NotNull PsiParser createParser(Project project) {
        return new AntlersParser();
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
      return AntlersTokenSets.WHITESPACES;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return TokenSet.create(AntlersTypes.STRING_LITERAL);
    }

    @NotNull
    @Override
    public SpaceRequirements spaceExistenceTypeBetweenTokens(ASTNode left, ASTNode right) {
      return SpaceRequirements.MAY;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return AntlersTypes.Factory.createElement(node);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new AntlersFile(viewProvider);
    }
}
