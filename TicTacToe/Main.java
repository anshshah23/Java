import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            Game game = new Game();
            game.playGame();

            System.out.print("\nDo you want to play again? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
        }

        System.out.println("Thanks for playing! Goodbye!");
        scanner.close();
    }
}
