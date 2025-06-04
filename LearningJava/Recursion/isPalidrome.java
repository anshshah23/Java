public class isPalidrome {
    public boolean isPalindromeString(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        boolean ans = isPal(s, 0, s.length() - 1);
        return ans;
    }

    public boolean isPal(String s, int l, int r) {
        if (l >= r)
            return true;
        if (s.charAt(l) != s.charAt(r))
            return false;
        return isPal(s, l + 1, r - 1);
    }

    public static void main(String[] args) {
        isPalidrome palindromeChecker = new isPalidrome();
        System.out.println(palindromeChecker.isPalindromeString("A man, a plan, a canal: Panama"));
    }
}
