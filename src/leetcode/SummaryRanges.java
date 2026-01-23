package leetcode;

import java.util.ArrayList;
import java.util.List;

import static java.lang.IO.println;

public class SummaryRanges {

    void main() {
        println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) return result;

        int i = 0;
        while (i < nums.length) {
            int start = nums[i];
            int j = i;
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) j++;

            if (start == nums[j]) {
                result.add(String.valueOf(start));
            } else {
                result.add(start + "->" + nums[j]);
            }
            i = j + 1;
        }

        return result;
    }
}
