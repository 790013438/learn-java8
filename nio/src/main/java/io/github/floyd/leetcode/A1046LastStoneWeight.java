package io.github.floyd.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName io.github.floyd.leetcode
 * Company: com.yinhai
 * date 2021/1/4

 */
public class A1046LastStoneWeight {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] stones = stringToIntegerArray(line);

            int ret = new A1046LastStoneWeight().lastStoneWeight(stones);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int last = stones.length - 1;
        int res = stones[last];
        for (int i = last - 1; i >= 0; i--) {
            res = Math.abs(stones[i + 1] - stones[i]);
            stones[i] = res;
            Arrays.sort(stones);
        }
        return res;
    }
}
