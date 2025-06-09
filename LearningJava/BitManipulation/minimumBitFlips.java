package BitManipulation;

public class minimumBitFlips {
    public int minBitFlips(int start, int goal) {
        int ans = 0;
        int xor = start^goal;
        while( xor!= 0 ){
            ans += xor & 1;
            xor = xor>>1;
        }
        return ans;
    }
    public static void main(String[] args) {
        minimumBitFlips solution = new minimumBitFlips();
        int start = 10; // Binary: 1010
        int goal = 7;   // Binary: 0111
        System.out.println("Minimum bit flips required: " + solution.minBitFlips(start, goal)); // Output: 3
    }
}