package leetcode;

import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));//3
//        System.out.println(romanToInt("XIV"));//14
//        System.out.println(romanToInt("CM"));//900
//        System.out.println(romanToInt("MCMXCIV"));//1994
    }

    public static int romanToInt(String s) {
        var map = Map.of('I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);
        var result = 0;
        for (int i = 0; i < s.length(); i++) {
            var letter = s.charAt(i);
            var current = map.get(letter);
            if (i + 1 < s.length()) {
                var next = map.get(s.charAt(i + 1));
                if (current < next) {
                    result -= current;
                } else {
                    result += current;
                }
            } else {
                result += current;
            }
        }
        return result;
    }
}
