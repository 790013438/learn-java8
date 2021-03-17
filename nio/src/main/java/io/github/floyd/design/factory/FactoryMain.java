package io.github.floyd.design.factory;

import io.github.floyd.design.simpleFactory.Operation;

import java.util.PriorityQueue;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.design.factory
 * Company: com.yinhai
 * date 2021/2/5
 * @see *#
 */
public class FactoryMain {
    public static void main(String[] args) {
        Factory operFactory = new AddFactory();
        Operation operation = operFactory.createOperation();
        operation.setNumberA(1);
        operation.setNumberB(2);
        System.out.println(operation.getResult());

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(16);
        for (int i = 23; i >= 0; --i) {
            priorityQueue.add(new String(new char[]{(char)('a'-i)}));
        }
        for (int i = 23; i >= 0; --i) {
            priorityQueue.add(new String(new char[]{(char)('a'-i)}));
        }
        for (int i = 23; i >= 0; --i) {
            priorityQueue.add(new String(new char[]{(char)('a'-i)}));
        }
        for (int i = 23; i >= 0; --i) {
            priorityQueue.add(new String(new char[]{(char)('a'-i)}));
        }
        for (int i = 23; i >= 0; --i) {
            priorityQueue.add(new String(new char[]{(char)('a'-i)}));
        }
        System.out.println(System.currentTimeMillis());
        for (int i = 0; i < 10; ++i) {
            System.out.println(priorityQueue.remove());
        }
        System.out.println(System.currentTimeMillis());

        String a = "123" + new String("456");
        System.out.println(a);
    }
}
