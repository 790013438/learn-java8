package io.github.floyd.java8.nio.channel;

/**
 * @author 程淼
 * @version 1.0
 * ClassName io.github.floyd.java8.nio.channel
 * Description: 描述 继承接口和接口的实现
 * Company: com.yinhai  多个接口的实现类，并有一个类继承该多个实现类。一个类只能继承一个类，如果接口有默认实现方法，实现该接口的类重写了该方法，另一个类继承前实现类，调用方法是前实现类的；如果未重写，调用方法的是默认接口实现方法
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

    /**
     * 提供消息
     *
     * @return 随意的一段
     */
    @Override
    public String supply() {
        return super.supply() + " 2";
    }
}
