package Recursion;
import java.io.*;
/* Sample input format
1
1 2 3 4 5
*/
public class reverseArray {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Number of test Case: ");
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            System.out.print("Enter your testcase "+tc+" :(Eg: 1 2 3 4 5)");
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];

            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            Solution obj = new Solution();
            obj.reverseArray(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


class Solution {
    public void reverseArray(int arr[]) {
        // code here
        rev(arr,0,arr.length-1);
    }
    public void rev(int arr[], int l, int r){
        int temp;
        if(l>(arr.length)/2-1){
            return;
        }
        temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        rev(arr, l+1, r-1);
    }
}