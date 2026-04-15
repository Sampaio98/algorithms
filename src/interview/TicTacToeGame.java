package interview;

import java.util.Scanner;
import java.util.Set;

import static java.lang.IO.print;
import static java.lang.IO.println;

public class TicTacToeGame {

    private static final Set<Integer> VALID_POSITIONS = Set.of(11, 12, 13, 21, 22, 23, 31, 32, 33);

    private final Character[][] board = new Character[3][3];
    private boolean playerTurn = true;

    void main() {
        printBoard();
        ticTacToeGame();
    }

    public void ticTacToeGame() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                Character letter = playerTurn ? 'X' : 'O';

                println(letter + " make your play !");
                int play = sc.nextInt();

                int line = (play / 10) - 1;
                int column = (play % 10) - 1;

                if (isInvalidPosition(play)) {
                    println("Invalid position " + play);
                    continue;
                }

                if (isPositionAlreadyTaken(line, column)) {
                    println("Invalid play, this position is already taken !");
                    continue;
                }

                board[line][column] = letter;
                printBoard();

                if (isWinner(letter)) {
                    println(letter + " IS THE WINNER !!");
                    break;
                }

                if (isDraw()) {
                    println("==== DRAW ====");
                    break;
                }

                // change player
                playerTurn = !playerTurn;
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char letter = board[i][j] != null ? board[i][j] : ' ';
                print(" " + letter + " ");
                if (j < 2) {
                    print("|");
                }
            }
            if (i < 2) {
                println();
                print("-".repeat(11));
                println();
            }
        }
        println();
    }

    private boolean isDraw() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isWinner(Character letter) {
        // VERIFY HORIZONTAL
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (letter.equals(board[i][j])) {
                    count++;
                }
            }
            if (count == board.length) return true;
        }

        // VERIFY VERTICAL
        for (int i = 0; i < board.length; i++) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (letter.equals(board[j][i])) {
                    count++;
                }
            }
            if (count == board.length) return true;
        }

        // VERIFY MAIN DIAGONAL (\)
        int countMainDiagonal = 0;
        for (int i = 0; i < board.length; i++) {
            if (letter.equals(board[i][i])) {
                countMainDiagonal++;
            }
        }
        if (countMainDiagonal == board.length) return true;

        // VERIFY SECONDARY DIAGONAL (/)
        int countSecondaryDiagonal = 0;
        for (int i = 0; i < board.length; i++) {
            if (letter.equals(board[i][board.length - 1 - i])) {
                countSecondaryDiagonal++;
            }
        }
        if (countSecondaryDiagonal == board.length) return true;

        return false;
    }

    private boolean isInvalidPosition(int play) {
        return !VALID_POSITIONS.contains(play);
    }

    private boolean isPositionAlreadyTaken(int line, int column) {
        return board[line][column] != null;
    }

}
