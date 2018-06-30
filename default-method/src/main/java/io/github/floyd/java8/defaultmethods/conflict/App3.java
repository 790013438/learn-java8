package io.github.floyd.java8.defaultmethods.conflict;

public class App3 implements A, B {

    @Override
    public void sayHello() {
        System.out.println("大家好，我系古天乐，贪玩蓝月，里没有玩过的传奇。" +
                "点一下，玩一年，装备不花一分钱，只要玩过了传奇，你就是我的兄弟。");
    }

    public static void main(String[] args) {
        new App3().sayHello();
    }
}
