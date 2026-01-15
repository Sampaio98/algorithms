package leetcode;

import java.util.Arrays;

public class MergeSortedArray {

    static void main() {
        var test1 = merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        var test2 = merge(new int[]{0}, 0, new int[]{1}, 1);
        var test3 = merge(new int[]{1}, 1, new int[]{}, 0);
        var test4 = merge(new int[]{0}, 0, new int[]{1}, 1);
        var test5 = merge(new int[]{2, 0}, 1, new int[]{1}, 1);
        var test6 = merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
        System.out.println(Arrays.toString(test4));
        System.out.println(Arrays.toString(test5));
        System.out.println(Arrays.toString(test6));
    }


    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        var mIndex = m - 1;
        var nIndex = n - 1;
        var lastIndex = m + n - 1;

        while (mIndex >= 0 && nIndex >= 0) {
            if (nums1[mIndex] > nums2[nIndex]) {
                nums1[lastIndex] = nums1[mIndex];
                mIndex--;
            } else {
                nums1[lastIndex] = nums2[nIndex];
                nIndex--;
            }
            lastIndex--;
        }

        while (nIndex >= 0) {
            nums1[lastIndex] = nums2[nIndex];
            nIndex--;
            lastIndex--;
        }

        return nums1;
    }

    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return new int[]{};
        int totalLen = m + n;
        int p1 = totalLen - 1;
        n = n - 1;

        for (int i = m; i < totalLen; i++) {
            nums1[p1] = nums2[n];
            p1--;
            n--;
        }

        Arrays.sort(nums1);
        return nums1;
    }

}
