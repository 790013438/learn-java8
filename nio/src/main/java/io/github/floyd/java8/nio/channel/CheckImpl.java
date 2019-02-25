package io.github.floyd.java8.nio.channel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 程淼
 * @version 1.0
 * ClassName io.github.floyd.java8.nio.channel
 * Description: 描述
 * Company: com.yinhai
 * date 2019/2/25
 */
public class CheckImpl implements CheckInterface {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckImpl.class);

    /**
     * 消费信息
     */
    @Override
    public void print() {
        LOGGER.debug("hello");
    }

/*    *//**
     * 提供消息
     *
     * @return 随意的一段
     *//*
    @Override
    public String supply() {
        return "vim";
    }*/

    public Logger getLogger() {
        return LOGGER;
    }
}
