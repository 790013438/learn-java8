package io.github.floyd.java8.generic;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.java8.generic
 * Company: com.yinhai
 * date 2019/5/14
 * @ProjectName a01Component
 * @see *#
 */
public class GenericInMethod {
    public <T extends String> String apply(T a) {
        return a.concat(a);
    }
}
