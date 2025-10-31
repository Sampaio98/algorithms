package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.' },
                {'6', '.', '.', '1', '9', '5', '.', '.', '.' },
                {'.', '9', '8', '.', '.', '.', '.', '6', '.' },
                {'8', '.', '.', '.', '6', '.', '.', '.', '3' },
                {'4', '.', '.', '8', '.', '3', '.', '.', '1' },
                {'7', '.', '.', '.', '2', '.', '.', '.', '6' },
                {'.', '6', '.', '.', '.', '.', '2', '8', '.' },
                {'.', '.', '.', '4', '1', '9', '.', '.', '5' },
                {'.', '.', '.', '.', '8', '.', '.', '7', '9' }};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        var rows = new HashMap<Integer, Set<Character>>();
        var columns = new HashMap<Integer, Set<Character>>();
        var boxes = new HashMap<Integer, Set<Character>>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                var current = board[r][c];

                if (current == '.')
                    continue;

                int box = (r / 3) * 3 + (c / 3);

                if ((rows.get(r) != null && rows.get(r).contains(current)) ||
                        (columns.get(c) != null && columns.get(c).contains(current)) ||
                        (boxes.get(box) != null && boxes.get(box).contains(current))) {
                    return false;
                }

                rows.computeIfAbsent(r, k -> new HashSet<>()).add(current);
                columns.computeIfAbsent(c, k -> new HashSet<>()).add(current);
                boxes.computeIfAbsent(box, k -> new HashSet<>()).add(current);
            }
        }
        return true;
    }
}
