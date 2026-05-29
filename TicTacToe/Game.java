public class Game {
    private Board board;
    private boolean isHumanTurn;
    private java.util.Scanner scanner;
    private static final char HUMAN = 'X';
    private static final char AI = 'O';
    private static final char EMPTY = ' ';

    public Game() {
        board = new Board();
        scanner = new java.util.Scanner(System.in);
        isHumanTurn = true;
    }

    public void playGame() {
        System.out.println("========== TIC TAC TOE ==========");
        System.out.println("You are X, AI is O");
        System.out.println("================================\n");

        board.displayBoard();

        while (true) {
            if (isHumanTurn) {
                if (!humanMove()) {
                    continue;
                }
            } else {
                aiMove();
            }

            board.displayBoard();

            char winner = board.checkWinner();
            if (winner != EMPTY) {
                if (winner == HUMAN) {
                    System.out.println("🎉 You won! Congratulations!");
                } else {
                    System.out.println("🤖 AI won! Better luck next time!");
                }
                break;
            }

            if (board.isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            isHumanTurn = !isHumanTurn;
        }
    }

    private boolean humanMove() {
        try {
            System.out.print("Enter position (1-9): ");
            int position = scanner.nextInt();

            if (!board.makeMove(position, HUMAN)) {
                System.out.println("Invalid move! Position already taken or out of range.");
                return false;
            }
            return true;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number between 1 and 9.");
            scanner.nextLine();
            return false;
        }
    }

    private void aiMove() {
        System.out.println("AI is thinking...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Try to win
        for (int i = 1; i <= 9; i++) {
            if (canWinAt(i, AI)) {
                board.makeMove(i, AI);
                System.out.println("AI played position " + i);
                return;
            }
        }

        // Block human from winning
        for (int i = 1; i <= 9; i++) {
            if (canWinAt(i, HUMAN)) {
                board.makeMove(i, AI);
                System.out.println("AI played position " + i);
                return;
            }
        }

        // Play center if available
        if (isPositionEmpty(5)) {
            board.makeMove(5, AI);
            System.out.println("AI played position 5");
            return;
        }

        // Play corners if available
        int[] corners = {1, 3, 7, 9};
        for (int corner : corners) {
            if (isPositionEmpty(corner)) {
                board.makeMove(corner, AI);
                System.out.println("AI played position " + corner);
                return;
            }
        }

        // Play any available space
        for (int i = 1; i <= 9; i++) {
            if (isPositionEmpty(i)) {
                board.makeMove(i, AI);
                System.out.println("AI played position " + i);
                return;
            }
        }
    }

    private boolean isPositionEmpty(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return board.getCell(row, col) == EMPTY;
    }

    private boolean canWinAt(int position, char player) {
        if (!isPositionEmpty(position)) {
            return false;
        }

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;

        // Check row
        int rowCount = 0;
        for (int j = 0; j < 3; j++) {
            if (board.getCell(row, j) == player) rowCount++;
        }
        if (rowCount == 2) return true;

        // Check column
        int colCount = 0;
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, col) == player) colCount++;
        }
        if (colCount == 2) return true;

        // Check main diagonal
        if (row == col) {
            int diagCount = 0;
            for (int i = 0; i < 3; i++) {
                if (board.getCell(i, i) == player) diagCount++;
            }
            if (diagCount == 2) return true;
        }

        // Check anti-diagonal
        if (row + col == 2) {
            int diagCount = 0;
            for (int i = 0; i < 3; i++) {
                if (board.getCell(i, 2 - i) == player) diagCount++;
            }
            if (diagCount == 2) return true;
        }

        return false;
    }

    public void resetGame() {
        board.initializeBoard();
        isHumanTurn = true;
    }
}
