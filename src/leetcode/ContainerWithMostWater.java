package leetcode;

public class ContainerWithMostWater {

    public static void main(String[] args) {
//        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
//        System.out.println(maxArea(new int[]{1, 1}));
//        System.out.println(maxArea(new int[]{1, 2}));
        System.out.println(maxArea(new int[]{8, 7, 2, 1}));
    }

    public static int maxArea(int[] height) {
        var l = 0;
        var r = height.length - 1;
        var max = 0;

        while (l < r) {
            var left = height[l];
            var right = height[r];
            var aux = 0;

            if (left > right) {
                aux = (left - (left - right)) * (r - l);
                r--;
            } else if (left == right) {
                aux = left * (r - l);
                l++;
                r--;
            } else {
                aux = (right - (right - left)) * (r - l);
                l++;
            }
            if (aux > max) {
                max = aux;
            }
        }

        return max;
    }
}
