import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseWordsInaStringIII {
    public String reverseWords(String s) {
        char[] a = s.toCharArray();
        for (int i = 0; i < a.length; ++i) {
            int j = i;
            while(j < a.length && a[j] != ' ') {
                j++;
            }
            int space = j;
            while (i <= j && a[i] != ' ') {
                if (j == a.length || a[j] == ' ') {
                    j--;
                    continue;
                }
                char temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
            i = space;
        }
        return new String(a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = line;

            String ret = new ReverseWordsInaStringIII().reverseWords(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}
