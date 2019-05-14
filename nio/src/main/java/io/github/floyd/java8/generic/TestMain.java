package io.github.floyd.java8.generic;

import io.github.floyd.java8.nio.channel.Check2Impl;
import io.github.floyd.java8.nio.channel.CheckImpl;
import io.github.floyd.java8.nio.channel.CheckInterface;

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
 * @see *#
 */
public class TestMain {
    public static void main(String...args) {
        // compose 处理一下，返回apply需要处理的东西
        Function a = ((Function<CheckImpl, String>) CheckInterface::supply).compose((CheckImpl b) -> b);
        System.out.println(a.compose(new Function<CheckImpl, CheckImpl>(){
            /**
             * Applies this function to the given argument.
             *
             * @param check the function argument
             * @return the function result
             */
            @Override
            public CheckImpl apply(CheckImpl check) {
                return check;
            }
        }).apply(new Check2Impl()));
    }
}
