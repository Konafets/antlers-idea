package de.arrobait.antlers;

import de.arrobait.antlers.file.AntlersFileType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloAntlersTest {
    @Test
    public void it_gets_file_description() {
        assertEquals("Antlers template file", AntlersFileType.INSTANCE.getDescription());
    }
}
