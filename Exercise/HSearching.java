import java.util.*;
public class Searching {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Text:");
        String text1 = scan.nextLine();
        System.out.println("Enter the Pattern:");
        String pattern1 = scan.nextLine();
        System.out.println("After Searching of the pattern in text:");
        System.out.println(text1); // Print original text once
        int result = Horspool(text1, pattern1);
        if (result == -1) {
            System.out.println("Sorry, Pattern is not found in the text");
        } else {
            System.out.println("Pattern is found at " + result + " Position in text");
        }
    }
    public static int Horspool(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] table = ShiftTable(pattern);
        int i = m - 1;
        while (i <= n - 1) {
            int currentStart = i - m + 1;
            for (int s = 0; s < currentStart; s++) System.out.print(" ");
            System.out.println(pattern);
            int k = 0;
            while (k < m && pattern.charAt(m - 1 - k) == text.charAt(i - k)) {
                k = k + 1;
            }
            if (k == m) {
                return i - m + 1;
            } else {
                i = i + table[text.charAt(i)];
            }
        }
        return -1;
    }
    public static int[] ShiftTable(String pattern) {
        int m = pattern.length();
        int[] table = new int[256];
        for (int i = 0; i < 256; i++) {
            table[i] = m;
        }
        for (int j = 0; j < m - 1; j++) {
            table[pattern.charAt(j)] = m - 1 - j;
        }
        return table;
    }
}
