package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifferenceTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int i : nums1) s1.add(i);
        for (int i : nums2) {
            s2.add(i);
            s1.remove(i);
        }
        for (int i : nums1) {
            s2.remove(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(s1));
        res.add(new ArrayList<>(s2));
        return res;
    }

}
