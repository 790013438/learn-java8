package io.github.floyd.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
 * date 2020/12/10

 */
public class A860 {
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] bills = stringToIntegerArray(line);

            boolean ret = new A860().lemonadeChange(bills);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }

    public boolean lemonadeChange(int[] bills) {
        int d5 = 0, d10 = 0, d20 = 0;
        for (int i : bills) {
            if (i > 5) {
                int zL = i - 5;
                switch (zL) {
                    case 5:
                    if (d5 > 0) {
                        d5--;
                    } else {
                        return false;
                    }
                    break;
                    case 15:
                    if (d5 > 0 && d10 > 0) {
                        d5--;
                        d10--;
                    } else if (d5 > 3) {
                        d5 -= 3;
                    } else {
                        return false;
                    }
                    default:
                }
            }
            switch (i) {
                case 5:
                    d5++;
                    break;
                case 10:
                    d10++;
                    break;
                case 20:
                    d20++;
                    break;
                default:
            }
        }
        return true;
    }
}
// [5,5,5,10,20]
