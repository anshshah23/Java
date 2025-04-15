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
}