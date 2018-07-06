package io.github.floyd.java8.lambda.demo;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class Reference {

    public static void main(String[] args) {
        Function<Integer, String[]> fun = x -> new String[x];
        String[] strs = fun.apply(10);
        System.out.println(strs.length);

        Function<Integer, String[]> fun1 = String[]::new;
        strs = fun1.apply(20);
        System.out.println(strs.length);

        Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
        Function<String, Integer> stringToInteger1 = Integer::parseInt;
        //Function<String, Integer> stringToInteger1 = (String s) -> parseInt::Integer;

        BiPredicate<List<String>, String> contains = (list, element) -> list.contains(element);
        BiPredicate<List<String>, String> contains1 = List::contains;
        //BiPredicate<List<String>, String> contains1 = (list, element) -> contains::list;
    }
}
