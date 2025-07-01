package InformationSecurity;

import java.util.Scanner;

public class VernamCipher {

    // Function to encrypt the plaintext using the Vernam cipher (XOR operation)
    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        
        // Perform XOR on each character of the plaintext with the key
        for (int i = 0; i < plaintext.length(); i++) {
            // XOR operation between each character of the plaintext and key
            char encryptedChar = (char) (plaintext.charAt(i) ^ key.charAt(i));
            ciphertext.append(encryptedChar);
        }
        
        return ciphertext.toString();
    }

    // Function to decrypt the ciphertext using the Vernam cipher (XOR operation)
    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        
        // Perform XOR on each character of the ciphertext with the key
        for (int i = 0; i < ciphertext.length(); i++) {
            // XOR operation between each character of the ciphertext and key
            char decryptedChar = (char) (ciphertext.charAt(i) ^ key.charAt(i));
            plaintext.append(decryptedChar);
        }
        
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking input for plaintext and key
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        
        // The key must be the same length as the plaintext
        String key;
        while (true) {
            System.out.print("Enter key (must be the same length as plaintext): ");
            key = scanner.nextLine();
            if (key.length() == plaintext.length()) {
                break;
            } else {
                System.out.println("Key must be the same length as the plaintext.");
            }
        }

        // Encrypt the plaintext
        String encryptedText = encrypt(plaintext, key);
        System.out.println("Encrypted Text: " + encryptedText);

        // Decrypt the ciphertext
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted Text: " + decryptedText);
        
        scanner.close();
    }
}
