package leetcode.kotlin

class RemoveElement {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(removeDuplicates(intArrayOf(1, 1, 2)))
//            println(removeElement(intArrayOf(3, 2, 2, 3), 3))
//            println(removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
//            println(removeElement(intArrayOf(1), 1))
//            println(removeElement(intArrayOf(3, 3), 3))
            println(removeElement(intArrayOf(4, 5), 4))
        }

        fun removeElement(nums: IntArray, `val`: Int): Int {
            if (nums.size < 1 || nums.size == 1 && nums[0] == `val`) {
                return 0
            }
            var l = 0
            var r = nums.size - 1

            while (l < r) {
                if (nums[l] == `val`) {
                    if (nums[r] != `val`) {
                        val tmp = nums[l]
                        nums[l] = nums[r]
                        nums[r] = tmp
                        l++
                    }
                    r--
                } else {
                    l++
                }
            }
            return l + (if (nums[l] == `val`) 0 else 1)
        }
    }
}