package Math;
import java.util.*;

public class oddEvenDiv {
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
		    int a = sc.nextInt();
		    int b = sc.nextInt();
		    
		    if (a == 0) {
		        System.out.println("No");
		        continue;
		    }
		    if(b%a == 0) {
		        System.out.println("Yes");
		    } else {
		        System.out.println("No");
		    }
		}
        sc.close();
	}
}