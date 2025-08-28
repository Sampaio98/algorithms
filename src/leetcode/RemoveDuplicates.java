package leetcode;

public class RemoveDuplicates {

    public static void main(String[] args) {
        var test1 = removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
        System.out.println(test1);
    }

    public static int removeDuplicates(int[] nums) {
        var count = 1;
        var k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
