package leetcode.kotlin

class Fibonacci {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(fibOptimized(13))
        }

        fun fib(n: Int): Int {
            if (n == 0) return 0
            if (n == 1 || n == 2) return 1
            return fib(n - 1) + fib(n - 2)
        }

        fun fibOptimized(n: Int): Int {
            if (n == 0) return 0
            if (n == 1 || n == 2) return 1
            var prev = 0
            var curr = 1
            var i = 1
            while (i < n) {
                val aux = prev + curr
                prev = curr
                curr = aux
                i++
            }
            return curr
        }
    }
}