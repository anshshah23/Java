/*
    *******
     *****
      ***
       *
*/
import java.util.Scanner;

public class inverseTriangle {
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt(); 
        for(int i = n ; i > 0 ; i-- ){
            for(int k = 0; k<n-i ; k++){
                System.out.print(" ");
            }
            for(int j = (i*2-1) ; j > 0 ; j--){
                System.out.print("*");
            }
            System.out.println();
        }
        inp.close();
    }
}
