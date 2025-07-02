package Math;
import java.util.*;

public class countOddEvenDiv {
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
		    int even = 0, odd = 0;
		    int x = sc.nextInt();
		    for(int i = 1 ; i <= x ; i++ ){
		        if(x%i == 0){
		            if(i%2 == 0){
		                even++;
		            }
		            else odd++;
		        }
		    }
		    System.out.println(odd+" "+even);
		}
        sc.close();
	}
}