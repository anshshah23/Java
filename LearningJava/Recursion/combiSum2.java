import java.util.*;
class combinationSum2 {
    public List<List<Integer>> combinationSumII(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combiSum2(res, candidates, new ArrayList<>(), target, 0);
        return res;
    }
    public void combiSum2(List<List<Integer>> res, int[] cand, List<Integer> cur, int tar, int ind){
        if(tar == 0) res.add(new ArrayList<>(cur));
        else{
            for(int i = ind; i < cand.length; i++){
                if(i > ind && cand[i]==cand[i-1]) continue;
                if(cand[i] > tar) break;
                cur.add(cand[i]);
                combiSum2(res, cand, cur, tar-cand[i],i+1);
                cur.remove(cur.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        combinationSum2 solution = new combinationSum2();
        
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        
        List<List<Integer>> result = solution.combinationSumII(candidates, target);
        
        System.out.println("All unique combinations that sum to " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}