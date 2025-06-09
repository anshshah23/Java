package strings;

class balancedStrSplit {
    public int balancedStringSplit(String s) {
        int cnt = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                r++;
            } else {
                r--;
            }
            if (r == 0) {
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        balancedStrSplit solution = new balancedStrSplit();
        String s = "RLRRLLRLRL";
        int result = solution.balancedStringSplit(s);
        System.out.println(result); // Output: 4
    }
}
