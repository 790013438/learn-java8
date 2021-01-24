package io.github.floyd.java8.generic;

import io.github.floyd.java8.nio.channel.Check2Impl;
import io.github.floyd.java8.nio.channel.CheckImpl;
import io.github.floyd.java8.nio.channel.CheckInterface;

import java.util.HashMap;
import java.util.function.Function;

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

 */
public class TestMain {
    public static void main(String...args) {
        GenericInMethod genericInMethod = new GenericInMethod();
        System.out.println(genericInMethod.apply("a"));
    }

}
