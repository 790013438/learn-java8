package io.github.floyd.java8.nio.channel;

/**
 * @author 程淼
 * @version 1.0
 * ClassName io.github.floyd.java8.nio.channel
 * Description: 描述 继承接口和接口的实现
 * Company: com.yinhai
 * date 2019/2/25
 */
public class Check2Impl extends CheckImpl implements CheckInterface {
    /**
     * 消费信息
     */
    @Override
    public void print() {
        getLogger().debug("hi, two");
    }
}
