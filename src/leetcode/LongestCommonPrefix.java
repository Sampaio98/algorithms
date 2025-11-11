package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefixV2(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"a"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        var firstWord = strs[0];
        var length = firstWord.length();
        var prefix = "";

        for (int i = 0; i < length; i++) {
            String subSequence = (String) firstWord.subSequence(0, i + 1);
            if (!Arrays.stream(strs).allMatch(s -> s.startsWith(subSequence))) {
                return prefix;
            } else {
                prefix = subSequence;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefixV2(String[] strs) {
        var prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - i);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

}
