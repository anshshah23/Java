public class Board {
    private char[][] board;
    private static final char EMPTY = ' ';
    private static final char HUMAN = 'X';
    private static final char AI = 'O';

    public Board() {
        board = new char[3][3];
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    public void displayBoard() {
        System.out.println("\n");
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i < 2) {
                System.out.println("-----------");
            }
        }
        System.out.println("\nPosition numbering:");
        System.out.println(" 1 | 2 | 3");
        System.out.println("-----------");
        System.out.println(" 4 | 5 | 6");
        System.out.println("-----------");
        System.out.println(" 7 | 8 | 9\n");
    }

    public boolean makeMove(int position, char player) {
        if (position < 1 || position > 9) {
            return false;
        }

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        if (board[row][col] != EMPTY) {
            return false;
        }

        board[row][col] = player;
        return true;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public char checkWinner() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != EMPTY && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }

        // Check diagonals
        if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }

        if (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }

        return EMPTY;
    }

    public char getCell(int row, int col) {
        return board[row][col];
    }

    public static char getHuman() {
        return HUMAN;
    }

    public static char getAI() {
        return AI;
    }
}
