package leetcode;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class LongestConsecutive {

    public static void main(String[] args) {
        var result = longestConsecutive(new int[]{2, 20, 4, 10, 3, 4, 5});
        System.out.println(result);
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        var set = new LinkedHashSet<Integer>();
        for (int a : nums) {
            set.add(a);
        }
        System.out.println(set);
        var result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                result++;
            }
        }
        return result;
    }
}
