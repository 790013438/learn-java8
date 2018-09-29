package io.github.floyd.java8.collect;

import io.github.floyd.java8.lambda.FilterProjects;
import io.github.floyd.java8.lambda.domain.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据分区
 * <p>
 * Collectors.partitioningBy</p>
 * <p>
 * 根据符合条件划分为true 和 false，流结果划分到list里
 * 差选条件 处理流的元素，返回boolean
 * @author biezhi floyd
 */
public class PartitioningBy {

    private static Logger logger = LoggerFactory.getLogger(PartitioningBy.class);

    public static void main(String[] args) {
        List<Project> projects = FilterProjects.getProjects();

        Map<Boolean, List<Project>> projectMap = projects.stream()
            .collect(Collectors.partitioningBy(PartitioningBy::isBackEnd));
        logger.debug("Collectors.partitioningBy Map boolean {}", projectMap);
    }

    private static boolean isBackEnd(Project project) {
        return "java".equalsIgnoreCase(project.getLanguage()) || "python".equalsIgnoreCase(project.getLanguage());
    }
}
