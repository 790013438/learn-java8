package io.github.floyd.design.decorator;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.decorator
 * Company: com.yinhai
 * date 2021/1/24

 */
public class ConcreteDecoratorA extends Decorator {
    /**
     * 区分其他decorator
     */
    private String addedState;

    /**
     * 装饰操作
     */
    @Override
    void operation() {
        super.operation();
        addedState = "New State";
        System.out.println("具体装饰对象A的操作");
    }
}
