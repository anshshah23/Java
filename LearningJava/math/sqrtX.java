package Math;
class sqrtX {
    public int mySqrt(int x) {
        // Edge case: square root of 0 is 0
        if (x == 0) return 0;

        int left = 1, right = x;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid; // perfect square
            } else if (square < x) {
                ans = mid; // store as possible answer
                left = mid + 1; // look for bigger
            } else {
                right = mid - 1; // look for smaller
            }
        }

        return ans; // closest integer sqrt
    }
    public static void main(String[] args) {
        sqrtX solution = new sqrtX();
        System.out.println("Square root of 8: " + solution.mySqrt(8)); // Output: 2
        System.out.println("Square root of 16: " + solution.mySqrt(16)); // Output: 4
        System.out.println("Square root of 0: " + solution.mySqrt(0)); // Output: 0
    }
}