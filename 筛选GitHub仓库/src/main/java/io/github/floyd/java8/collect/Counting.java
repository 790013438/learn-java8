package io.github.floyd.java8.collect;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

/**
 * 1. 计数
 * <p>
 * Collectors.counting
 * count
 * </p>
 * <p>
 * 2. 最值
 * Collectors.maxBy
 * </p>
 * <p>
 * 3. 求和
 * Collectors.summingInt
 * </p>
 * <p>
 * 4. 求平均值
 * Collectors.averagingInt
 * <p>
 * 5. 连接字符串
 * Collectors.joining
 * </p>
 * <p>
 * 6. 一般归约
 * Collectors.reducing
 * </p>
 *
 * @author floyd
 */
public class Counting {

    public static void main(String[] args) {
        List<Project> projects = FilterProjects.getProjects();
        Long collect = projects.stream()
                .filter(project -> project.getStars() > 300).collect(Collectors.counting());
        System.out.println(collect);
        System.out.println("====================");

        Optional<Project> optSort = projects.stream()
            .collect(Collectors.maxBy(Comparator.comparingInt(Project::getStars)));
        System.out.println(optSort);
        System.out.println("====================");

    }
}
