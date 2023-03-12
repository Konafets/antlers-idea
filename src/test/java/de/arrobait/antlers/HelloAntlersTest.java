package de.arrobait.antlers;

import de.arrobait.antlers.file.AntlersFileType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class HelloAntlersTest {
    @Test
    public void it_gets_file_description() {
        assertEquals("Antlers template file", AntlersFileType.INSTANCE.getDescription());
    }
}
