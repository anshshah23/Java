package InformationSecurity;

import java.util.Scanner;

public class VigenereCipher {
    
    // Function to encrypt the plaintext using the Vigenère cipher
    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        int keyIndex = 0;
        
        // Iterate through the plaintext
        for (int i = 0; i < plaintext.length(); i++) {
            char plaintextChar = plaintext.charAt(i);
            
            // Check if the character is a letter
            if (Character.isLetter(plaintextChar)) {
                char keyChar = key.charAt(keyIndex % key.length());
                int shift = Character.toLowerCase(keyChar) - 'a';
                
                // Encrypt uppercase letters
                if (Character.isUpperCase(plaintextChar)) {
                    char encryptedChar = (char) ((plaintextChar - 'A' + shift) % 26 + 'A');
                    ciphertext.append(encryptedChar);
                }
                // Encrypt lowercase letters
                else {
                    char encryptedChar = (char) ((plaintextChar - 'a' + shift) % 26 + 'a');
                    ciphertext.append(encryptedChar);
                }
                
                keyIndex++;
            } else {
                // If it's not a letter, just append the character as is
                ciphertext.append(plaintextChar);
            }
        }
        
        return ciphertext.toString();
    }
    
    // Function to decrypt the ciphertext using the Vigenère cipher
    public static String decrypt(String ciphertext, String key) {
        StringBuilder plaintext = new StringBuilder();
        int keyIndex = 0;
        
        // Iterate through the ciphertext
        for (int i = 0; i < ciphertext.length(); i++) {
            char ciphertextChar = ciphertext.charAt(i);
            
            // Check if the character is a letter
            if (Character.isLetter(ciphertextChar)) {
                char keyChar = key.charAt(keyIndex % key.length());
                int shift = Character.toLowerCase(keyChar) - 'a';
                
                // Decrypt uppercase letters
                if (Character.isUpperCase(ciphertextChar)) {
                    char decryptedChar = (char) ((ciphertextChar - 'A' - shift + 26) % 26 + 'A');
                    plaintext.append(decryptedChar);
                }
                // Decrypt lowercase letters
                else {
                    char decryptedChar = (char) ((ciphertextChar - 'a' - shift + 26) % 26 + 'a');
                    plaintext.append(decryptedChar);
                }
                
                keyIndex++;
            } else {
                // If it's not a letter, just append the character as is
                plaintext.append(ciphertextChar);
            }
        }
        
        return plaintext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Taking input for plaintext and key
        System.out.print("Enter plaintext: ");
        String plaintext = scanner.nextLine();
        
        System.out.print("Enter key: ");
        String key = scanner.nextLine();
        
        // Encrypt the plaintext
        String encryptedText = encrypt(plaintext, key);
        System.out.println("Encrypted Text: " + encryptedText);
        
        // Decrypt the ciphertext
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted Text: " + decryptedText);
        
        scanner.close();
    }
}
