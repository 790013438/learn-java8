import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortArrayByParityII {
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

            int[] ret = new SortArrayByParityII().sortArrayByParityII(A);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }

    public int[] sortArrayByParityII(int[] A) {
// 排好偶数，奇数就排好了
        int even = 0;
        for (int i = 1; i < A.length; ++i) {
            while (even < A.length && A[even] % 2 == 0) {
                even += 2;
            }
            if (even < A.length && i % 2 != 0 && A[i] % 2 == 0 && A[even] % 2 != 0) {
                int temp = A[i];
                A[i] = A[even];
                A[even] = temp;
                even += 2;
            }
        }
        return A;
    }

    public int[] f(int[] A) {
        int j = 1;

        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 != 0) {
                while (A[j] % 2 != 0) {
                    j += 2;
                }
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }

        return A;
    }
}
