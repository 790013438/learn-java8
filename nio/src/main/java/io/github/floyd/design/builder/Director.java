package io.github.floyd.design.builder;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design
 * Company: com.yinhai
 * date 2020/8/27
 * @see *#
 */
public class Director {
    public void createProduct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
