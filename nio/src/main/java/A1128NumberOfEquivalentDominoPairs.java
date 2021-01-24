import com.alibaba.fastjson.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

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
 * date 2020/9/28

 */
public class A1128NumberOfEquivalentDominoPairs {
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

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
//            int[][] dominoes = stringToInt2dArray(line);

//            int ret = new A1128NumberOfEquivalentDominoPairs().numEquivDominoPairs(dominoes);
//
//            String out = String.valueOf(ret);
//            System.out.print(out);

            Calendar a = Calendar.getInstance();
            a.set(Calendar.MONTH, 8);
            System.out.println(a.get(Calendar.YEAR));
            System.out.println(a.get(Calendar.MONTH));
            System.out.println(a.get(Calendar.DAY_OF_MONTH));
            System.out.println(a.getTime());
        }
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] map = new int[10][10];
        int res = 0;
        for (int i = 0; i < dominoes.length; ++i) {
            if (map[dominoes[i][0]][dominoes[i][1]] > 0) {
                res += map[dominoes[i][0]][dominoes[i][1]];
            }
            map[dominoes[i][0]][dominoes[i][1]]++;
            if (map[dominoes[i][1]][dominoes[i][0]] > 0) {
                res += map[dominoes[i][1]][dominoes[i][0]];
            }
        }

        return res;
    }
}
