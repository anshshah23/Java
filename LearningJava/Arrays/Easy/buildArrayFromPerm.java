package Arrays.Easy;

public class buildArrayFromPerm {
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
    public static void main(String[] args) {
        buildArrayFromPerm sol = new buildArrayFromPerm();
        int[] nums = {0, 2, 1, 5, 3, 4};
        int[] result = sol.buildArray(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
