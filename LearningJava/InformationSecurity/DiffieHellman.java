import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.security.SecureRandom;

public class DiffieHellman {
    
    // Function to compute (base^exponent) % mod efficiently
    static BigInteger power(BigInteger base, BigInteger exponent, BigInteger mod) {
        return base.modPow(exponent, mod);
    }

    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        
        BigInteger p = new BigInteger("5789");
        BigInteger g = new BigInteger("4789");

        SecureRandom random = new SecureRandom();
        BigInteger privateAlice = new BigInteger(10, random);
        BigInteger privateBob = new BigInteger(10, random);
        
        BigInteger publicAlice = power(g, privateAlice, p);
        BigInteger publicBob = power(g, privateBob, p);

        BigInteger sharedSecretAlice = power(publicBob, privateAlice, p);
        BigInteger sharedSecretBob = power(publicAlice, privateBob, p);

        System.out.println("Alice's Shared Secret Key: " + sharedSecretAlice);
        System.out.println("Bob's Shared Secret Key: " + sharedSecretBob);

        System.out.print("Enter the plaintext: ");
        String plaintext = inp.nextLine();

        BigInteger m = new BigInteger(plaintext.getBytes(StandardCharsets.UTF_8));
        BigInteger encrypted = m.multiply(sharedSecretAlice).mod(p);
        
        System.out.println("Encrypted Message: " + encrypted);

        // Step 6: Decrypt the message
        BigInteger decrypted = encrypted.multiply(sharedSecretAlice.modInverse(p)).mod(p);
        String decryptedMessage = new String(decrypted.toByteArray(), StandardCharsets.UTF_8);
        
        System.out.println("Decrypted Message: " + decryptedMessage);

        inp.close();
    }
}
