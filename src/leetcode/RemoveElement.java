package leetcode;

public class RemoveElement {

    public static void main(String[] args) {
//        var test1 = removeElement(new int[]{3, 2, 2, 3}, 3);
//        var test2 = removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        var test3 = removeElement(new int[]{1}, 1);
//        var test4 = removeElement(new int[]{2}, 3);
//        var test5 = removeElement(new int[]{}, 0);
//        System.out.println(test1); // Expected: 2
//        System.out.println(test2); // Expected: 5
        System.out.println(test3); // Expected: 1
//        System.out.println(test4); // Expected: 2
//        System.out.println(test5); // Expected: ?
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length < 1 || nums.length == 1 && nums[0] == val) {
            return 0;
        }
        int aux = 0;
        int lastIndex = nums.length - 1;
        while (aux < lastIndex) {
            if (nums[aux] == val) {
                if (nums[lastIndex] == val) {
                    lastIndex--;
                } else {
                    int num = nums[aux];
                    nums[aux] = nums[lastIndex];
                    nums[lastIndex] = num;
                    aux++;
                    lastIndex--;
                }
            } else {
                aux++;
            }
        }
        return aux + (nums[aux] == val ? 0 : 1);
    }

}
