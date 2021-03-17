package io.github.floyd.design.proxy;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.proxy
 * Company: com.yinhai
 * date 2021/2/1
 * @see *#
 */
public class RealSubject extends Subject {
    /**
     * 定义行为
     */
    @Override
    public void request() {
        System.out.println("真实的请求");
    }
}
