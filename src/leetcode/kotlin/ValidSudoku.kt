package leetcode.kotlin

class ValidSudoku {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                isValidSudoku(
                    arrayOf(
                        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
                    )
                )
            )
        }

        fun isValidSudoku(board: Array<CharArray>): Boolean {
            val rows = mutableMapOf<Int, MutableSet<Char>>();
            val columns = mutableMapOf<Int, MutableSet<Char>>();
            val boxes = mutableMapOf<Int, MutableSet<Char>>();

            for (r in 0 until board.size) {
                for (c in 0 until board.size) {
                    val n = board[r][c]

                    if (n == '.') continue

                    val box = (r / 3) * 3 + c / 3

                    if (rows[r]?.contains(n) == true || columns[c]?.contains(n) == true || boxes[box]?.contains(n) == true) {
                        return false
                    }
                    addElement(rows, r, n)
                    addElement(columns, c, n)
                    addElement(boxes, box, n)
                }
            }
            return true
        }

        fun addElement(map: MutableMap<Int, MutableSet<Char>>, key: Int, n: Char) {
            if (map.containsKey(key)) {
                map[key]?.add(n)
            } else {
                map[key] = mutableSetOf(n)
            }
        }
    }
}