package io.github.floyd.java8.stream.demo;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterStream {

    public static void main(String[] args) {
        List<Project> projects = FilterProjects.getProjects();
        List<Project> projectsCollect =  projects.stream()
            .filter(project -> project.getStars() > 1000)
            .collect(Collectors.toList());
        System.out.println(projectsCollect);

        Stream<Integer> numbers = Stream.of(1, 2, 3, 3, 2, 4);
        numbers.distinct()
            .forEach(System.out::println);
    }

}
