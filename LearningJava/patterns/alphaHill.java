/*
    A
  A B A
A B C B A
*/
package Patterns;
public class alphaHill {
    public static void printPattern(int n) {
        for(int i = 1 ; i <= n ; i++ ){
            char counter='A';
            for(int j=n-1 ; j>=i ; j-- ){
                System.out.print("  ");
            }
            for(int j=1 ; j<=i ; j++){
                System.out.print(counter+++" ");
            }
            --counter;
            for(int j=i-1 ; j>0 ; j--){
                System.out.print(--counter+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]) {
        printPattern(5);
    }
}