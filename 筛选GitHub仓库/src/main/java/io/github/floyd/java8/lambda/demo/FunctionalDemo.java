package io.github.floyd.java8.lambda.demo;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalDemo {

    /**
     * 断言，返回true或者false
     */
    private void predicate() {
        Predicate<String> nameStartingWithS = name -> name.startsWith("s");
        boolean hello = nameStartingWithS.test("hello");
        // false
        System.out.println(hello);
    }

    public static void main(String[] args) {
        FunctionalDemo functionalDemo = new FunctionalDemo();
        functionalDemo.predicate();

        functionalDemo.consumer();

        functionalDemo.function();

        functionalDemo.supplier();

        // 不会自动装箱
        IntPredicate evenNumbers = (int i) -> (i & 1) == 0;
        System.out.println(evenNumbers.test(1000));
    }

    /**
     * 消费数据
     */
    private void consumer() {
        Consumer<String> messageConsumer = System.out::println;
        messageConsumer.accept("Learn Java8");
        //"Learn Java8"
    }

    /**
     * 转换
     */
    private void function() {
        Function<String, String> toUpperCase = String::toUpperCase;
        System.out.println(toUpperCase.apply("java"));
    }

    /**
     * 提供数据
     */
    public void supplier() {
        Supplier<String> uuidGenerator = () -> UUID.randomUUID().toString();
        System.out.println(uuidGenerator.get());
    }

}
