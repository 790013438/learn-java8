package io.github.floyd.java8.stream.demo;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 斐波拉西序列
 * <p>
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55...
 * 菲波拉西元组序列与此类似，是数列中数字和其后续数字组成的元组构成的序列；
 * {0, 1}, {1, 1}, {1, 2}, {2, 3}, {3, 5}, {5, 8}, {8, 13}, {13, 21}
 * 你的任务是用iterate方法生成菲波纳契元组序列中的前20个元素。
 */
public class IterateStream {

    public static void main(String[] args) {
        List<Item> itemList = Stream.iterate(new Item(0, 1), n -> {
            Item i = new Item(0, 0);
            i.setFirst(n.getSecond());
            i.setSecond(n.getFirst() + n.getSecond());
            return i;
        })
                .limit(20)
                .collect(Collectors.toList());
        System.out.println(itemList);
    }

    @AllArgsConstructor
    static class Item {
        private int first;
        private int second;

        void setFirst(int first) {
            this.first = first;
        }

        void setSecond(int second) {
            this.second = second;
        }

        int getFirst() {
            return first;
        }

        int getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return "{" + first + ", " + second + "}";
        }
    }
}
