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
 * date 2020/11/1
 */
public class A1252CellsWithOddValuesInaMatrix {
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
        List jsonArray = JSONArray.parseArray(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            List cols = (List) jsonArray.get(i);
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);
            line = in.readLine();
            int m = Integer.parseInt(line);
            line = in.readLine();
            int[][] indices = stringToInt2dArray(line);

            int ret = new A1252CellsWithOddValuesInaMatrix().oddCells(n, m, indices);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    public int oddCells(int n, int m, int[][] indices) {
        int[][] count = new int[n][m];

        int[] rows = new int[n];
        int[] columns = new int[m];
        for (int[] indice : indices) {
            int row = indice[0];
            int col = indice[1];
            rows[row] = (rows[row] == 0) ? 1 : 0;
            columns[col] = (columns[col] == 0) ? 1 : 0;
        }

        int needUpdateRow = 0;
        for (int num : rows) {
            if (num > 0) {
                needUpdateRow++;
            }
        }

        int needUpdateCol = 0;
        for (int num : columns) {
            if (num > 0) {
                needUpdateCol++;
            }
        }

        return needUpdateRow * (m - needUpdateCol) + needUpdateCol * (n - needUpdateRow);
    }
}
