package io.github.floyd.java8.lambda.demo;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author floyd
 */
public class Lambdas {

    private static List<Project> buildData() {
        return FilterProjects.getProjects();
    }

    public static void main(String[] args) {
        List<Project> projects = buildData();
        List<String> names = getNames(projects);
        names.stream()
                .map(s -> s + " ")
                .collect(Collectors.toList())
                .forEach(System.out::print);
        System.out.println();
        for (String name : names) {
            System.out.println(name);
        }
    }

    private static List<String> getNames(List<Project> projects) {
        List<String> names = new ArrayList<>();
        for (Project project : projects) {
            names.add(project.getName());
        }
        return names;
    }
}
