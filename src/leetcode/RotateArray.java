package leetcode;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        var test1 = rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(Arrays.toString(test1));
    }

    private static int[] rotate(int[] nums, int k) {
        var length = nums.length - 1;
        reverse(nums, 0, length);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length);
        return nums;
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            var temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            r--;
            l++;
        }
    }
}
