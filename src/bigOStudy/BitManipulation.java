package bigOStudy;

public class BitManipulation {

    void main() {
        //XOR
        IO.println(missingNumber(new int[]{3, 0, 1}));
        IO.println(missingNumber(new int[]{4, 0, 5, 3, 1, 2}));
        IO.println(missingNumber(new int[]{0, 2, 3, 4}));

        IO.println("=============================================================================");

        // SHIFT, AND
        IO.println(numberOfSteps(14)); // 6
        IO.println(numberOfSteps(8)); // 4
        IO.println(numberOfSteps(123)); // 12
    }

    public int missingNumber(int[] nums) {
        var xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        for (int i = 0; i < nums.length + 1; i++) {
            xor ^= i;
        }
        return xor;
    }

    public int numberOfSteps(int num) {
        var steps = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                num--;
            } else {
                num >>= 1;
            }
            steps++;
        }
        return steps;
    }
}
