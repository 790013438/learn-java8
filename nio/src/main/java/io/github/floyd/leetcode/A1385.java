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
 * ClassName io.github.floyd
 * Company: com.yinhai
 * date 2020/12/1

 */
public class A1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for (int i : arr1) {
            res += count(i, arr2, d);
        }
        return res;
    }
    private int count(int i, int[] arr2, int d) {
        int left = 0, right = arr2.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (Math.abs(arr2[mid] - i) <= d) {
                return 0;
            }
            if (arr2[mid] < i) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 1;
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] arr1 = stringToIntegerArray(line);
            line = in.readLine();
            int[] arr2 = stringToIntegerArray(line);
            line = in.readLine();
            int d = Integer.parseInt(line);

            int ret = new A1385().findTheDistanceValue(arr1, arr2, d);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
