package leetcode;

import java.util.Arrays;

public class LongestConsecutive {

    public static void main(String[] args) {
//        System.out.println(longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
//        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{1, 0, 1, 2}));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        var max = 1;
        var aux = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] - nums[i - 1] == 1) {
                aux++;
            } else {
                aux = 1;
            }
            max = Math.max(max, aux);
        }
        return max;
    }
}
