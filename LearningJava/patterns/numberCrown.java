package Patterns;
/*
1                         1 
1 2                     2 1 
1 2 3                 3 2 1 
1 2 3 4             4 3 2 1 
1 2 3 4 5         5 4 3 2 1 
1 2 3 4 5 6     6 5 4 3 2 1 
1 2 3 4 5 6 7 7 6 5 4 3 2 1 
*/

public class numberCrown {
    public static void printPattern(int n) {
        for(int i = 1 ; i <= n ; i++){
                for(int k = 1; k<=i; k++){
                    System.out.print(k+" ");
                }
                for(int k = 2*(n-i); k>0 ; k--){
                    System.out.print("  ");
                }
                for(int k = i; k>=1; k--){
                    System.out.print(k+" ");
                }
                System.out.println();       
        }
    }
    public static void main(String args[]) {
        printPattern(7);
    }
}