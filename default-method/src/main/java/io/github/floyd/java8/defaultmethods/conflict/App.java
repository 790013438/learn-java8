package io.github.floyd.java8.defaultmethods.conflict;

public class App implements A {

    @Override
    public void sayHello() {
        System.out.println("你好，我是 App");
    }

    public static void main(String[] args) {
        new App().sayHello();
    }
}
