package io.github.floyd.design.decorator.person;

import java.sql.SQLOutput;

/**
 * 此类的主要功能是：展示人 <br/>
 * 此类提供的主要方法有：<br/>
 * 1. show 展示人员
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.decorator.person
 * Company: com.yinhai
 * date 2021/1/27
 * @see *#
 */
public class Person {
    private String name;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(new StringBuffer("装扮的").append(name).toString());
    }
}
