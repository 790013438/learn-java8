package io.github.floyd;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        Arrays.stream(hiddenFiles)
                .forEach(System.out::println);
    }
}
