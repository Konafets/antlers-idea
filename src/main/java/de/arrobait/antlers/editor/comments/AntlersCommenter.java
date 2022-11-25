package de.arrobait.antlers.editor.comments;

import com.intellij.codeInsight.generation.CommenterWithLineSuffix;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AntlersCommenter implements CommenterWithLineSuffix {

    @Override
    @Nullable
    public String getLineCommentPrefix() {
        return "{{# ";
    }

    @Override
    @NotNull
    public String getLineCommentSuffix() {
        return " #}}";
    }

    @Override
    @Nullable
    public String getBlockCommentPrefix() {
        return "{{# ";
    }

    @Override
    @Nullable
    public String getBlockCommentSuffix() {
        return " #}}";
    }

    @Override
    @Nullable
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Override
    @Nullable
    public String getCommentedBlockCommentSuffix() {
        return null;
    }

//    @Override
//    public boolean blockCommentRequiresFullLineSelection() {
//      return true;
//    }
}
