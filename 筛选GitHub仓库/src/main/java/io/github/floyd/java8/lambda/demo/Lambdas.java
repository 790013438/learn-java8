package io.github.floyd.java8.lambda.demo;

import io.github.floyd.java8.lambda.domain.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author floyd
 */
public class Lambdas {

    private static List<Project> buildData() {
        List<Project> data = new ArrayList<>();

        data.add(Project
                .builder()
                .name("Blade")
                .language("java")
                .author("biezhi")
                .stars(3500)
                .description("Lighting fast and elegant mvc framework for Java8")
                .build());

        data.add(Project
                .builder()
                .name("Tale")
                .language("java")
                .author("biezhi")
                .stars(2600)
                .description("")
                .build());

        data.add(Project
                .builder()
                .name("Vue.js")
                .language("js")
                .author("yyx990803")
                .stars(83000)
                .description("A progressive, incrementally-adoptable JavaScript framework for building UI on the web.")
                .build());

        data.add(Project
                .builder()
                .name("Flask")
                .language("python")
                .author("pallets")
                .stars(10500)
                .description("The Python micro framework for building web applications")
                .build());

        data.add(Project
                .builder()
                .name("Elves")
                .language("java")
                .author("biezhi")
                .stars(200)
                .description("Spider")
                .build());

        return data;
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
