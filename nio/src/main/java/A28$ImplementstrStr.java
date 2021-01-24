import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 此类的主要功能是： <br/>
 * 1. 处理<br/>
 * 此类提供的主要方法有：<br/>
 * 1. mississippiissipis issipi
 * mississippi sippia
 *
 * @author chengmiao
 * @version 1.0
 * ClassName PACKAGE_NAME
 * Company: com.yinhai
 * date 2020/6/16

 */
public class A28$ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int fromLength = haystack.length();
        int needleLength =needle.length();
        if (haystack.equals(needle) || needleLength == 0) {
            return 0;
        }
        if (fromLength < needleLength) {
            return -1;
        }
        char[] from = haystack.toCharArray();
        char[] target = needle.toCharArray();
        int max = fromLength - needleLength + 1;
        for (int i = 0; i < max; ++i) {
            while (i < fromLength && from[i] != target[0]) {
                i++;
            }
            if (i <= max) {
                int hi = i;
                int end = i + needleLength - 1;
                int k = 0;
                while( hi + 1 <= end && k + 1 < needleLength && from[hi + 1] == target[k + 1]) {
                    ++k;
                    ++hi;
                }
                if (hi < fromLength && hi == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String haystack = args[0];
            String needle = args[1];

            int ret = new A28$ImplementstrStr().strStr(haystack, needle);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
