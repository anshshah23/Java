package InformationSecurity;
import java.util.Scanner;
import java.util.Arrays;

public class ColumnarTranspositionCipher {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the plaintext: ");
        String pt = inp.next();
        int textLength = pt.length();
        System.out.println("Enter the key: ");
        String key = inp.next();
        int keyLength = key.length();

        int numCols = keyLength;
        int numRows = (int) Math.ceil((double) textLength / keyLength);
        String cipherText = encrypt(pt, key, textLength, keyLength, numCols, numRows);
        System.out.println("Cipher Text: " + cipherText);

        String decryptedText = decrypt(cipherText, key, numCols, numRows, textLength);
        System.out.println("Decrypted Text: " + decryptedText);

        inp.close();
    }

    public static String encrypt(String pt, String key, int textLength, int keyLength, int numCols, int numRows) {
        char[][] array = new char[numRows][numCols];
        int k = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (k < textLength) {
                    array[i][j] = pt.charAt(k);
                } else {
                    array[i][j] = 'X';
                }
                System.out.print(array[i][j] + " ");
                k++;
            }
            System.out.println();
        }
        int[] keyOrder = getKeyOrder(key);
        StringBuilder cipherText = new StringBuilder();
        for (int col : keyOrder) {
            for (int i = 0; i < numRows; i++) {
                cipherText.append(array[i][col]);
            }
        }

        return cipherText.toString();
    }
    public static String decrypt(String cipherText, String key, int numCols, int numRows, int textLength) {
        char[][] array2 = new char[numRows][numCols];
        int[] keyOrder = getKeyOrder(key);
        int index = 0;
        for (int k = 0; k < numCols; k++) {
            int col = keyOrder[k];  
            for (int row = 0; row < numRows; row++) {
                if (index < textLength) {
                    array2[row][col] = cipherText.charAt(index);
                    index++;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result.append(array2[i][j]);
            }
        }

        return result.toString().replace("X", "");
    }

    private static int[] getKeyOrder(String key) {
        int length = key.length();
        Character[] sortedKey = new Character[length];

        for (int i = 0; i < length; i++) {
            sortedKey[i] = key.charAt(i);
        }

        Arrays.sort(sortedKey);

        int[] order = new int[length];
        boolean[] used = new boolean[length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!used[j] && key.charAt(j) == sortedKey[i]) {
                    order[i] = j;
                    used[j] = true;
                    break;
                }
            }
        }

        return order;
    }
}
