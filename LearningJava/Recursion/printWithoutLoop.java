package Recursion;
public class printWithoutLoop {
    public static void main(String[] args) {
        // Hardcoded test cases
        int[] testCases = {5, 7}; // Array containing test cases

        for (int N : testCases) {
            Solution obj = new Solution();
            obj.printNos(N);
            System.out.println("\n~");
        }
    }
}

class Solution {
    public void printNos(int n) {  // Ensure this method is correctly defined
        printChar(1, n);
    }

    public static void printChar(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.print(i + " ");
        printChar(i + 1, n);
    }
}
