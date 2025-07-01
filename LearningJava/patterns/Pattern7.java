package Patterns;
/*
   A
  A B
 A B C
A B C D
*/

public class Pattern7 {
    public static void printPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            char ch = 'A';
            for (int k = 1; k <= i; k++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        printPattern(7);
    }
}