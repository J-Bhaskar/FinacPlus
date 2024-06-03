

/* Write a special cipher that is a combination of Caesar’s cipher followed by a simple
RLE. The function should receive a string and the rotation number as parameters.
Input: special Cipher(“AABCCC”, 3) Output: D2EF3 */

import java.util.*;

public class Cipher {

    private static String caesarCipher(String input, int shift) {
        StringBuilder result = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shift) % 26 + base));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    private static String runLengthEncode(String input) {
        StringBuilder result = new StringBuilder();
        int n = input.length();
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (i + 1 < n && input.charAt(i) == input.charAt(i + 1)) {
                i++;
                count++;
            }
            result.append(input.charAt(i));
            if (count > 1) {
                result.append(count);
            }
        }
        return result.toString();
    }

    public static String specialCipher(String input, int shift) {

        String caesarResult = caesarCipher(input, shift);
        return runLengthEncode(caesarResult);
    }

    public static void main(String[] args) {
       /*  Scanner sc=new Scanner(System.in);   // for inputs by user
        String input=sc.next(); */
        String str = "AABCCC";
        int shift = 3;
        String result = specialCipher(str, shift);
        System.out.println(result);  // Sample Output: D2EF3
    }
}