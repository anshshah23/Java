package Recursion;
// Problem: Find all factorial numbers less than or equal to N
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/*Sample input
2
10
25
 */
public class factorial {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long N = sc.nextLong();

            ArrayList<Long> ans = Solution.factorialNumbers(N); // Call static method directly
            for (long num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
class Solution {
    public static ArrayList<Long> factorialNumbers(long n) { // Add 'public'
        ArrayList<Long> arr = new ArrayList<>();
        printFact(1, 1, n, arr);
        return arr;
    }

    public static void printFact(long i, long fact, long n, ArrayList<Long> arr) {
        if (fact > n)
            return;

        arr.add(fact);
        printFact(i + 1, fact * (i + 1), n, arr);
    }
}
