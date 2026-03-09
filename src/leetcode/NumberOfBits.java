package leetcode;

public class NumberOfBits {

    void main() {
        IO.println(hammingWeight(11));
        IO.println(hammingWeight(128));
        IO.println(hammingWeight(2147483645));
    }

    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                res += 1;
            }
        }
        return res;
    }
}
