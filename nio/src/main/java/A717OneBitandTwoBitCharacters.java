import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A717OneBitandTwoBitCharacters {
    private boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for (; i < bits.length;) {
            if (bits[i] == 1) {
                i +=2;
            } else if (bits[i] == 0 && i == bits.length - 1) {
                return true;
            }
        }
        return false;
    }

    private static int[] stringToIntegerArray(String input) {
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
    
    private static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] bits = stringToIntegerArray(line);
            
            boolean ret = new A717OneBitandTwoBitCharacters().isOneBitCharacter(bits);
            
            String out = booleanToString(ret);
            
            System.out.print(out);
        }
    }
}