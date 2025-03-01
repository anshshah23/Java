/* Input
abcdagefb
5
a n g b e
*/
package LearningJava.Hashing;

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
            System.out.println(hash[c-'a']+"\n");
            n--;
        }
        input.close();
    }
}
