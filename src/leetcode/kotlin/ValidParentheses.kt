package leetcode.kotlin

import java.util.*

class ValidParentheses {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(isValid("([])"))
        }

        fun isValid(s: String): Boolean {
            if (s.length % 2 != 0) return false
            val map = mutableMapOf(
                '}' to '{',
                ')' to '(',
                ']' to '['
            )
            val brackets = LinkedList<Char>()
            for (i in 0..<s.length) {
                if (map.containsValue(s[i])) {
                    brackets.add(s[i])
                } else {
                    if (!brackets.isEmpty() && brackets.pollLast() != map[s[i]]) {
                        return false
                    } else if (brackets.isEmpty()) {
                        return false
                    }
                }
            }
            return brackets.isEmpty()
        }
    }
}