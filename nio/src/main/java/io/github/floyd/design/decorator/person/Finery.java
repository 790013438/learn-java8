package io.github.floyd.design.decorator.person;

/**
 * 此类的主要功能是： <br/>
 * 1. 服饰<br/>
 * 此类提供的主要方法有：<br/>
 * 1. 包装人物
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.decorator.person
 * Company: com.yinhai
 * date 2021/1/28
 * @see *#
 */
public abstract class Finery extends Person {
    protected Person component;

    /**
     * 打扮某个人
     */
    protected void decorate(Person component) {
        this.component = component;
    }

    @Override
    public void show() {
        if (component != null) {
            component.show();
        }
    }
}
