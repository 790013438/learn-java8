package io.github.floyd.java8.lambda;

import io.github.floyd.java8.lambda.domain.Project;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodReference {

    private static List<Integer> findNumbers(List<Integer> numbers, Predicate<Integer> filter) {

        return numbers
            .stream()
            .filter(filter)
            .collect(Collectors.toList());
    }

    private static boolean multiplesOf3(Integer number) {
        return (number % 3) == 0;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 6, 8, 9, 12, 14, 15);

        List<Integer> multiplesOf3 = findNumbers(numbers, MethodReference::multiplesOf3);
        System.out.println(multiplesOf3.contains(3));

        Project project = Project
            .builder()
            .name("Blade")
            .build();

        Stream.of(project)
            .map(Project::getName)
            .count();
    }
}
