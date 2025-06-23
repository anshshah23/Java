package Hashing;
import java.util.HashMap;

class countVowelConsonant {
    public int maxFreqSum(String s) {
        int l = s.length();
        int[] consonants = new int[26];
        HashMap<Character, Integer> vowels = new HashMap<>();
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o'
                    || s.charAt(i) == 'u') {
                char ch = s.charAt(i);
                vowels.put(ch, vowels.getOrDefault(ch, 0) + 1);
            } else {
                char ch=s.charAt(i);
                consonants[ch - 'a']++;
            }
        }
        int maxC = 0;
        for (int i = 0; i < 26; i++) {
            maxC = Math.max(maxC, consonants[i]);
        }
        int maxV = 0;
        for (Integer x : vowels.values()) {
            maxV = Math.max(maxV, x);
        }
        return maxV + maxC;
    }
    public static void main(String[] args) {
        countVowelConsonant obj = new countVowelConsonant();
        String s = "thisisasamplestring"; // Example input
        //Output : // Maximum frequency sum: 7 (3 vowels (i) + 4 consonants (s))
        System.out.println("Maximum frequency sum: " + obj.maxFreqSum(s));
    }
}