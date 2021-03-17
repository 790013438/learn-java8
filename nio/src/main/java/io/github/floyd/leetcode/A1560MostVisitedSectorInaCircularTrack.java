package io.github.floyd.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
 * date 2021/2/1
 * @see
2
[2,1,2,1,2,1,2,1,2]
4
[1,3,1,2]
7
[1,3,5,7]
 */
public class A1560MostVisitedSectorInaCircularTrack {
    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] radCnt = new int[n+1];
        for (int i = 0; i < rounds.length; i++) {
            while(i+1 < rounds.length && rounds[i] != rounds[i+1]) {
                radCnt[rounds[i]]++;
                rounds[i]++;
                if (rounds[i] > n) {
                    rounds[i] = 1;
                }
            }
        }
        radCnt[rounds[rounds.length-1]]++;
        int max = radCnt[0];
        for (int i = 0; i < radCnt.length; ++i) {
            if (radCnt[i] > max) {
                max = radCnt[i];
            }
        }
        System.out.println(Arrays.toString(radCnt));
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < radCnt.length; ++i) {
            if (radCnt[i] == max) {
                res.add(i);
            }
        }
        return res;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for(int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int[] rounds = stringToIntegerArray(line);

            List<Integer> ret = new A1560MostVisitedSectorInaCircularTrack().mostVisited(n, rounds);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
