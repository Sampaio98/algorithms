package leetcode.kotlin

class RemoveDuplicates {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(removeDuplicates(intArrayOf(1, 1, 2)))
            println(removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)))
        }

        fun removeDuplicates(nums: IntArray): Int {
            var k = 1
            var count = 1

            for (i in 1 until nums.size) {
                if (nums[i] == nums[i - 1]) {
                    count++
                } else {
                    count = 1
                }

                if (count <= 1) {
                    nums[k] = nums[i]
                    k++
                }
            }
            return k;
        }
    }
}