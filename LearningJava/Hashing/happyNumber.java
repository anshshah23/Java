package Hashing;
// Problem: LeetCode 202. Happy Number
// This is also a problem of Recursion
import java.util.HashSet;

class happyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> mp = new HashSet<>();
        while(n != 1 && !mp.contains(n)) {
            mp.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    public int getNext(int n) {
        int sum=0;
        while(n > 0){
            sum += (n%10)*(n%10);
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        happyNumber hn = new happyNumber();
        int n = 19; // Example input
        System.out.println("Is " + n + " a happy number? " + hn.isHappy(n));
    }
}