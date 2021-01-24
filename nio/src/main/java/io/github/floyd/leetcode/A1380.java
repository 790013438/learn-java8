package io.github.floyd.leetcode;

import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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
 * date 2020/12/3

 */
public class A1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        Map<Integer, Integer> minRow = new HashMap<Integer, Integer>(matrix.length);
        Map<Integer, Integer> maxCol = new HashMap<Integer, Integer>(matrix[0].length);
        List<Integer> res = new LinkedList();
        for (int i = 0; i < matrix.length; ++i) {
            int min = matrix[i][0];
            for (int j : matrix[i]) {
                min = Math.min(j, min);
            }
            minRow.put(min, i);
        }

        for (int j = 0; j < matrix[0].length; ++j) {
            int max = matrix[0][j];
            for (int i = 0; i < matrix.length; ++i) {
                max = Math.max(max, matrix[i][j]);
                maxCol.put(max, i);
            }
            if (minRow.get(max).equals(maxCol.get(max))) {
                res.add(max);
            }
        }
        //  [[7,8],[1,2]]
        int[] row = new int[matrix.length];
        int[] column = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            int min = matrix[i][0];
            for (int iRow : matrix[i]) {
                min = Math.min(iRow, min);
            }
            row[i] = min;
        }
        for (int j = 0; j < matrix[0].length; ++j) {
            int max = matrix[0][j];
            for (int i = 0; i < matrix.length; ++i) {
                max = Math.min(matrix[i][j], max);
            }
            row[j] = max;
            if (row[j] == column[j]) {

            }
        }
        /**
         *
         a1, a2
         b1, b2
         c1, c2
         */

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

    public static int[][] stringToInt2dArray(String input) {
        JSONArray jsonArray = JSONArray.parseArray(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JSONArray cols = (JSONArray) jsonArray.get(i);
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
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
            int[][] matrix = stringToInt2dArray(line);

            List<Integer> ret = new A1380().luckyNumbers (matrix);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
