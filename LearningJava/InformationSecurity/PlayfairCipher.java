package LearningJava.InformationSecurity;
import java.util.Scanner;

public class PlayfairCipher {

    // Method to format the plaintext into digraphs
    public static String formatPlainText(String pt) {
        StringBuilder formattedText = new StringBuilder();
        for (int i = 0; i < pt.length(); i++) {
            formattedText.append(pt.charAt(i));
            if (i + 1 < pt.length()) {
                if (pt.charAt(i) == pt.charAt(i + 1)) {
                    formattedText.append('X'); // Add X between duplicate letters
                }
            }
        }
        if (formattedText.length() % 2 != 0) {
            formattedText.append('X'); // If the length is odd, append 'X'
        }
        return formattedText.toString();
    }

    // Method to find the row and column of a character in the matrix
    public static int[] findPosition(char c, char[][] matrix) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c) {
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }

    public static String convertToCipher(char first, char second, char[][] matrix) {
        int[] firstPos = findPosition(first, matrix);
        int[] secondPos = findPosition(second, matrix);

        if (firstPos[0] == secondPos[0]) { // Same row
            first = matrix[firstPos[0]][(firstPos[1] + 1) % 5];
            second = matrix[secondPos[0]][(secondPos[1] + 1) % 5];
        } else if (firstPos[1] == secondPos[1]) { // Same column
            first = matrix[(firstPos[0] + 1) % 5][firstPos[1]];
            second = matrix[(secondPos[0] + 1) % 5][secondPos[1]];
        } else {
            first = matrix[firstPos[0]][secondPos[1]];
            second = matrix[secondPos[0]][firstPos[1]];
        }

        return String.valueOf(first) + second;
    }

    public static String processPlainText(String pt, char[][] matrix) {
        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < pt.length(); i += 2) {
            char first = pt.charAt(i);
            char second = pt.charAt(i + 1);
            cipherText.append(convertToCipher(first, second, matrix));
        }
        return cipherText.toString();
    }

    public static void main(String[] args) {
        String pt, ct, key = "";
        char[][] matrix = new char[5][5];
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the plain text: ");
        pt = inp.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        System.out.println("Enter the key: ");
        key = inp.nextLine().toUpperCase().replaceAll("[^A-Z]", "");
        StringBuilder uniqueKey = new StringBuilder();
        for (char c : key.toCharArray()) {
            if (uniqueKey.indexOf(String.valueOf(c)) == -1) {
                uniqueKey.append(c);
            }
        }
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
        StringBuilder keyString = new StringBuilder(uniqueKey.toString());
        for (char c : alphabet.toCharArray()) {
            if (keyString.indexOf(String.valueOf(c)) == -1) {
                keyString.append(c);
            }
        }
        int index = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                matrix[i][j] = keyString.charAt(index++);
            }
        }
        System.out.println("Playfair Cipher Matrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        pt = formatPlainText(pt);
        System.out.println("Formatted Plaintext: " + pt);
        ct = processPlainText(pt, matrix);
        System.out.println("Cipher Text: " + ct);
        inp.close();
    }
}
