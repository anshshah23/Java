package Arrays.Easy;

class plusOne {
    public int[] plusOneS(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        plusOne solution = new plusOne();
        int[] digits = { 1, 2, 3 };
        int[] result = solution.plusOneS(digits);
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}