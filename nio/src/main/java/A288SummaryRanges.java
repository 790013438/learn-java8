import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
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
 * date 2020/12/30

 */
public class A288SummaryRanges {
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

    public static String stringListToString(List<String> stringList) {
        StringBuilder sb = new StringBuilder("[");
        for (String item : stringList) {
            sb.append(item);
            sb.append(",");
        }

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            List<String> ret = new A288SummaryRanges().summaryRanges(nums);

            String out = stringListToString(ret);

            System.out.print(out);

            BigDecimal a = BigDecimal.valueOf(3L);
            BigDecimal y = BigDecimal.valueOf(2);
            System.out.println(a.divide(y, BigDecimal.ROUND_DOWN));
        }
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums.length == 0) {
            return res;
        }
        StringBuilder str = new StringBuilder(16);
        for (int i = 0, j = 0; j < nums.length; ++j) {
            if (j + 1 < nums.length && nums[j] + 1 == nums[j + 1]) {
                continue;
            } else if (nums[i] != nums[j]) {
                str.append(nums[i]).append("->").append(nums[j]);
                res.add(str.toString());
                str.delete(0, str.length());
            } else if (nums[i] == nums[j]){
                str.append(nums[i]);
                res.add(str.toString());
                str.delete(0, str.length());
            }
            i = j + 1;
        }
        return res;
    }
}
