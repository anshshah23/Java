import java.util.Scanner;

public class crystals {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long x = sc.nextLong();
            int n = 0;
            long p = 1;
            while(p < x){
                p <<= 1;
                n++;
            }
            System.out.println(3 * n - (p == x ? 0 : 1));
        }
        sc.close();
    }
}
