package leetcode;

import java.util.HashSet;

public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(isHappyV2(19));
    }

    public static boolean isHappy(int n) {
        var seen = new HashSet<Integer>();
        while(!seen.contains(n)) {
            seen.add(n);
            var array = String.valueOf(n).split("");
            n = 0;
            for (String s : array) {
                n += (int) Math.pow(Integer.parseInt(s), 2);
            }
            if(n == 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHappyV2(int n) {
        var seen = new HashSet<Integer>();
        while(n != 1 && !seen.contains(n)) {
            seen.add(n);
            var sum = 0;
            while (n > 0) {
                var digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}
