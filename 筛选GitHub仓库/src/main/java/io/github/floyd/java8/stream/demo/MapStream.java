package io.github.floyd.java8.stream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapStream {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Java 8", "Lambdas", "In",
                "Action");

        words.stream()
            .map(String::length)
            .collect(Collectors.toList())
            .forEach(System.out::println);
    }
}
