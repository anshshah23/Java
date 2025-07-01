package Strings;
//Leetcode Problem 3330: https://leetcode.com/problems/find-the-original-typed-string-i/
public class possibleStringCount {
    public int possibleStringCounting(String word) {
        int ans = 1;
        Character a = word.charAt(0);
        for(int i = 1 ; i < word.length() ; i++ ) {
            if(a != word.charAt(i)) {
                a = word.charAt(i);
            }
            else {
                ans++;
            }
        }
        return ans;
    }
    //Input: word = "abbcccc"
    // Output: 5
    // Explanation:
    // The possible strings are: "abbcccc", "abbccc", "abbcc", "abbc", and "abcccc".
    public static void main(String[] args) {
        possibleStringCount obj = new possibleStringCount();
        System.out.println(obj.possibleStringCounting("abbcccc")); // Output: 5
        System.out.println(obj.possibleStringCounting("abcd")); // Output: 1
    }
}
