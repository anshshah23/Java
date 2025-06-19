class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] lps = new int[needle.length()];
        preprocess(needle, lps);
        int h = 0, n = 0;
        while (h < haystack.length()) {
            if (haystack.charAt(h) == needle.charAt(n)) {
                h++;
                n++;
                if (n == needle.length()) {
                    return h - n;
                }
            } else {
                if (n == 0) {
                    h++;
                } else {
                    n = lps[n - 1];
                }
            }
        }
        return -1;
    }

    public void preprocess(String needle, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
    }
}
