package de.arrobait.antlers.util;

import java.io.File;

public final class AntlersTestUtils {
    public static final String BASE_TEST_DATA_PATH = findTestDataPath();

    private static String findTestDataPath() {
        File f = new File("test", "data");
        if (f.exists()) {
            return f.getAbsolutePath();
        }

        return "src/test/testData";
    }
}
