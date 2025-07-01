package InformationSecurity;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class RSA {
    static BigInteger power(BigInteger base, BigInteger exp, BigInteger mod) {
        return base.modPow(exp, mod);
    }
    static BigInteger modInverse(BigInteger e, BigInteger phi) {
        return e.modInverse(phi);
    }
    static BigInteger encrypt(BigInteger m, BigInteger e, BigInteger n) {
        return power(m, e, n);
    }
    static BigInteger decrypt(BigInteger c, BigInteger d, BigInteger n) {
        return power(c, d, n);
    }
    static void generateKeys(BigInteger[] keys) {
        BigInteger p = new BigInteger("7919");
        BigInteger q = new BigInteger("1009");
        
        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        BigInteger e = new BigInteger("65537"); // Common public exponent
        BigInteger d = modInverse(e, phi);

        keys[0] = e;  // Public Key (e)
        keys[1] = d;  // Private Key (d)
        keys[2] = n;  // Modulus (n)
    }
    static BigInteger textToBigInt(String text) {
        return new BigInteger(text.getBytes(StandardCharsets.UTF_8));
    }
    static String bigIntToText(BigInteger bigInt) {
        return new String(bigInt.toByteArray(), StandardCharsets.UTF_8);
    }
    public static void main(String args[]) {
        Scanner inp = new Scanner(System.in);
        BigInteger[] keys = new BigInteger[3];
        generateKeys(keys);

        System.out.println("Public Key (e, n): (" + keys[0] + ", " + keys[2] + ")");
        System.out.println("Private Key (d, n): (" + keys[1] + ", " + keys[2] + ")");

        System.out.println("\nEnter plaintext (text(max 3 chars) or integer(max 7 chars)): ");
        String input = inp.nextLine();

        BigInteger m;
        boolean isNumeric = input.matches("\\d+");

        if (isNumeric) {
            m = new BigInteger(input);
        } else {
            m = textToBigInt(input);
            
            // Ensure message is smaller than modulus
            if (m.compareTo(keys[2]) >= 0) {
                System.out.println("Error: Message too large for encryption. Choose a smaller message.");
                inp.close();
                return;
            }
        }

        BigInteger c = encrypt(m, keys[0], keys[2]);
        BigInteger decrypted = decrypt(c, keys[1], keys[2]);

        System.out.println("Plain Text => " + input);
        System.out.println("CipherText => " + c);
        
        if (isNumeric) {
            System.out.println("Decrypted Text => " + decrypted);
        } else {
            System.out.println("Decrypted Text => " + bigIntToText(decrypted));
        }

        inp.close();
    }
}
