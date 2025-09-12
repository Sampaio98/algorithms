package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum2 {

    public static void main(String[] args) {
//        var result = twoSum(new int[]{2, 7, 11, 15}, 9);
        var result = twoSumV1(new int[]{2, 3, 4}, 6);
        System.out.println(Arrays.toString(result));
    }

    private static int[] twoSumV1(int[] numbers, int target) {
        var l = 0;
        var r = 1;
        var length = numbers.length - 1;

        while (l < length) {
            if (numbers[l] + numbers[r] == target) {
                l++;
                r++;
                break;
            } else {
                r++;
            }
            if (r == numbers.length) {
                l++;
                r = 1 + l;
            }
        }
        return new int[]{l, r};
    }

    private static int[] twoSumV2(int[] numbers, int target) {
        var l = 0;
        var r = numbers.length - 1;

        while (l < r) {
            var sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }

    private static int[] twoSumV3(int[] numbers, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            var aux = target - numbers[i];
            if (map.containsKey(aux)) {
                return new int[]{map.get(aux), i};
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }
}
