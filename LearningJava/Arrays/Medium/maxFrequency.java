package Arrays.Medium;

import java.util.Arrays;

public class maxFrequency {
    public int mostFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0,maxFreq=0;
        long sum=0;
        for(int right = 0; right < nums.length ; right++) {
            sum += nums[right];
            while((long)nums[right]*(right-left+1) > sum + k ){
                sum -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right-left+1);
        }
        return maxFreq;
    }
    public static void main(String[] args) {
        maxFrequency mf = new maxFrequency();
        int[] nums = {1, 2, 4};
        int k = 5;
        System.out.println(mf.mostFrequency(nums, k)); // Output: 3
    }
}
