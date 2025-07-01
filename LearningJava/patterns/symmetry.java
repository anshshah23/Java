package Patterns;
/*
* * * * * * 
* *     * * 
*         * 
*         * 
* *     * * 
* * * * * * 
*/

public class symmetry {
    public static void printPattern(int n) {
        n = 2*n ;
        for(int row = 0; row < n; row++) {
            for(int col = 0; col < n; col++) {
                if(row < n/2 && (col < (n/2 - row) || col >= (n/2 + row))) {
                    System.out.print('*');
                }
                else if(row >= n/2 && (col <= (row-n/2) || col >= (n-row+n/2-1))) {
                    System.out.print('*');
                }
                else {
                    System.out.print(' ');
                }
                System.out.print(' ');
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        printPattern(7);
    }
}