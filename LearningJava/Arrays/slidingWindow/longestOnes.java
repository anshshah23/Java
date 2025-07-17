package Arrays.slidingWindow;
class longestOnes {
    public int longestOne(int[] nums, int k) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                k--;
            }

            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
        }

        return nums.length - left;        
    }
    public static void main(String[] args) {
        longestOnes obj = new longestOnes();
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0};
        int k = 2;
        System.out.println("Longest subarray of ones: " + obj.longestOne(nums, k));
    }
}