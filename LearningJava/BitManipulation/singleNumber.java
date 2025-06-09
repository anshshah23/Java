package BitManipulation;
// LeetCode Problem: https://leetcode.com/problems/single-number/
class singleNumber {
    public int singleNumberLeetcode(int[] nums) {
        int res = 0;
        for(int i:nums){
            res ^= i;
        }
        return res;
    }
    public static void main(String[] args) {
        singleNumber solution = new singleNumber();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println("The single number is: " + solution.singleNumberLeetcode(nums)); // Output: 4
    }
}