package Arrays.slidingWindow;
// LeetCode 930. Binary Subarrays With Sum
class binarySum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    private int atMost(int[] nums, int goal) {
        int head, tail = 0, sum = 0, result = 0;
        for (head = 0; head < nums.length; head++) {
            sum += nums[head];
            while (sum > goal && tail <= head) {
                sum -= nums[tail];
                tail++;
            }
            result += head - tail + 1;
        }
        return result;
    }
    public static void main(String[] args) {
        binarySum solution = new binarySum();
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(solution.numSubarraysWithSum(nums, goal)); // Output: 4
    }
}