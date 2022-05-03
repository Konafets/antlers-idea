package de.arrobait.antlers;

import de.arrobait.antlers.file.AntlersFileType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloAntlersTest {
    @Test
    public void testAdd() {
        assertEquals("Antlers template file", AntlersFileType.INSTANCE.getDescription());
    }
}
