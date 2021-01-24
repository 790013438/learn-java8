import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1.
 *
 * @author chengmiao
 * @version 1.0
 * ClassName PACKAGE_NAME
 * Company: com.yinhai
 * date 2020/9/20
 */
public class HeightChecker {
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
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            int[] heights = stringToIntegerArray(line);
//
//            int ret = new HeightChecker().heightChecker(heights);
//
//            String out = String.valueOf(ret);
//
//            System.out.print(out);
//        }
        System.out.println("202013".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202012".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202011".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202010".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202009".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202008".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202007".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202006".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202005".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202004".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202003".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202002".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d{3}"));
        System.out.println("202001".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d((1[0-2])|(0[1-9]))"));
        System.out.println("190201".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d((1[0-2])|(0[1-9]))"));
        System.out.println("191912".matches("20[0-7]\\d((1[0-2])|(0[1-9]))|19[2-9]\\d((1[0-2])|(0[1-9]))"));
        System.out.println("1919-12-32".replaceAll("\\d{2}$", "01"));
        System.out.println("1919-10-12".replaceAll("\\d{2}$", "01"));
        System.out.println("1919-09-10".replaceAll("\\d{2}$", "01"));
        System.out.println("1919-10-09".replaceAll("\\d{2}$", "01"));
        System.out.println("191902".replaceAll("(\\d{2})$", "-$1-01"));
    }

    public int heightChecker(int[] heights) {
        if (heights.length < 2) {
            return 0;
        }
        int li = 0, i = 1;
        int res = 0;
        for (; i < heights.length && li < heights.length - 1; ) {
            while (i < heights.length && heights[li] <= heights[i]) {
                i++;
            }
            while (i == heights.length && li < heights.length -1 && heights[li] <= heights[li+1]) {
                li++;
            }
            if (i == heights.length) {
                i = Math.min(li + 1, heights.length - 1);
            }

            if (heights[li] > heights[i]) {
                int temp = heights[li];
                heights[li] = heights[i];
                heights[i] = temp;
                i = li + 1;

                res++;
            }
        }
        System.out.println(Arrays.toString(heights));
        return res;
    }
}
