package leetcode;

public class CanPlaceFlowers {

    void main() {
        IO.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        IO.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        IO.println(canPlaceFlowers(new int[]{1, 0, 0, 0, 0, 0, 1}, 2));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        var count = 0;
        var zeros = 1;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                zeros++;
            } else {
                count += (zeros - 1) / 2;
                zeros = 0;
            }
        }
        zeros++;
        count += (zeros - 1) / 2;
        return count >= n;
    }
}
