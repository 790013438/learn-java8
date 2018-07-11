package io.github.floyd.java8.stream.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 2
 * <p>
 * 2.1 给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
 * 例如，给定[1, 2, 3, 4, 5], 应该返回[1, 4, 9, 16, 25]
 * <p>
 * 2.2 给定两个数字列表，如何返回所有的数对呢？例如，给定列表{1, 2, 3}和列表{3, 4},
 * 应该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)].
 * 为简单起见，你可以用两个元素的数组来代表对。
 * <p>
 * 2.3 如何扩展前一个例子，只返回总和能被3整除的数呢？例如(2, 4)和(3, 3)是可以的
 * @author fork from biezhi,floyd
 * @date 2018/7/11
 */
public class Square {

    private static void q1() {
        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5);
        number.stream()
            .map(i -> i * i)
            .forEach(System.out::println);
    }

    private static void q2() {
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);
        List<Integer[]> list = number1.stream()
            .flatMap(i -> {
                return number2.stream()
                    .map(j -> {
                        return new Integer[]{i, j};
                    });
            })
        .collect(Collectors.toList());
        list.stream()
                .map(Arrays::toString)
                .forEach(System.out::println);
    }

    private static void q2FlatMap() {
        List<Integer> number1 = Arrays.asList(1, 2, 3);
        List<Integer> number2 = Arrays.asList(3, 4);

        List<int[]> pairs = number1.stream()
            .flatMap(i ->
                    number2.stream()
                    .map(j -> new int[]{i, j}))
            .collect(Collectors.toList());

        pairs.stream()
                .map(Arrays::toString)
                .forEach(System.out::print);
    }

    public static void main(String[] args) {
        q1();
        q2();
        q2FlatMap();
    }

}
