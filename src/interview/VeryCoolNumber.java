package interview;

import java.util.Scanner;

public class VeryCoolNumber {
    /*
        INPUT EXAMPLES
        21 2
        102 1
    */

    void main() {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int occurrences = sc.nextInt();
        int result = 0;

        for (int i = 1; i <= number; i++) {
            String binary = Integer.toBinaryString(i);

            if (countPattern(binary) >= occurrences) {
                result++;
            }
        }

        System.out.println(result);
        sc.close();
    }

    public static int countPattern(String binary) {
        int count = 0;

        for (int i = 0; i <= binary.length() - 3; i++) {
            if (binary.startsWith("101", i)) {
                count++;
            }
        }

        return count;
    }
}
