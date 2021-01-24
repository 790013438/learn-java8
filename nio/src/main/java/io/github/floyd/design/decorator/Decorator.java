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
public class Decorator extends Component {

    protected Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    /**
     * 装饰操作
     */
    @Override
    void operation() {
        if (component != null) {
            component.operation();
        }
    }
}
