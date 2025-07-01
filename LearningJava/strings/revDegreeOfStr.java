package Strings;
// LeetCode Problem: 3498. Reverse Degree of a String [Easy]
// Problem Link: https://leetcode.com/problems/reverse-degree-of-a-string/
class revDegreeOfStr {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;
        for(int i=0; i<n; i++) {
            int a = getReverse(s.charAt(i));
            sum += a * (i+1);
        }
        return sum;
    }
    private int getReverse(char c) {
        return Math.abs((c-'a') - 26);
    }
    public static void main(String[] args) {
        revDegreeOfStr solution = new revDegreeOfStr();
        String s = "abc";
        int result = solution.reverseDegree(s);
        System.out.println(result); // Output: 6
    }
}
