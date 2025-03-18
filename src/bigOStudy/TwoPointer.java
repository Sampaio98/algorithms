package bigOStudy;

import java.util.Arrays;

public class TwoPointer {

    public static void main(String[] args) {
        reverseNumbers(new int[]{1, 2, 3, 4, 5});
        reverseString("Hello World");
    }

    public static void reverseNumbers(int[] array) {
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
            r--;
            l++;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void reverseString(String word) {
        String[] words = word.split(" ");
        StringBuilder result = new StringBuilder();

        for (String s : words) {
            char[] chars = s.toCharArray();
            int l = 0;
            int r = chars.length - 1;

            while (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }

            String reverseWord = new String(chars);
            result.append(reverseWord).append(" ");
        }

        System.out.println(result.toString().trim());
    }

}
