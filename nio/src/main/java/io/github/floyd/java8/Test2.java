package io.github.floyd.java8;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.java8
 * Company: com.yinhai
 * date 2021/3/15
 * @see *#
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            doSomethingWhichThrowsException();
            // "OK" 会输出
            System.out.println("OK");
        } catch (RuntimeException e) {
            // 该句代码将不会执行
            System.out.println("ERROR");
        }
    }

    public static void doSomethingWhichThrowsException() {
        int q = 2;
        try {
            throw new RuntimeException();
        } finally {
            for (int i = 0; i < 10; i++) {
                //...
                if (q == i) {
                    break; // ignored
                }
            }
            /* ... */
//            return; // 这里 return 将会抑制 doSomethingWhichThrowsException方法中抛出异常的传播，使 main 方法中无法捕获
        }
    }
}

class Main {
    public static void main(String [] args) throws UnsupportedEncodingException {
        System.out.println(URLDecoder.decode("%E9%82%B1%E7%8E%89%E4%B8%9C", "utf-8"));
        System.out.println(URLDecoder.decode("%E9%82%B1%E7%8E%89%E4%B8%9C", "gbk"));
        System.out.println(URLDecoder.decode("%E9%82%B1%E7%8E%89%E4%B8%9C", "GBK"));
        System.out.println(URLDecoder.decode("%E9%82%B1%E7%8E%89%E4%B8%9C", "GBK"));
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                Main a = new Main();
                a.doSomething();
            }
        });

    }
    private void doSomething() {
        System.out.println("23");
    }
}
