package bigOStudy;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] c = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] d = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
//        int[] failInput = {1, 3, 5, 7, 9}; // expected 7
//        int[] failInput = {10, 20, 30, 40, 50};  // expected 10
        binarySearch(a, 3);
    }

    public static void binarySearch(int[] nums, int expected) {
        int l = 0;
        int r = nums.length - 1;
        int steps = 0;
        boolean found = false;

        while (l <= r) {
            steps++;
            int mid = (l + r) / 2;

            if (nums[mid] == expected) {
                found = true;
                break;
            } else if (nums[mid] > expected) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println("achou: " + found + "\nsteps: " + steps);
    }
}
