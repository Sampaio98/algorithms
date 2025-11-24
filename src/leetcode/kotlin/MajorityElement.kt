package leetcode.kotlin

class MajorityElement {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(majorityElement(intArrayOf(3, 3, 4)))
//            println(majorityElement(intArrayOf(6, 6, 6, 7, 7)))
            println(majorityElement(intArrayOf(6, 5, 5)))
        }

        fun majorityElement(nums: IntArray): Int {
            var k = nums[0]
            var count = 1

            for ((index, num) in nums.withIndex()) {
                if (index == 0) continue

                if(num == k) {
                    count ++
                } else {
                    count--
                }

                if(count == 0) {
                    k = num
                }
            }

            return k
        }
    }
}
