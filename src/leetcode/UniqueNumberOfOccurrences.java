package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    void main() {
        IO.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        // IO.println(uniqueOccurrences(new int[]{1, 2}));

    }

    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == map.size();
    }
}
