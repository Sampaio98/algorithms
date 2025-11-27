package leetcode.kotlin

class JumpGame {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(canJump(intArrayOf(2, 3, 1, 1, 4)))
        }

        fun canJump(nums: IntArray): Boolean {
            val n = nums.size - 1
            var target = n - 1

            for (i in n downTo 0) {
                if (i + nums[i] >= target) {
                    target = i
                }
            }

            return target == 0
        }
    }
}