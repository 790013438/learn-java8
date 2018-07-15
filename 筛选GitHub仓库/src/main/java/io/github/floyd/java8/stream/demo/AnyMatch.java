package io.github.floyd.java8.stream.demo;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;

import java.util.List;

public class AnyMatch {

    public static void main(String[] args) {
        List<Project> projects = FilterProjects.getProjects();

        boolean hasBiezhi = projects.stream()
            .anyMatch(p -> p.getAuthor().equals("biezhi"));

        System.out.println(hasBiezhi);

        System.out.println(projects.stream()
                .allMatch(p -> p.getAuthor().equals("biezhi")));

        System.out.println(projects.stream()
            .noneMatch(p -> p.getAuthor().equals("biezhi")));

        System.out.println(projects.stream()
            .findAny().get());

        System.out.println(projects.stream()
                .findFirst().get());
    }
}
