package io.github.floyd.java8.stream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ListStream {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world");
        Stream<String> stream = list.stream();

        Stream<String> stringStream = Arrays.stream(new String[]{"hello",
            "world"});

        Stream<String> stream1 = Stream.of("hello", "world");
    }
}
