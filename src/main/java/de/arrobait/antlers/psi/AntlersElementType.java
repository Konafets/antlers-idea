package de.arrobait.antlers.psi;

import com.intellij.psi.tree.IElementType;
import de.arrobait.antlers.AntlersLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class AntlersElementType extends IElementType {
    public AntlersElementType(@NotNull @NonNls String debugName) {
        super(debugName, AntlersLanguage.INSTANCE);
    }
}
