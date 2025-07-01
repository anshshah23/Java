package Recursion;
import java.util.*;

class CombinationSum {
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(target == 0 ) return res;
        recur(res, candidates, target, 0, new ArrayList<>());
        return res;        
    }
    public void recur(List<List<Integer>> res, int[] cand, int tar, int start, List<Integer> cur){
        if( start == cand.length || tar < 0 ) return;
        else if(tar==0) {
            res.add(new ArrayList<>(cur));
        }
        else{
            for(int i = start; i < cand.length ; i++){
                cur.add(cand[i]);
                recur(res,cand,tar-cand[i],i,cur);
                cur.remove(cur.size()-1);
            }
        }
    }
    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        
        int[] candidates = {2, 3, 4, 6, 7};
        int target = 7;
        
        List<List<Integer>> result = solution.combinationSum1(candidates, target);
        
        System.out.println("All combinations that sum to " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}