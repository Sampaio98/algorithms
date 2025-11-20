package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        var map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < strs.length; i++) {
            var s = strs[i];
            var sort = s.toCharArray();
            Arrays.sort(sort);
            var sorted = new String(sort);

            if (map.containsKey(sorted)) {
                map.get(sorted).add(i);
            } else {
                var list = new ArrayList<Integer>();
                list.add(i);
                map.put(sorted, list);
            }
        }
        map.forEach((word, index) -> {
            var list = new ArrayList<String>();
            for (Integer i : index) {
                list.add(strs[i]);
            }
            result.add(list);
        });
        return result;
    }

    public static List<List<String>> groupAnagramsV2(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (String s : strs) {
            var chars = s.toCharArray();
            Arrays.sort(chars);
            var sort = new String(chars);

            if (map.containsKey(sort)) {
                map.get(sort).add(s);
            } else {
                var list = new ArrayList<String>();
                list.add(s);
                map.put(sort, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> groupAnagramsV3(String[] strs) {
        var map = new HashMap<String, List<String>>();
        for (String s : strs) {
            var chars = s.toCharArray();
            Arrays.sort(chars);
            var sort = new String(chars);
            map.computeIfAbsent(sort, k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
