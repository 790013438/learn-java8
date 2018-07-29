package io.github.floyd.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

/**
 * (1) 找出2011年发生的所有交易，并按照交易排序（从低到高）。
 * (2) 交易员都在那些不同的城市工作过？
 * (3) 查找所有来自剑桥的交易员，并按姓名排序。
 * (4) 返回所有交易员的姓名字符串，按字母顺序排序。
 * (5) 有没有交易员实在米兰工作的？
 * (6) 打印生活在剑桥的交易员的所有交易额。
 * (7) 所有交易中，最高的交易额是多少？
 * (8) 找到交易额最小的交易。
 *
 * @author floyd
 */
public class Filter {

    // 交易额
    @Data
    @AllArgsConstructor
    private static class Trader {
        // 姓名
        private String name;
        // 城市
        private String city;
    }

    // 交易
    @Data
    @AllArgsConstructor
    private static class Transaction {
        private Trader trader;
        //       交易年份
        private int year;
        //       交易额
        private int value;
    }

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transaction = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // (1) 找出2011年发生的所有交易，并按照交易排序（从低到高）。
        transaction.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        // (2) 交易员都在那些不同的城市工作过？
        transaction.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);
        System.out.println("========================================");

        // (3) 查找所有来自剑桥的交易员，并按姓名排序。
        transaction.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getTrader)
                .distinct()
                // 逆向排序
                .sorted(Comparator.comparing(Trader::getName).reversed())
                .forEach(System.out::println);
        System.out.println("========================================");

        // (4) 返回所有交易员的姓名字符串，按字母顺序排序。
        transaction.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(t -> t.getTrader().getName())
                .distinct()
                // 逆向排序
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
        System.out.println("========================================");

        // (5) 有没有交易员实在米兰工作的？
        System.out.println("有交易员生活在米兰吗");
        System.out.println(transaction.stream()
                .anyMatch(t -> "Milan".equals(t.getTrader().getCity())));
        System.out.println("========================================");

        // (6) 打印生活在剑桥的交易员的所有交易额。
        transaction.stream()
                .filter(t -> "Cambridge".equals(t.getTrader().getCity()))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        System.out.println("========================================");

        // (7) 所有交易中，最高的交易额是多少？
        OptionalInt optMax = transaction.stream()
                .mapToInt(Transaction::getValue)
                .max();

        System.out.println(optMax.orElse(Integer.MIN_VALUE));
        System.out.println("========================================");

        // (8) 找到交易额最小的交易。
        OptionalInt optMin = transaction.stream()
            .mapToInt(Transaction::getValue)
            .min();
        System.out.println(optMin.orElse(Integer.MIN_VALUE));
    }

}
