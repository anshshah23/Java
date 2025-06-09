package strings;

public class parentheses {
    public int maxDepth(String s) {
        int max = 0, count = 0;
        if (s.length() == 0)
            return 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')' && count != 0) {
                max = Math.max(count, max);
                count--;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        parentheses Solution = new parentheses();
        String inp = "((()) (((()))) )";//max depth=5
        int res = Solution.maxDepth(inp);
        System.out.println(res);
    }
}