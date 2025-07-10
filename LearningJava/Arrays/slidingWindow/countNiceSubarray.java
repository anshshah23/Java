package Arrays.slidingWindow;
// LeetCode 1248. Count Number of Nice Subarrays
class CountNiceSubarray {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int l = 0, count = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] % 2 == 1) k--;
            while (k < 0) {
                if (nums[l++] % 2 == 1) k++;
            }
            count += r - l + 1;
        }
        return count;
    }
    public static void main(String[] args) {
        CountNiceSubarray solution = new CountNiceSubarray();
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(solution.numberOfSubarrays(nums, k)); // Output: 2
    }
}
