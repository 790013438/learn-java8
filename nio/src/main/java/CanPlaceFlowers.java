import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        for (int i = 0; i < flowerbed.length; ++i) {
            int li = Math.max(0, i - 1);
            int hi = Math.min(flowerbed.length - 1, i + 1);
            if (flowerbed[i] == 0 && flowerbed[li] == 0 && flowerbed[hi] == 0) {
                cnt++;
            }
            if (cnt == n) {
                return true;
            }
        }
        return false;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] flowerbed = stringToIntegerArray(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            boolean ret = new CanPlaceFlowers().canPlaceFlowers(flowerbed, n);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
