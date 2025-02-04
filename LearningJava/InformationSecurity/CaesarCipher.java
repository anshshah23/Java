package LearningJava.InformationSecurity;
import java.util.Scanner;
public class CaesarCipher {
    public static void main(String[] args) {
        String pt, ct = "";
        int key, n;
        System.out.println("Enter the Plain Text followed by the Key:");
        Scanner inp = new Scanner(System.in);
        pt = inp.nextLine();
        key = inp.nextInt();
        n = pt.length();
        key = key % 26;
        for (int i = 0; i < n; i++) {
            char ch = pt.charAt(i);
            ch = (char) ((ch - 'a' + key) % 26 + 'a');
            ct += ch;
        }
        System.out.println("Cipher Text: " + ct);
        pt="";
        for (int i = 0; i < n; i++) {
            char ch = ct.charAt(i);
            ch = (char) ((ch - 'a' - key + 26) % 26 + 'a');
            pt += ch;
        }
        System.out.println("Plain Text: " + pt);
        inp.close();
        System.exit(0);
    }
}
