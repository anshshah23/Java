import java.util.*;

class subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        sub(res,nums,new ArrayList<>(), 0);
        return res;
    }
    public static void sub(List<List<Integer>> res, int[] nums, List<Integer> cur, int ind){
        if(ind>=nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[ind]);
        sub(res,nums,cur,ind+1);
        cur.remove(cur.size()-1);
        sub(res,nums,cur,ind+1);
    }
    public static void main(String[] args) {
        subset solution = new subset();

        int[] nums = {1, 2, 3}; // You can change this input for other tests
        List<List<Integer>> result = solution.subsets(nums);

        System.out.println("All subsets:");
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}