package io.github.floyd.java8.nio.channel;

/**
 * @author 程淼
 * @version 1.0
 * ClassName io.github.floyd.java8.nio.channel
 * Description: 描述
 * Company: com.yinhai
 * date 2019/2/25
 */
public interface CheckInterface {
    /**
     * 消费信息
     */
    void print();

    /**
     * 提供消息
     * @return 随意的一段
     */
    default String supply() {
        return "Great Wall";
    }
}
