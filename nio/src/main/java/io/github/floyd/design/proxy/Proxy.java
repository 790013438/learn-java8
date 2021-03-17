package io.github.floyd.design.proxy;

/**
 * 此类的主要功能是： <br/>
 * 1. Proxy类， 保存一个引用使得代理可以访问实体，<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.proxy
 * Company: com.yinhai
 * date 2021/2/1
 * @see #request()  提供一个与 Subject 的接口相同的 接口， 这样代理就可以用来替代实体。
 */
public class Proxy extends Subject {

    private RealSubject realSubject;

    /**
     * 定义行为
     */
    @Override
    public void request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.request();
    }
}
