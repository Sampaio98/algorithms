package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KidsWithGreatestNumberOfCandies {

    void main() {
        IO.println(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = 0;
        for (int c : candies) {
            greatest = Math.max(greatest, c);
        }

        List<Boolean> result = new ArrayList<>(candies.length);
        for (int c : candies) {
            result.add(c + extraCandies >= greatest);
        }
        return result;
    }
}
