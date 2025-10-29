import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (true) {
            System.out.println("Player " + currentPlayer + ", enter your move: ");
            System.out.print("Column (1-3): ");
            int col = scanner.nextInt() - 1;
            System.out.print("Row (1-3): ");
            int row = scanner.nextInt() - 1;
            
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                if (checkWin()) {
                    System.out.println("🎉 Player " + currentPlayer + " wins!");
                    break;
                } else if (isBoardFull()) {
                    System.out.println("🤝 It's a draw!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move, try again.");
            }
        }

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = ' ';
    }

    // Updated printBoard() with row & column numbers
    private static void printBoard() {
        System.out.println("\n     1   2   3");
        System.out.println("   -------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(" " + (i + 1) + " | ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("   -------------");
        }
        System.out.println();
    }

    private static boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) return false;
        return board[row][col] == ' ';
    }

    private static boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer)) {
                return true;
            }
        }

        if ((board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }

    private static boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }
}
