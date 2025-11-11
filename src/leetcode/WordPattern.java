package leetcode;

import java.util.HashMap;

public class WordPattern {

    public static void main(String[] args) {
//        System.out.println(wordPattern("abba", "dog cat cat dog"));
//        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        var map = new HashMap<String, Character>();
        for (int i = 0; i < pattern.length(); i++) {
            var letter = pattern.charAt(i);
            if (map.containsValue(letter)) {
                if (!map.containsKey(words[i])) {
                    return false;
                }
            } else {
                map.put(words[i], letter);
            }
        }
        return true;
    }
}
