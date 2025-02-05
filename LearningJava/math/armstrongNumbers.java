package LearningJava.math;

import java.util.Scanner;

class Main {
    public static boolean isArmstrong(int n) {
        int arm = 0;
        String numStr = Integer.toString(n);
        int len = numStr.length();

        for (int i = 0; i < len; i++) {
            int digit = Character.getNumericValue(numStr.charAt(i)); // Extract digit
            arm += Math.pow(digit, len); // Raise to power of length
        }
       
        return arm == n;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = inp.nextInt();
        boolean arm =isArmstrong(n);
        System.out.println(arm);
    }
}
