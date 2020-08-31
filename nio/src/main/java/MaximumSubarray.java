import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumSubarray {
    private static int[] stringToIntegerArray(String input) {
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
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new MaximumSubarray().maxSubArray(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

    private int maxSubArray(int[] nums) {
        /*
         * [8,-19,5,-4,20]
         * [1,2]
         * [-1,-2]
         */
        int max = nums[0];
        int res = nums[0];
        for (int i = 0; i < nums.length; ++i) {
            if (max < 0) {
                max = nums[i];
            } else {
                max += nums[i];
            }
            res = Math.max(res, max);
        }
        return res;
    }
}