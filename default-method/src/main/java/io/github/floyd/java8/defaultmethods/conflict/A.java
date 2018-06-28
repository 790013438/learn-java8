package io.github.floyd.java8.defaultmethods.conflict;

public interface A {

    default void sayHello() {
        System.out.println("你好，我是 Java 8");
    }
}
