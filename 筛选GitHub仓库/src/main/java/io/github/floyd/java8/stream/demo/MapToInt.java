package io.github.floyd.java8.stream.demo;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;

import java.util.List;
import java.util.OptionalInt;

/**
 * 数值流
 * <p>
 * IntStream、DoubleStream、LongStream
 *
 * @author fork from biezhi
 * @date 2018/7/15
 */
public class MapToInt {

    public static void main(String[] args) {
        List<Project> projects = FilterProjects.getProjects();
        OptionalInt max = projects.stream()
            .mapToInt(Project::getStars)
            .max();

        System.out.println(max.orElse(-1));
    }
}
