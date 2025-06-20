package slidingWindow;
import java.util.*;

public class maximumSumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input subarray size k
        System.out.print("Enter subarray size k: ");
        int k = sc.nextInt();

        // Call the function (you'll implement this)
        int maxSum = findMaxSumSubarray(arr, k);

        // Output the result
        System.out.println("Maximum sum of subarray of size " + k + ": " + maxSum);

        sc.close();
    }

    // todo: Implement this function using Sliding Window

    public static int findMaxSumSubarray(int[] arr, int k) {
        // Write code here
        int max = 0;
        int win = 0;
        for(int i = 0; i < k ; i++){
            win += arr[i];
        }
        max = win;
        for(int i = k; i < arr.length ; i++){
            win = win-arr[i-k]+arr[i];
            max = Math.max(max, win);
        }
        return max;
    }
}
