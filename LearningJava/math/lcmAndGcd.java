package Math;
// Problem: Calculate the Least Common Multiple (LCM) and Greatest Common Divisor (GCD) of two numbers
public class lcmAndGcd {
    public static int[] calculateLcmAndGcd(int a, int b) {
        int gcd = findGcd(a, b);
        int lcm = (a*b)/gcd;
        return new int[]{lcm, gcd};
    }
    public static int findGcd(int a, int b){
        if (b == 0) {
            return a;
        }
        return findGcd(b, a % b);
    }
    public static void main(String[] args) {
        int[] ans;
        ans = calculateLcmAndGcd(5, 10);
        System.out.print(java.util.Arrays.toString(ans));
    }
}
