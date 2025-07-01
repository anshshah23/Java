package Arrays.Medium;
/* Please note this is not an optimized solution! */
// Problem: LeetCode 11. Container With Most Water
// Link: https://leetcode.com/problems/container-with-most-water/
class containerWithMostWater {
    public int maxArea(int[] height) {
        int s = 0;
        int e = height.length-1;
        int mostWater = 0;
        while(s<e){
            int l = Math.min(height[s],height[e]);
            int b = Math.abs(s-e);
            mostWater = Math.max(mostWater,(l*b));
            if(height[s]<height[e]){
                s++;
            } else {
                e--;
            }
        }
        return mostWater;
    }
    public static void main(String[] args) {
        containerWithMostWater obj = new containerWithMostWater();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum water that can be contained: " + obj.maxArea(height));
        // Example output: Maximum water that can be contained: 49
    }
}