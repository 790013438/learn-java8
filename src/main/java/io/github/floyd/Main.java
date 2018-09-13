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
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        Arrays.stream(hiddenFiles)
                .forEach(System.out::println);

        recursive(new File("."));
    }

    private static void recursive (File file) {
        if (file.isDirectory()) {
            File[] hiddenFiles = file.listFiles(new FileFilter() {
                @Override
                public boolean accept(File pathname) {
                    return pathname.isHidden();
                }
            });
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
