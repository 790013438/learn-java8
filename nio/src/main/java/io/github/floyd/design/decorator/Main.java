package io.github.floyd.design.decorator;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.decorator
 * Company: com.yinhai
 * date 2021/1/24

 */
public class Main {
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA decoratorA = new ConcreteDecoratorA();
        ConcreteDecoratorB decoratorB = new ConcreteDecoratorB();

        decoratorA.setComponent(c);
        decoratorB.setComponent(decoratorA);
        decoratorB.operation();

        Map<String,String> map = new HashMap<>(8);
        map.put(null, null);
        map.put("a", null);
        map.put("b", "a");
        System.out.println(map.get(null));
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));

        System.out.println("=====================");
        map = new TreeMap<>();
//        map.put(null, null);
        map.put("a", null);
        map.put("b", "a");
        System.out.println(map.get(null));
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
    }
}
