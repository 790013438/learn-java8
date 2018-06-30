package io.github.floyd.java8.defaultmethods.conflict;

public class App2 implements A, B, C {

    public static void main (String[] args) {
        new App2().sayHello();
    }
}
