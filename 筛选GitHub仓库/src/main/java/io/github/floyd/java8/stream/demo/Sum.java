package io.github.floyd.java8.stream.demo;

import java.util.Arrays;
import java.util.List;

public class Sum {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 5, 6);

        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }
        System.out.println(sum);

        Integer reduce = numbers.stream()
            .reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }
}
