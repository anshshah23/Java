/* Input
abshdskajksaa
5
a d n k s


Output: 4, 1, 0, 2, 3, 
*/
package Hashing;

import java.util.Scanner;

public class charHashing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter input in the format given in the comments of code file: \n");
        String inp = input.nextLine();
        int size = inp.length();
        int[] hash = new int[26];

        for(int i = 0 ; i < size ; i++ ){
            hash[inp.charAt(i) - 'a'] += 1;
        }

        int n = input.nextInt();
        while (n > 0) {
            char c = input.next().charAt(0);
            System.out.print(hash[c-'a']+", ");
            n--;
        }
        input.close();
    }
}
