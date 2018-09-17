package io.github.floyd.java8.collect;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 将结果收集到 Map 中
 * <p>
 * Collectors.toMap
 * Function.identity()
 * </p>
 *
 * @author biezhi floyd
 */
public class Group {

    private static final String SEPARATOR = "====================";
    private static final Logger logger = LoggerFactory.getLogger(Group.class);

    public static void main(String[] args) {
        List<Project> projects = FilterProjects.getProjects();

        Map<String, Integer> map = projects.stream()
            .collect(Collectors.toMap(Project::getName, Project::getStars));
        logger.debug("得到map{}", map);
        logger.debug(SEPARATOR);
    }
}
