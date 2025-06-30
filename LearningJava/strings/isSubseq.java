package Strings;
class isSubseq {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while(i < s.length() && j < t.length() ){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == s.length();
    }
    public static void main(String[] args) {
        isSubseq obj = new isSubseq();
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(obj.isSubsequence(s, t)); // Output: true
    }
}