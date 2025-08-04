package Arrays.slidingWindow;
import java.util.HashMap;
import java.util.Map;
/*
    * LeetCode Problem: 904. Fruit Into Baskets
    * Given an array of integers representing fruits in a row, 
    * find the maximum number of fruits you can collect in two baskets.
    * Each basket can only contain one type of fruit.
*/
class basketOfFruits {
    public int totalFruit(int[] fruits) {
        int max = 0,l=0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int r = 0 ; r < fruits.length ; r++ ){
            mp.put(fruits[r],mp.getOrDefault(fruits[r],0)+1);
            while(mp.size() > 2){
                mp.put(fruits[l], mp.get(fruits[l]) - 1);
                if (mp.get(fruits[l]) == 0) {
                    mp.remove(fruits[l]);
                }
                l++;
            }
            max = Math.max(max,r-l+1);
        }
        return max;
    }
    public static void main(String[] args) {
        basketOfFruits solution = new basketOfFruits();
        int[] fruits = {1, 2, 1, 2, 3};
        System.out.println("Maximum number of fruits: " + solution.totalFruit(fruits)); // Output: 4
    }
}