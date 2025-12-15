package leetcode;

import java.util.HashMap;

public class MaximumLengthSubstring {

    public static void main(String[] args) {
        System.out.println(maximumLengthSubstring("bcbbbcba"));
    }

    public static int maximumLengthSubstring(String s) {
        int r = 0, l = 0;
        var max = 1;
        var map = new HashMap<Character, Integer>();
        map.put(s.charAt(0), 1);

        while (r < s.length() - 1) {
            r++;
            if (map.containsKey(s.charAt(r))) {
                map.put(s.charAt(r), map.get(s.charAt(r)) + 1);
            } else {
                map.put(s.charAt(r), 1);
            }

            while (map.get(s.charAt(r)) == 3) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
