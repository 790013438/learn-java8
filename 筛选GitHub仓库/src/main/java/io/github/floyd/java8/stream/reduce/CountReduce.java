package io.github.floyd.java8.stream.reduce;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;

import java.util.List;

public class CountReduce {

    public static void main(String[] args) {

        List<Project> projects = FilterProjects.getProjects();
        Integer biezhi = projects.stream()
            .filter(p -> p.getAuthor().equals("biezhi"))
            .map(p -> p.getStars())
            .reduce(0, Integer::sum);
        System.out.println(biezhi);
    }
}
