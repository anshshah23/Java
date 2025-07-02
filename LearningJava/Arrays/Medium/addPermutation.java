package Arrays.Medium;
import java.util.*;

public class addPermutation {
    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt(), k = sc.nextInt();
		    int[] p = new int[n+1];
		    int idx = 1;
		    
		    for(int i = n - k + 1; i >= 1; i--){
		        p[idx++] = i;
		    }
		    
		    for(int i = n - k + 2; i <= n; i++){
		        p[idx++] = i;
		    }
		    
		    for(int i = 1; i <= n; i++){
		        System.out.print(p[i] + " ");
		    }
		    System.out.println();
		}
        sc.close();
	}
}
