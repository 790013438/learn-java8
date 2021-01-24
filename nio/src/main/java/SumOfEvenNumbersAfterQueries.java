import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

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
 * date 2020/8/31

 */
public class SumOfEvenNumbersAfterQueries {
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

    public static int[][] stringToInt2dArray(String input) {
        List<List> jsonArray = JSONArray.parseArray(input, List.class);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            List cols = jsonArray.get(i);
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);
            line = in.readLine();
            int[][] queries = stringToInt2dArray(line);

            int[] ret = new SumOfEvenNumbersAfterQueries().sumEvenAfterQueries(A, queries);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int evenSum = 0;
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 0) {
                evenSum += A[i];
            }
        }
        for (int i = 0; i < queries.length; ++i) {
            int query = A[queries[i][1]];
            int temp = query + queries[i][0];
            if (temp % 2 == 0) {
                if (query % 2 == 0) {
                    evenSum += queries[i][0];
                } else {
                    evenSum += query + queries[i][0];
                }
            } else {
                evenSum -= A[queries[i][1]];
            }
            A[queries[i][1]] = temp;

            res[i] = evenSum;
        }
        return res;
    }
}
