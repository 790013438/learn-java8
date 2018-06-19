package io.github.floyd.java8.lambda;

import io.github.floyd.java8.lambda.domain.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterProjects {

    public static List<Project> filterJavaProjects(List<Project> projects) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if ("java".equals(project.getLanguage())) {
                result.add(project);
            }
        }
        return result;
    }

    public static List<Project> filterLanguageProjects(List<Project> projects, String language) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (language.equals(project.getLanguage())) {
                result.add(project);
            }
        }
        return result;
    }

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
        List<Project> data = buildData();

        List<Project> filter = filter(data, project -> project.getStars() > 1000);
        List<String> names = getNames();
        System.out.println(filter);
    }

    public static List<String> getNames(List<Project> projects) {
        List<String> names = new ArrayList<>();
        for (Project project : projects) {
            names.add(project.getNames());
        }
        return names;
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }
}
