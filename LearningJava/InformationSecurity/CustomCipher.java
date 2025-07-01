package InformationSecurity;
import java.util.*;

public class CustomCipher {

    public static Map<Character, Character> generateSubstitutionKey() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        List<Character> shuffled = new ArrayList<>();
        for (char c : letters.toCharArray()) {
            shuffled.add(c);
        }
        Collections.shuffle(shuffled);
        Map<Character, Character> subKey = new HashMap<>();
        for (int i = 0; i < letters.length(); i++) {
            subKey.put(letters.charAt(i), shuffled.get(i));
        }
        return subKey;
    }

    public static String substitutionEncrypt(String plaintext, Map<Character, Character> subKey) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : plaintext.toUpperCase().toCharArray()) {
            encrypted.append(subKey.getOrDefault(c, c));
        }
        return encrypted.toString();
    }

    public static String substitutionDecrypt(String ciphertext, Map<Character, Character> subKey) {
        Map<Character, Character> reverseKey = new HashMap<>();
        for (Map.Entry<Character, Character> entry : subKey.entrySet()) {
            reverseKey.put(entry.getValue(), entry.getKey());
        }
        StringBuilder decrypted = new StringBuilder();
        for (char c : ciphertext.toCharArray()) {
            decrypted.append(reverseKey.getOrDefault(c, c));
        }
        return decrypted.toString();
    }

    public static String transpositionEncrypt(String text, String key) {
        int numCols = key.length();
        int numRows = (int) Math.ceil((double) text.length() / numCols);
        char[][] grid = new char[numRows][numCols];
        int index = 0;

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (index < text.length()) {
                    grid[row][col] = text.charAt(index++);
                } else {
                    grid[row][col] = ' ';
                }
            }
        }

        List<Integer> keyOrder = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            keyOrder.add(i);
        }
        keyOrder.sort(Comparator.comparingInt(k -> key.charAt(k)));

        StringBuilder encrypted = new StringBuilder();
        for (int col : keyOrder) {
            for (int row = 0; row < numRows; row++) {
                encrypted.append(grid[row][col]);
            }
        }
        return encrypted.toString();
    }

    public static String transpositionDecrypt(String ciphertext, String key) {
        int numCols = key.length();
        int numRows = (int) Math.ceil((double) ciphertext.length() / numCols);
        char[][] grid = new char[numRows][numCols];
        List<Integer> keyOrder = new ArrayList<>();
        for (int i = 0; i < key.length(); i++) {
            keyOrder.add(i);
        }
        keyOrder.sort(Comparator.comparingInt(k -> key.charAt(k)));

        int index = 0;
        for (int col : keyOrder) {
            for (int row = 0; row < numRows; row++) {
                if (index < ciphertext.length()) {
                    grid[row][col] = ciphertext.charAt(index++);
                }
            }
        }

        StringBuilder decrypted = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                decrypted.append(grid[row][col]);
            }
        }
        return decrypted.toString().strip();
    }

    public static String encrypt(String text, Map<Character, Character> subKey, String transKey) {
        String step1 = substitutionEncrypt(text, subKey);
        return transpositionEncrypt(step1, transKey);
    }

    public static String decrypt(String ciphertext, Map<Character, Character> subKey, String transKey) {
        String step1 = transpositionDecrypt(ciphertext, transKey);
        return substitutionDecrypt(step1, subKey);
    }

    public static void main(String[] args) {
        Map<Character, Character> subKey = generateSubstitutionKey();
        String transKey = "31452";
        String plaintext = "HELLO WORLD";
        System.out.println("Plaintext: "+plaintext);
        String ciphertext = encrypt(plaintext.replace(" ", ""), subKey, transKey);
        System.out.println("Encrypted: " + ciphertext);
        String decryptedText = decrypt(ciphertext, subKey, transKey);
        System.out.println("Decrypted: " + decryptedText);
    }
}