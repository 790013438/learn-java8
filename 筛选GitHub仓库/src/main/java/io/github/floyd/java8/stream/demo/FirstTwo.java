package io.github.floyd.java8.stream.demo;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstTwo {

    public static void main(String[] args) {
        List<Project> projects = FilterProjects.getProjects();

        System.out.println(
                projects.stream()
                .limit(2)
                .collect(Collectors.toList()));

        projects.stream()
                .limit(2)
                .forEach(System.out::println);
    }
}
