package io.github.floyd.java8.collect;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 转换类型
 * <p>
 * Collections.toCollection
 * </p>
 * <p>
 * Collections.collectingAndThen
 * </p>
 * <p>
 * Collections.maxBy
 * </p>
 * <p>
 * Collections.minBy
 * </p>
 *
 * @author biezhi floyd
 */
public class Convert {

    private static final Logger logger = LoggerFactory.getLogger(Convert.class);

    public static void main(String[] args) {
        List<Project> projects = FilterProjects.getProjects();

        HashSet<Project> projectHashSet = projects.stream()
                .filter(p -> p.getStars() > 30)
                .collect(Collectors.toCollection(HashSet::new));

        logger.debug("set {}", projectHashSet);
    }
}
