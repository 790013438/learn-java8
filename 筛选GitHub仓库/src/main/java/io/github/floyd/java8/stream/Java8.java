package io.github.floyd.java8.stream;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;

import java.util.List;
import java.util.stream.Collectors;

public class Java8 {

    public static void main(String[] args) {
        List<Project> projects = FilterProjects.getProjects();
        List<String> names = projects.stream()
                .filter(p -> p.getStars() > 1000)
                .map(Project::getName)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(names);
    }
}
