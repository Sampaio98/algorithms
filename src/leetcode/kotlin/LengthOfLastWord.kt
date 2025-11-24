package leetcode.kotlin

class LengthOfLastWord {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            println(lengthOfLastWord("Hello World"))
//            println(lengthOfLastWord("   fly me   to   the moon  "))
//            println(lengthOfLastWord("  "))
            println(lengthOfLastWord("a"))
//            println(lengthOfLastWord("a "))
        }

        fun lengthOfLastWord(s: String): Int {
            var l = s.length - 1
            var r = l

            while (r >= 0 && s[r] == ' ') r--
            l = r
            while (l >= 0 && s[l] != ' ') l--

            return r - l
        }
    }
}