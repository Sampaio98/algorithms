package leetcode;

import java.util.HashMap;

public class RansomNote {

    public static void main(String[] args) {
        var canConstruct = canConstruct("aa", "ab");
        System.out.println(canConstruct);
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        var m = magazine.toCharArray();
        var r = ransomNote.toCharArray();
        var map = new HashMap<Character, Integer>();
        var countMatch = 0;

        for (Character c : m) {
            var contains = map.containsKey(c);
            if (contains) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < r.length; i++) {
            var contains = map.get(r[i]);
            if (contains != null && contains != 0) {
                countMatch++;
                map.put(r[i], contains - 1);
            }
        }

        return countMatch == r.length;
    }
}
