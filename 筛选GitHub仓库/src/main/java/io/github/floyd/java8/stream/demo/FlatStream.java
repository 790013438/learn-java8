package io.github.floyd.java8.stream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatStream {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("I am a boy", "I love the girl",
                "But the girl loves another girl");

        list = list.stream()
            .map(word -> word.split(" "))
            .flatMap(Arrays::stream)
            .distinct()
            .collect(Collectors.toList());

        System.out.println(list);
    }
}
