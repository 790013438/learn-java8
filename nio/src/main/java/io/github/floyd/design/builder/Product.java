package io.github.floyd.design.builder;

import java.util.ArrayList;
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
 * date 2020/8/27
 * @see *#
 */
public class Product {
    List<String> parts = new ArrayList<>();

    public void add(String part) {
        parts.add(part);
    }

    public void show() {
        System.out.println("\n产品 创建 ----");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
