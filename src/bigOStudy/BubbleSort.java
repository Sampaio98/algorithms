package bigOStudy;

import java.util.Arrays;

public class BubbleSort {

    void main() {
        var bubbleSort = new BubbleSort();
        bubbleSort.sort(new int[]{5, 4, 3, 2, 1});
        bubbleSort.sort(new int[]{1, 2, 3, 4, 5});
        bubbleSort.sort(new int[]{1, 2, 3, 5, 4});
    }


    public void sort(int[] nums) {
        for (int x : nums) {
            var isSorted = true;
            System.out.println(Arrays.toString(nums));
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    isSorted = false;
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
            if (isSorted) return;
        }
    }
}
