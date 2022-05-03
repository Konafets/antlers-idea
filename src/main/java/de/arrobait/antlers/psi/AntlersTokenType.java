package de.arrobait.antlers.psi;

import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.AntlersLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class AntlersTokenType extends IElementType {
    public AntlersTokenType(@NotNull @NonNls String debugName) {
      super(debugName, AntlersLanguage.INSTANCE);
    }
}
