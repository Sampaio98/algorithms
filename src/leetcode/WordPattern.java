package leetcode;

import java.util.HashMap;

public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
    }

    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        var map = new HashMap<Character, String>();
        if(words.length != pattern.length()) return false;
        for (int i = 0; i < pattern.length(); i++) {
            var letter = pattern.charAt(i);
            if (map.containsKey(letter)) {
                if (!map.get(letter).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                } else {
                    map.put(letter, words[i]);
                }
            }
        }
        return true;
    }
}
