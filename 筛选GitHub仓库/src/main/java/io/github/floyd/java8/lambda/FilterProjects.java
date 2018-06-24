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
        return getProjects();
    }

    public static List<Project> getProjects() {
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

        List<Project> filter = filter(projects, project -> project.getStars() > 1000);
        List<String> names = getNames(projects);
        names.forEach(System.out::println);
        names = getNames(projects, project -> project.getStars() > 1000);
        names.forEach(System.out::println);
        System.out.println(filter);
    }

    private static List<String> getNames(List<Project> projects) {
        List<String> names = new ArrayList<>();
        for (Project project : projects) {
            names.add(project.getName());
        }
        return names;
    }

    private static List<String> getNames(List<Project> projects, Predicate<Project> predicate) {
        List<String> names = new ArrayList<>();
        for(Project project : projects) {
            if (predicate.test(project)) {
                names.add(project.getName());
            }
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
