/*
A 
A B 
A B C 
A B C D 
A B C D E 
A B C D E F 
A B C D E F G 
*/
package Patterns;

public class nLetterTriangle {
    public static void printPattern(int n) {
        for(int i = 1 ; i <= n ; i++ ){
            char counter='A';
            for(int j = 1; j <=i ; j++ ){
                System.out.print(counter+++" ");
            }
            System.out.println();
        }    
    }
    public static void main(String args[]) {
        printPattern(7);
    }
}