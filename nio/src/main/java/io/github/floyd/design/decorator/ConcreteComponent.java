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
public class ConcreteComponent extends Component {
    /**
     * 装饰操作
     */
    @Override
    void operation() {
        System.out.println("具体对象的操作");
    }
}
