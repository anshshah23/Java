package Recursion;

public class fibonacci {
    public int fib(int n) {
        return fibo(n, 0, 1);
    }

    public int fibo(int n, int i, int j) {
        if (n == 0)
            return i;
        if (n == 1)
            return j;
        return fibo(n - 1, j, i + j);
    }

    public static void main(String[] args) {
        fibonacci fib = new fibonacci();
        int n = 10;
        System.out.println("Fibonacci number at position " + n + " is: " + fib.fib(n));
    }
}
