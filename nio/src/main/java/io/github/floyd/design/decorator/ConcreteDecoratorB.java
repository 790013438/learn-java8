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
public class ConcreteDecoratorB extends Decorator {

    private void addedBehavior() {
        // 本类独有的方法，以区别于ConcreteDecoratorA
    }

    /**
     * 装饰操作
     */
    @Override
    void operation() {
        super.operation();
        addedBehavior();
        System.out.println("具体装饰对象B的操作");
    }
}
