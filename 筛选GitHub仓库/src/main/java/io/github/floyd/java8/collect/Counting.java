package io.github.floyd.java8.collect;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static final Logger logger = LoggerFactory.getLogger(Counting.class);
    private static final String SEPARATOR = "====================";

    public static void main(String[] args) {
        List<Project> projects = FilterProjects.getProjects();
        Long collect = projects.stream()
                .filter(project -> project.getStars() > 300).collect(Collectors.counting());
        logger.debug("收藏数大于300的项目{}", collect);
        logger.debug(SEPARATOR);

        Optional<Project> optSort = projects.stream()
            .collect(Collectors.maxBy(Comparator.comparingInt(Project::getStars)));
        logger.debug("收藏数最多的项目{}", optSort.orElse(Project.builder().name("unnamed").build()));
        logger.debug(SEPARATOR);

        // 求和
        int i = projects.stream()
            .collect(Collectors.summingInt(Project::getStars));
        logger.debug("收藏数之和{}", i);
        logger.debug(SEPARATOR);

        // 4. 求平均值
        double average = projects.stream()
            .collect(Collectors.averagingDouble(Project::getStars));
        logger.debug("收藏数平均值{}", average);
        logger.debug(SEPARATOR);

        // 5. 连接字符串
        String str = Stream.of("Hello", "Java8")
            .collect(Collectors.joining(", "));
        logger.debug("连接字符串{}", str);
        logger.debug(SEPARATOR);

        // 6. 一般归约
        int sum = projects.stream()
            .collect(Collectors.reducing(0, Project::getStars, (x, y) -> x + y));
        logger.debug("用reduce求和{}", sum);
        logger.debug(SEPARATOR);

        // 另外一种累加操作
        Optional<Integer> sumCollect = projects.stream()
            .map(Project::getStars)
            .collect(Collectors.reducing((x, y) -> x + y));
        logger.debug("第二种用reduce求和{}", sumCollect);
        logger.debug(SEPARATOR);
    }
}
