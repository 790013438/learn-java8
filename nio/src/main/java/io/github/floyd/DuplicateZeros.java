package io.github.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int i = 0;
        int offset = 0;
        for (; i + offset < arr.length; ++i) {
            if (arr[i] == 0) {
                offset++;
            }
        }
        i--;
        int lastIndex = arr.length - 1;

        for (; lastIndex >= 0 && i >= 0; --lastIndex) {
            arr[lastIndex] = arr[i];
            if (arr[i] == 0) {
                lastIndex--;
                arr[lastIndex] = arr[i];
            }
            i--;
        }
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

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        StringBuilder result = new StringBuilder();
        for(int index = 0; index < length; index++) {
            int number = nums[index];
            result.append(number).append(", ");
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
            int[] arr = stringToIntegerArray(line);

            new DuplicateZeros().duplicateZeros(arr);
            String out = integerArrayToString(arr);

            System.out.print(out);
        }
    }
}
