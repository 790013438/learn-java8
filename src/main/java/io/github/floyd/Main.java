package io.github.floyd;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

/**
 * @author 程淼
 */
public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(File::isHidden);
        Arrays.stream(hiddenFiles != null ? hiddenFiles : new File[0])
                .map(File::toString)
                .forEach(logger::debug);

        recursive(new File("."));
    }

    private static void recursive (File file) {
        if (file.isDirectory()) {
            File[] hiddenFiles = file.listFiles(File::isHidden);
            Arrays.stream(hiddenFiles != null ? hiddenFiles : new File[0])
                    .forEach(e -> {
                        if (e.isDirectory()) {
                            recursive(e);
                        }
                        logger.debug(e.toString());
                    });
        }
    }
}
