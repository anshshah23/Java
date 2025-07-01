package Patterns;
 /*
   *
  **
 ***
****
 ***
  **
   *
*/
public class Pattern5 {
    public static void main(String[] args) throws Exception {
        int n = 4; // height of the pattern

        // Print the pattern in one go
        for (int i = 1; i <= 2 * n - 1; i++) {
            int totalStars = (i <= n) ? i : 2 * n - i;
            int spaces = n - totalStars;

            // Print spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int k = 0; k < totalStars; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
