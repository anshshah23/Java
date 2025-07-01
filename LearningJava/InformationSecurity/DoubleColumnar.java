package InformationSecurity;
import java.util.*;

public class DoubleColumnar {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        System.out.println("Enter the plain text: ");
        String pt = inp.nextLine().replaceAll(" ", "");
        int textLength = pt.length();

        System.out.println("Enter the key: "); 
        String key = inp.next();
        int keyLength = key.length();

        int numCols = keyLength;
        int numRows = (int) Math.ceil((double) textLength / keyLength);

        String cipherText = singleColumnarTransposition(pt, key, textLength, keyLength, numCols, numRows);
        System.out.println("Cipher Text after first transposition: " + cipherText);

        System.out.println("Enter the key 2: ");
        String key2 = inp.next();
        int key2Length = key2.length();
        
        int newNumRows = (int) Math.ceil((double) cipherText.length() / key2Length);
        String cipherText2 = singleColumnarTransposition(cipherText, key2, cipherText.length(), key2Length, key2Length, newNumRows);

        System.out.println("Final Cipher Text after second transposition: " + cipherText2);
        inp.close();
    }

    public static String singleColumnarTransposition(String pt, String key, int textLength, int keyLength, int numCols, int numRows) {
        char[][] array = new char[numRows][numCols];
        int k = 0;

        // Fill matrix row-wise
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (k < textLength) {
                    array[i][j] = pt.charAt(k);
                    k++;
                } else {
                    array[i][j] = 'z';
                }
            }
        }
        class KeyIndex {
            char keyChar;
            int originalIndex;
            KeyIndex(char keyChar, int originalIndex) {
                this.keyChar = keyChar;
                this.originalIndex = originalIndex;
            }
        }
        List<KeyIndex> keyList = new ArrayList<>();
        for (int i = 0; i < keyLength; i++) {
            keyList.add(new KeyIndex(key.charAt(i), i));
        }
        keyList.sort(Comparator.comparing(ki -> ki.keyChar));
        StringBuilder cipherText = new StringBuilder();
        for (KeyIndex keyIdx : keyList) {
            int col = keyIdx.originalIndex;
            for (int i = 0; i < numRows; i++) {
                cipherText.append(array[i][col]);
            }
        }
        return cipherText.toString();
    }
}
