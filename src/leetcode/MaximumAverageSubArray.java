package leetcode;

public class MaximumAverageSubArray {

    void main() {
        IO.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        IO.println(findMaxAverage(new int[]{5}, 1));
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k]; // remove first
            sum += nums[i]; // sum with current
            maxSum = Math.max(sum, maxSum);
        }
        return (double) maxSum / k;
    }
}
