package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom {

    static class RandomizedSet {
        final HashMap<Integer, Integer> map;
        final ArrayList<Integer> list;
        final Random random;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            Integer index = map.get(val);
            if (index == null) return false;
            int lastElement = list.getLast();
            list.set(index, lastElement);
            map.put(lastElement, index);
            list.removeLast();
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(0, list.size()));
        }
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

