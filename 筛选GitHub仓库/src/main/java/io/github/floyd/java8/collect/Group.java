package io.github.floyd.java8.collect;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

        // 得到所有名字和start数
        Map<String, Integer> map0 = projects.stream()
            .collect(Collectors.toMap(Project::getName, Project::getStars));
        logger.debug("得到map{}", map0);
        logger.debug(SEPARATOR);

        // 名字对应的整个project类
        Map<String, Project> map1 = projects.stream()
            .collect(Collectors.toMap(Project::getName, Function.identity()));
        logger.debug("得到map, key 对应整个项目{}", map1);
        logger.debug(SEPARATOR);

        // 分组
        Map<String, List<Project>> map2 = projects.stream()
            .collect(Collectors.groupingBy(Project::getAuthor));
        logger.debug("得到map, 分组{}", map2);
        logger.debug(SEPARATOR);
    }

}
