package Strings;

class revStringInplace {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while(start<end){
            char temp = s[end];
            s[end--] = s[start];
            s[start++] = temp;
        }
    }
    public static void main(String[] args) {
        revStringInplace solution = new revStringInplace();
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s);
        System.out.println(s); // Output: ['o', 'l', 'l', 'e', 'h']
    }
}